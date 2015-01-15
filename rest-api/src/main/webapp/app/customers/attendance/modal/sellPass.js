define([
    'customers/module',
    'services/customerService'
], function (module) {

    module.controller('sellPassController', function ($scope, $modalInstance, customerHttpClient) {
        $scope.cancel = function () {
            $modalInstance.dismiss();
        }
        $scope.page = 0;

//        CUSTOMER
        $scope.newCustomer = {};
        $scope.customers = customerHttpClient.findAll();
        $scope.existingCustomer = true;
        $scope.setExistingCustomer = function (isExistingCustomer) {
            $scope.existingCustomer = isExistingCustomer;
        }
        $scope.selectCustomer = function (customer) {
            if ($scope.customer == customer) {
                $scope.customer = null;
                return;
            }
            $scope.customer = customer;
        }
        $scope.isValidCustomer = function () {
            var validNew = !$scope.existingCustomer
                && $scope.newCustomer.firstName != null
                && $scope.newCustomer.lastName != null
                && $scope.newCustomer.gender != null
                && $scope.newCustomer.mobile != null;

            var validExisting = $scope.existingCustomer && $scope.customer != null;
            return validNew || validExisting;
        }
        $scope.passPage = function () {
            $scope.page = 1;
        }

//        PASS
        $scope.customerPage = function () {
            $scope.page = 0;
        }
    });

});