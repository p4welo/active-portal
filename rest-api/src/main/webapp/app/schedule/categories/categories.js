define([
    'angular',
    'schedule/module',
    'schedule/categories/modal/addCategory',
    'services/notificationService',
    'services/categoryService'
], function (angular, module) {
    "use strict";

    module.controller("categoriesController", ['$scope', '$modal', 'categoryHttpClient', 'notificationService', function ($scope, $modal, categoryHttpClient, notificationService) {

        var NAME_KEY = "name";
        var OBJECT_PROPERTIES = [NAME_KEY];

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
            var modalInstance = $modal.open({
                templateUrl: 'dist/app/schedule/categories/modal/addCategory.html',
                controller: "addCategoryController"
            });

            modalInstance.result.then(function () {
                notificationService.success("Pomyślnie zapisano");
                categoryHttpClient.findAll().$promise.then(
                    function (result) {
                        $scope.categories = result;
                    });
            });
        };
        // =======================================
        $scope.select = function (category) {
            if ($scope.selected !== undefined && $scope.selected.sid == category.sid) {
                $scope.selected = undefined;
                return;
            }
            $scope.selected = angular.copy(category);

            for (var i = 0; i < OBJECT_PROPERTIES.length; i++) {
                $scope.selected[OBJECT_PROPERTIES[i]] = {
                    value: category[OBJECT_PROPERTIES[i]],
                    edit: false,
                    saving: false,
                    hover: false,
                    oldVal: {}
                };
            }
        };
        $scope.edit = function (object, property) {
            object[property].edit = true;
            object[property].oldVal = object[property].value;
        };
        $scope.cancel = function (object, property) {
            object[property].value = object[property].oldVal;
            object[property].edit = false;
            object[property].hover = false;
        };
        $scope.hover = function (object, property) {
            object[property].hover = true;
        };
        $scope.leave = function (object, property) {
            object[property].hover = false;
        };
        $scope.save = function (object, property) {
            object[property].saving = true;
            if (property == NAME_KEY) {
                var obj = _.findWhere($scope.categories, {sid: object.sid});
                obj[NAME_KEY] = object[NAME_KEY].value;
                if (obj !== undefined) {
                    categoryHttpClient.update({ sid: object.sid }, obj).$promise.then(
                        function () {
                            object[property].edit = false;
                            object[property].saving = false;
                            object[property].hover = false;

                            notificationService.success("Pomyślnie zapisano");
                            categoryHttpClient.findAll().$promise.then(
                                function (result) {
                                    $scope.categories = result;
                                });
                        });
                }
            }
        };
        // =======================================
        $scope.delete = function (category) {
            if (category !== undefined) {
                var modalInstance = $modal.open({
                    templateUrl: 'dist/app/core/modal/deleteConfirm.html',
                    controller: "deleteConfirmDialogController"
                });

                modalInstance.result.then(function () {
                    $scope.selected = undefined;
                    categoryHttpClient.delete({sid: category.sid}).$promise.then(
                        function () {
                            notificationService.success("Pomyślnie usunięto");
                            categoryHttpClient.findAll().$promise.then(
                                function (result) {
                                    $scope.categories = result;
                                });
                        }
                    );
                });
            }
        };
    }]);
});