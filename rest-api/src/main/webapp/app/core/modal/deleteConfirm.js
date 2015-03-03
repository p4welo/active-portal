define([
    'core/module'
], function (module) {

    module.controller('deleteConfirmDialogController', ['$scope', '$modalInstance', function ($scope, $modalInstance) {

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.confirm = function () {
            $modalInstance.close();
        };
    }]);
});