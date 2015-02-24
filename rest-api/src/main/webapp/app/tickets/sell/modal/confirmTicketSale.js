define([
    'tickets/module'
], function (module) {

    module.controller('confirmTicketSaleDialogController', ['$scope', '$modalInstance', function ($scope, $modalInstance) {


        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.confirm = function () {

            $modalInstance.close();
        };
    }]);
});