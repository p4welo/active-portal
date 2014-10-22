define([
    'schedule/module',
    'services/categoryService',
    'services/styleService'
], function (module) {

    module.controller('addStyleController', function ($scope, $modalInstance, categoryHttpClient, styleHttpClient) {
        $scope.style = {};
        $scope.categories = categoryHttpClient.find();

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (style) {
            styleHttpClient.create(style).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }
    });

});