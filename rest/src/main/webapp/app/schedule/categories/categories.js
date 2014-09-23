define([
    'schedule/module',
    'schedule/categories/modal/addCategory',
    'services/notificationService',
    'services/categoryService'
], function (module) {

    module.controller("categoriesController", function ($scope, $modal, categoryFactory, notificationService) {
        $scope.categories = categoryFactory.find();

        $scope.add = function() {
            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/schedule/categories/modal/addCategory.html',
                    controller: "addCategoryController"
                });

            modalInstance.result.then(function () {
                $scope.categories = categoryFactory.find();
                notificationService.success("Pomyślnie zapisano");
            });
        };
    });
});