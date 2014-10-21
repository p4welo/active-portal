define([
    'schedule/module',
    'services/categoryService',
    'services/styleService'
], function (module) {

    module.controller('addStyleController', function ($scope, $modalInstance, categoryFactory, styleFactory) {
        $scope.style = {};
        $scope.categories = categoryFactory.find();

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (style) {
            styleFactory.create(style).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }
    });

});