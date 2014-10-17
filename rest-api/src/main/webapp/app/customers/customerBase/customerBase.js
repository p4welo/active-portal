define([
    'customers/module',
    'customers/customerBase/modal/subscribeClass',
    'customers/customerBase/modal/joinClass',
    'customers/customerBase/modal/addCustomer',
    'services/customerService',
    'services/notificationService'
], function (module) {

    module.controller("customerBaseController", function ($scope, $modal, customerFactory, customerService, notificationService) {
        $scope.customers = customerFactory.findAll();

        $scope.select = function (customer) {
            if ($scope.selected != null && $scope.selected.sid == customer.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selected = customerService.copyProperties(customer);
            $scope.selected.edit = false;
            $scope.customerPresence = [];//customerFactory.findCustomerPresence(customer);
        }

        $scope.subscribe = function (customer) {
            $modal.open({
                templateUrl: 'app/customers/customerBase/modal/subscribeClass.html',
                controller: "subscribeClassController",
                size: 'lg'
            });
        };

        $scope.join = function (customer) {
            $modal.open({
                templateUrl: 'app/customers/customerBase/modal/joinClass.html',
                controller: "joinClassController",
                size: 'lg'
            });
        };

        $scope.add = function () {
            var modalInstance = $modal.open({
                templateUrl: 'app/customers/customerBase/modal/addCustomer.html',
                controller: "addCustomerController"
            });

            modalInstance.result.then(function () {
                $scope.customers = customerFactory.findAll();
                notificationService.success("Pomyślnie zapisano");
            });
        }

        $scope.update = function (customer) {
            delete customer['edit'];
            customerFactory.update({ sid: customer.sid }, customer).$promise.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    $scope.customers = customerFactory.findAll();
                });
        }
    });
});