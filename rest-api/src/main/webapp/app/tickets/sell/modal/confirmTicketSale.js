define([
    'tickets/module'
], function (module) {

    module.controller('confirmTicketSaleDialogController', ['customer', 'ticket', '$scope', '$modalInstance', function (customer, ticket, $scope, $modalInstance) {

        $scope.customer = customer;
        $scope.ticket = ticket;

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.confirm = function () {

            $modalInstance.close();
        };
    }]);
});