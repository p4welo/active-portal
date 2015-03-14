define([
    'jquery',
    'schedule/module',
    'services/categoryService'
], function ($, module) {

    module.controller('addCategoryController', ['$scope', '$modalInstance', 'categoryHttpClient', '$timeout', function ($scope, $modalInstance, categoryHttpClient, $timeout) {
        $scope.category = {};

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (category) {
            categoryHttpClient.create(category).$promise.then(
                function () {
                    $modalInstance.close();
                });
        };
        $scope.focusInput = function (id) {
            $timeout(function () {
                $(id).focus();
            }, 100);
        };
    }]);
});