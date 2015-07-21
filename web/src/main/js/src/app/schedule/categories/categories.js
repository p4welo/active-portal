angular.module('activePortal.schedule')

    .config(function ($stateProvider) {
        $stateProvider.state('categories', {
            url: "/categories",
            templateUrl: "schedule/categories/categories.tpl.html",
            controller: "categoriesCtrl"
        });
    })

    .controller('categoriesCtrl', function ($scope, $modal, categoryHttpClient, notificationService) {

        var NAME_KEY = "name";

        // =======================================
        $scope.categoryLoading = true;
        categoryHttpClient.findAll().$promise.then(
            function (result) {
                $scope.categories = result;
                $scope.categoryLoading = false;
            }
        );
        // =======================================
        $scope.sort = {
            column: 'code',
            descending: false
        };
        $scope.toggleSort = function (column) {
            var sort = $scope.sort;
            if (sort.column == column) {
                sort.descending = !sort.descending;
            } else {
                sort.column = column;
                sort.descending = false;
            }
        };
        $scope.sortIcon = function (column) {
            var sort = $scope.sort;
            if (sort.column == column) {
                return sort.descending ? "fa fa-caret-down" : "fa fa-caret-up";
            }
            return "";
        };
        // =======================================
        $scope.add = function () {
            $modal.open(
                {
                    templateUrl: 'schedule/categories/modal/addCategory.tpl.html',
                    controller: "addCategoryCtrl",
                    backdrop: 'static'
                }
            ).result.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    return categoryHttpClient.findAll().$promise;
                }
            ).then(
                function (result) {
                    $scope.categories = result;
                }
            );
        };
        // =======================================
        $scope.select = function (category) {
            if ($scope.selected !== undefined && $scope.selected.sid == category.sid) {
                $scope.selected = undefined;
                return;
            }
            $scope.selected = angular.copy(category);
        };
        $scope.save = function (object, property, callback) {
            if (property == NAME_KEY) {
                var obj = _.findWhere($scope.categories, {sid: object.sid});
                if (obj) {
                    obj[NAME_KEY] = object[NAME_KEY];
                    categoryHttpClient.update({sid: object.sid}, obj).$promise.then(
                        function () {
                            notificationService.success("Pomyślnie zapisano");
                            callback();
                            return categoryHttpClient.findAll().$promise;
                        }
                    ).then(
                        function (result) {
                            $scope.categories = result;
                        }
                    );
                }
            }
        };
        // =======================================
        $scope.delete = function (category) {
            if (angular.isObject(category)) {
                $modal.open(
                    {
                        templateUrl: 'common/modal/deleteConfirm.tpl.html',
                        controller: "deleteConfirmDialogCtrl",
                        backdrop: 'static'
                    }
                ).result.then(
                    function () {
                        $scope.selected = undefined;
                        return categoryHttpClient.delete({sid: category.sid}).$promise;
                    }
                ).then(
                    function () {
                        notificationService.success("Pomyślnie usunięto");
                        return categoryHttpClient.findAll().$promise;
                    }
                ).then(
                    function (result) {
                        $scope.categories = result;
                    }
                );
            }
        };
    })
;