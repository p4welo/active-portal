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
            $scope.customerPresence = customerFactory.findCustomerPresence(customer);
            $scope.selected.edit == false;
        }
        $scope.deselect = function () {
            $scope.selected = null;
            return;
        }

        $scope.subscribe = function (customer) {
            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/customers/customerBase/modal/subscribeClass.html',
                    controller: "subscribeClassController",
                    size: 'lg'
                });

            modalInstance.result.then(function () {

            });
        };

        $scope.join = function (customer) {
            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/customers/customerBase/modal/joinClass.html',
                    controller: "joinClassController",
                    size: 'lg'
                });

            modalInstance.result.then(function () {

            });
        };

        $scope.add = function () {
            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/customers/customerBase/modal/addCustomer.html',
                    controller: "addCustomerController"
                });

            modalInstance.result.then(function () {

            });
        }

        $scope.customers = customerFactory.findCustomers();
    });
});