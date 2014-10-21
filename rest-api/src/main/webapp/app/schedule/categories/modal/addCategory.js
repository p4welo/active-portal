define([
    'schedule/module',
    'services/categoryService'
], function (module) {

    module.controller('addCategoryController', function ($scope, $modalInstance, categoryFactory) {
        $scope.category = {};

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (category) {
            categoryFactory.create(category).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }
    });

});