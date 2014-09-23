define([
    'schedule/module',
    'services/styleService'
], function (module) {

    module.controller('addStyleController', function ($scope, $modalInstance, styleFactory) {
        $scope.style = {};

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (style) {
            styleFactory.create(style);
            $modalInstance.close();
        }
    });

});