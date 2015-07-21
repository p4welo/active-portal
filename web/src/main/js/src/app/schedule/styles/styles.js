angular.module('activePortal.schedule')

    .config(function ($stateProvider) {
        $stateProvider.state('styles', {
            url: "/styles",
            templateUrl: "schedule/styles/styles.tpl.html",
            controller: "stylesCtrl"
        });
    })

    .controller('stylesCtrl', function ($scope, $modal, styleHttpClient, categoryHttpClient, notificationService) {
        var CATEGORY_KEY = "category";
        var NAME_KEY = "name";

        var OBJECT_PROPERTIES = [CATEGORY_KEY, NAME_KEY];

        // =======================================
        $scope.styleLoading = true;
        styleHttpClient.findAll().$promise.then(
            function (result) {
                $scope.styles = result;
                $scope.styleLoading = false;
                return categoryHttpClient.findAll().$promise;
            }
        ).then(
            function (result) {
                $scope.categories = result;
            }
        );

        // =======================================
        $scope.sort = {
            column: 'name',
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
                    templateUrl: 'schedule/styles/modal/addStyle.tpl.html',
                    controller: "addStyleCtrl",
                    backdrop: 'static'
                }
            ).result.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    return styleHttpClient.findAll().$promise;

                }
            ).then(
                function (result) {
                    $scope.styles = result;
                }
            );
        };
        $scope.delete = function (style) {
            if (angular.isObject(style)) {
                $modal.open(
                    {
                        templateUrl: 'schedule/styles/modal/deleteStyle.tpl.html',
                        controller: "deleteStyleCtrl",
                        resolve: {
                            courses: function () {
                                return style.courses;
                            }
                        },
                        backdrop: 'static'
                    }
                ).result.then(
                    function () {
                        return styleHttpClient.delete({sid: style.sid}).$promise;
                    }
                ).then(
                    function () {
                        notificationService.success("Pomyślnie usunięto");
                        return styleHttpClient.findAll().$promise;
                    }
                ).then(
                    function (result) {
                        $scope.styles = result;
                    }
                );
            }
        };
        // =======================================
        $scope.select = function (object) {
            if (angular.isObject($scope.selected) && $scope.selected.sid == object.sid) {
                $scope.selected = undefined;
                return;
            }
            $scope.selected = angular.copy(object);

            $scope.courseLoading = true;
            styleHttpClient.findActiveCourses({sid: object.sid}).$promise.then(
                function (result) {
                    $scope.courseLoading = false;
                    $scope.selected.courses = result;
                }
            );
        };
        $scope.save = function (object, property, callback) {
            if (property == CATEGORY_KEY) {
                styleHttpClient.setCategory({sid: object.sid}, object.category).$promise.then(
                    function () {
                        notificationService.success("Pomyślnie zapisano");
                        callback();
                        return styleHttpClient.findAll().$promise;
                    }
                ).then(
                    function (result) {
                        $scope.styles = result;
                    }
                );
            }
            else if (property == NAME_KEY) {
                var obj = _.findWhere($scope.styles, {sid: object.sid});
                obj.name = object.name;
                if (angular.isObject(obj)) {
                    styleHttpClient.update({sid: object.sid}, obj).$promise.then(
                        function () {
                            notificationService.success("Pomyślnie zapisano");
                            callback();
                            return styleHttpClient.findAll().$promise;
                        }
                    ).then(
                        function (result) {
                            $scope.styles = result;
                        }
                    );
                }
            }
        };
    })
;