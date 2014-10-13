define([
    'customers/module',
    'customers/customerBase/modal/subscribeClass',
    'customers/customerBase/modal/joinClass',
    'customers/customerBase/modal/addCustomer',
    'services/customerService'
], function (module) {

    module.controller("customerBaseController", function ($scope, $modal, customerFactory) {
        $scope.select = function (customer) {
            if ($scope.selected == customer) {
                $scope.selected = null;
                return;
            }
            $scope.selected = customer;
            $scope.selected.edit = false;
            $scope.customerPresence = customerFactory.findCustomerPresence(customer);
        }

        $scope.subscribe = function (customer) {
            $modal.open(
                {
                    templateUrl: 'app/customers/customerBase/modal/subscribeClass.html',
                    controller: "subscribeClassController",
                    size: 'lg'
                });
        };

        $scope.join = function (customer) {
            $modal.open(
                {
                    templateUrl: 'app/customers/customerBase/modal/joinClass.html',
                    controller: "joinClassController",
                    size: 'lg'
                });
        };

        $scope.add = function () {
            $modal.open(
                {
                    templateUrl: 'app/customers/customerBase/modal/addCustomer.html',
                    controller: "addCustomerController"
                });
        }

        $scope.customers = customerFactory.findCustomers();
    });
});