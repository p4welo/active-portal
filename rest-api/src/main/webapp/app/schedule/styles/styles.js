define([
    'schedule/module',
    'lodash',
    'schedule/styles/modal/addStyle',
    'schedule/styles/modal/deleteStyle',
    'services/styleService',
    'services/categoryService',
    'services/notificationService'
], function (module, _) {

    module.controller("stylesController", ['$scope', '$modal', 'styleHttpClient', 'categoryHttpClient', 'notificationService', function ($scope, $modal, styleHttpClient, categoryHttpClient, notificationService) {

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
        $scope.toggleSort = function(column) {
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
        }

        // =======================================
        $scope.add = function () {
            var modalInstance = $modal.open({
                templateUrl: 'app/schedule/styles/modal/addStyle.html',
                controller: "addStyleController"
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
            var modalInstance = $modal.open({
                templateUrl: 'app/schedule/styles/modal/deleteStyle.html',
                controller: "deleteStyleController",
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
                            })
                    }
                )
            });
        }
        // =======================================
        $scope.select = function (object) {
            if ($scope.selected != null && $scope.selected.sid == object.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selected = angular.copy(object);

            for (var i = 0; i < OBJECT_PROPERTIES.length; i++) {
                $scope.selected[OBJECT_PROPERTIES[i]] = {
                    value: object[OBJECT_PROPERTIES[i]],
                    edit: false,
                    saving: false,
                    hover: false,
                    oldVal: {}
                }
            }
            $scope.courseLoading = true;
            styleHttpClient.findActiveCourses({sid: object.sid}).$promise.then(
                function (result) {
                    $scope.courseLoading = false;
                    $scope.selected.courses = result;
                }
            )
        }
        $scope.edit = function (object, property) {
            object[property].edit = true;
            object[property].oldVal = object[property].value;
        }
        $scope.cancel = function (object, property) {
            object[property].value = object[property].oldVal;
            object[property].edit = false;
            object[property].hover = false;
        }
        $scope.save = function (object, property) {
            object[property].saving = true;
            if (property == CATEGORY_KEY) {
                styleHttpClient.setCategory({sid: object.sid}, object.category.value).$promise.then(
                    function () {
                        object[property].edit = false;
                        object[property].saving = false;
                        object[property].hover = false;

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
                if (obj != null) {
                    styleHttpClient.update({ sid: object.sid }, obj).$promise.then(
                        function () {
                            object[property].edit = false;
                            object[property].saving = false;
                            object[property].hover = false;

                            notificationService.success("Pomyślnie zapisano");
                            styleHttpClient.findAll().$promise.then(
                                function (result) {
                                    $scope.styles = result;
                                });
                        });
                }
            }
        }
        $scope.hover = function (object, property) {
            object[property].hover = true;
        }
        $scope.leave = function (object, property) {
            object[property].hover = false;
        }
    }]);
});