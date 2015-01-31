define([
    'core/module'
], function (module) {

    module.controller('deleteConfirmDialogController', function ($scope, $modalInstance) {

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.confirm = function () {
            $modalInstance.close();
        }
    })
});