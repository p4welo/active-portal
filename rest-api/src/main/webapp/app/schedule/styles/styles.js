define([
    'schedule/module',
    'lodash',
    'schedule/styles/modal/addStyle',
    'schedule/styles/modal/deleteStyle',
    'services/styleService',
    'services/categoryService',
    'services/notificationService'
], function (module, _) {

    module.controller("stylesController", function ($scope, $modal, styleHttpClient, categoryHttpClient, notificationService) {

        var CATEGORY_KEY = "category";
        var NAME_KEY = "name";
        var OBJECT_PROPERTIES = [CATEGORY_KEY, NAME_KEY];

        $scope.styles = styleHttpClient.findAll();
        $scope.categories = categoryHttpClient.findAll();

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

        $scope.select = function (style) {
            if ($scope.selected != null && $scope.selected.sid == style.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selected = angular.copy(style);

            for (var i = 0; i < OBJECT_PROPERTIES.length; i++) {
                $scope.selected[OBJECT_PROPERTIES[i]] = {
                    value: style[OBJECT_PROPERTIES[i]],
                    edit: false,
                    saving: false,
                    hover: false,
                    oldVal: {}
                }
            }
            styleHttpClient.findCourses({sid: style.sid}).$promise.then(
                function (result) {
                    $scope.selected.courses = result;
                }
            )
        }
        $scope.edit = function (style, property) {
            style[property].edit = true;
            style[property].oldVal = style[property].value;
        }
        $scope.cancel = function (style, property) {
            style[property].value = style[property].oldVal;
            style[property].edit = false;
            style[property].hover = false;
        }
        $scope.save = function (style, property) {
            style[property].saving = true;
            if (property == CATEGORY_KEY) {
                styleHttpClient.setCategory({sid: style.sid}, style.category.value).$promise.then(
                    function () {
                        style[property].edit = false;
                        style[property].saving = false;
                        style[property].hover = false;

                        notificationService.success("Pomyślnie zapisano");
                        styleHttpClient.findAll().$promise.then(
                            function (result) {
                                $scope.styles = result;
                            });
                    });
            }
            else if (property == NAME_KEY) {
                var obj = _.findWhere($scope.styles, {sid: style.sid});
                obj.name = style.name.value;
                if (obj != null) {
                    styleHttpClient.update({ sid: style.sid }, obj).$promise.then(
                        function () {
                            style[property].edit = false;
                            style[property].saving = false;
                            style[property].hover = false;

                            notificationService.success("Pomyślnie zapisano");
                            styleHttpClient.findAll().$promise.then(
                                function (result) {
                                    $scope.styles = result;
                                });
                        });
                }
            }
        }
        $scope.hover = function (style, property) {
            style[property].hover = true;
        }
        $scope.leave = function (style, property) {
            style[property].hover = false;
        }
    });
})
;