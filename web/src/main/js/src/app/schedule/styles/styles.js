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
            }
        );
        $scope.categories = categoryHttpClient.findAll();

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
            var modalInstance = $modal.open({
                templateUrl: 'schedule/styles/modal/addStyle.tpl.html',
                controller: "addStyleCtrl"
            });

            modalInstance.result.then(function () {
                styleHttpClient.findAll().$promise.then(
                    function (result) {
                        $scope.styles = result;
                    });
                notificationService.success("Pomyślnie zapisano");
            });
        };
        $scope.delete = function (style) {
            if (style !== undefined) {
                var modalInstance = $modal.open({
                    templateUrl: 'schedule/styles/modal/deleteStyle.tpl.html',
                    controller: "deleteStyleCtrl",
                    resolve: {
                        courses: function () {
                            return style.courses;
                        }
                    }
                });

                modalInstance.result.then(function () {
                    styleHttpClient.delete({sid: style.sid}).$promise.then(
                        function () {
                            notificationService.success("Pomyślnie usunięto");
                            styleHttpClient.findAll().$promise.then(
                                function (result) {
                                    $scope.styles = result;
                                });
                        }
                    );
                });
            }
        };
        // =======================================
        $scope.select = function (object) {
            if ($scope.selected !== undefined && $scope.selected.sid == object.sid) {
                $scope.selected = undefined;
                return;
            }
            $scope.selected = angular.copy(object);

            for (var i = 0; i < OBJECT_PROPERTIES.length; i++) {
                $scope.selected[OBJECT_PROPERTIES[i]] = {
                    value: object[OBJECT_PROPERTIES[i]],
                    edit: false,
                    saving: false,
                    oldVal: {}
                };
            }
            $scope.courseLoading = true;
            styleHttpClient.findActiveCourses({sid: object.sid}).$promise.then(
                function (result) {
                    $scope.courseLoading = false;
                    $scope.selected.courses = result;
                }
            );
        };
        $scope.edit = function (object, property) {
            object[property].edit = true;
            object[property].oldVal = object[property].value;
        };
        $scope.cancel = function (object, property) {
            object[property].value = object[property].oldVal;
            object[property].edit = false;
        };
        $scope.save = function (object, property) {
            object[property].saving = true;
            if (property == CATEGORY_KEY) {
                styleHttpClient.setCategory({sid: object.sid}, object.category.value).$promise.then(
                    function () {
                        object[property].edit = false;
                        object[property].saving = false;

                        notificationService.success("Pomyślnie zapisano");
                        styleHttpClient.findAll().$promise.then(
                            function (result) {
                                $scope.styles = result;
                            });
                    });
            }
            else if (property == NAME_KEY) {
                var obj = _.findWhere($scope.styles, {sid: object.sid});
                obj.name = object.name.value;
                if (obj !== undefined) {
                    styleHttpClient.update({ sid: object.sid }, obj).$promise.then(
                        function () {
                            object[property].edit = false;
                            object[property].saving = false;

                            notificationService.success("Pomyślnie zapisano");
                            styleHttpClient.findAll().$promise.then(
                                function (result) {
                                    $scope.styles = result;
                                });
                        });
                }
            }
        };
    })
;