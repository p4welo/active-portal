define([
    'customers/module',
    'services/customerService',
    'services/ticketService'
], function (module) {

    module.controller('sellPassController', ['$scope', '$modalInstance', 'customerHttpClient', 'ticketService', function ($scope, $modalInstance, customerHttpClient, ticketService) {
        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
        $scope.page = 0;

//        CUSTOMER
        $scope.newCustomer = {};
        $scope.customers = customerHttpClient.findAll();
        $scope.existingCustomer = true;
        $scope.setExistingCustomer = function (isExistingCustomer) {
            $scope.existingCustomer = isExistingCustomer;
        };
        $scope.selectCustomer = function (customer) {
            if ($scope.customer == customer) {
                $scope.customer = null;
                return;
            }
            $scope.customer = customer;
        };
        $scope.isValidCustomer = function () {
            var validNew = !$scope.existingCustomer &&
                $scope.newCustomer.firstName !== undefined &&
                $scope.newCustomer.lastName !== undefined &&
                $scope.newCustomer.gender !== undefined &&
                $scope.newCustomer.mobile !== undefined;

            var validExisting = $scope.existingCustomer && $scope.customer !== undefined;
            return validNew || validExisting;
        };
        $scope.passPage = function () {
            $scope.page = 1;
        };

//        PASS
        $scope.tickets = ticketService.getTickets();
        $scope.customerPage = function () {
            $scope.page = 0;
        };
    }]);

});