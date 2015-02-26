define([
    'schedule/module',
    'services/categoryService'
], function (module) {

    module.controller('addCategoryController', ['$scope', '$modalInstance', 'categoryHttpClient', function ($scope, $modalInstance, categoryHttpClient) {
        $scope.category = {};

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (category) {
            categoryHttpClient.create(category).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }
    }]);
});