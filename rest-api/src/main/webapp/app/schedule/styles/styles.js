define([
    'schedule/module',
    'schedule/styles/modal/addStyle',
    'services/styleService',
    'services/categoryService',
    'services/notificationService'
], function (module) {

    module.controller("stylesController", function ($scope, $modal, styleHttpClient, categoryHttpClient, notificationService) {

        var EDIT_STYLE_KEY = 'edit';
        var EDIT_CATEGORY_KEY = 'editcategory';

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

        $scope.select = function (style) {
            if ($scope.selected != null && $scope.selected.sid == style.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selected = angular.copy(style);
            $scope.selected[EDIT_STYLE_KEY] = false;
            $scope.selected[EDIT_CATEGORY_KEY] = false;
        }

        $scope.editCategory = function (style) {
            style[EDIT_CATEGORY_KEY] = true;
            $scope.category = style.category;
        }

        $scope.setCategory = function (style) {
            styleHttpClient.setCategory({sid: style.sid}, style.category).$promise.then(
                function () {
                    style[EDIT_CATEGORY_KEY] = false;
                    styleHttpClient.findAll().$promise.then(
                        function (result) {
                            $scope.styles = result;
                        });
                    notificationService.success("Pomyślnie zapisano");
                });
        }

        $scope.update = function (style) {
            delete style[EDIT_STYLE_KEY];
            delete style[EDIT_CATEGORY_KEY];

            styleHttpClient.update({ sid: style.sid }, style).$promise.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    styleHttpClient.findAll().$promise.then(
                        function (result) {
                            $scope.styles = result;
                        });
                });
        }
    });
});