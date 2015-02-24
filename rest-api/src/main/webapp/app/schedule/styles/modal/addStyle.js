define([
    'schedule/module',
    'services/categoryService',
    'services/styleService'
], function (module) {

    module.controller('addStyleController', ['$scope', '$modalInstance', 'categoryHttpClient', 'styleHttpClient', function ($scope, $modalInstance, categoryHttpClient, styleHttpClient) {
        $scope.style = {};
        $scope.categories = categoryHttpClient.findAll();

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (style) {
            styleHttpClient.create(style).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }
    }]);
});