define([
    'schedule/module',
    'schedule/categories/modal/addCategory',
    'services/notificationService',
    'services/categoryService'
], function (module) {

    module.controller("categoriesController", function ($scope, $modal, categoryHttpClient, categoryService, notificationService) {
        $scope.categories = categoryHttpClient.findAll();

        $scope.add = function() {
            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/schedule/categories/modal/addCategory.html',
                    controller: "addCategoryController"
                });

            modalInstance.result.then(function () {
                $scope.categories = categoryHttpClient.findAll();
                notificationService.success("Pomyślnie zapisano");
            });
        };

        $scope.select = function (category) {
            if ($scope.selected != null && $scope.selected.sid == category.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selected = categoryService.copyProperties(category);
            $scope.selected.edit = false;
        }

        $scope.update = function (category) {
            delete category['edit'];
            categoryHttpClient.update({ sid: category.sid }, category).$promise.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    $scope.categories = categoryHttpClient.findAll();
                });
        }

        $scope.resolveStatusCss = function (category) {
            return {'label-success': category.objectState == 'ACTIVE', 'label-danger': category.objectState == 'INACTIVE'}
        }
    });
});