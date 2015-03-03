define([
    'customers/module',
    'customers/customerBase/modal/subscribeClass',
    'customers/customerBase/modal/joinClass',
    'customers/customerBase/modal/addCustomer',
    'services/customerService',
    'services/notificationService'
], function (module) {

    module.controller("customerBaseController", ['$scope', '$modal', 'customerHttpClient', 'customerFactory', 'notificationService', '$state', function ($scope, $modal, customerHttpClient, customerFactory, notificationService, $state) {
        $scope.customers = customerHttpClient.findAll();

        $scope.select = function (customer) {
            if ($scope.selected !== undefined && $scope.selected.sid == customer.sid) {
                $scope.selected = undefined;
                return;
            }
            $scope.selected = angular.copy(customer);
            customerHttpClient.courses(customer).$promise.then(
                function (result) {
                    $scope.customerCourses = result;
                }
            );
            $scope.selected.edit = false;
        };

        $scope.add = function () {
            var modalInstance = $modal.open({
                templateUrl: 'app/customers/customerBase/modal/addCustomer.html',
                controller: "addCustomerController",
                size: 'lg'
            });

            modalInstance.result.then(function () {
                notificationService.success("Pomyślnie zapisano");
                customerHttpClient.findAll().$promise.then(
                    function (result) {
                        $scope.customers = result;
                    }
                );
            });
        };

        $scope.update = function (customer) {
            delete customer.edit;
            customerHttpClient.update({ sid: customer.sid }, customer).$promise.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    customerHttpClient.findAll().$promise.then(
                        function (result) {
                            $scope.customers = result;
                        }
                    );
                });
        };
        $scope.delete = function (customer) {
            delete customer.edit;
            customerHttpClient.delete({ sid: customer.sid }).$promise.then(
                function () {
                    $scope.selected = null;
                    customerHttpClient.findAll().$promise.then(
                        function (result) {
                            $scope.customers = result;
                            notificationService.success("Pomyślnie usunięto");
                        }
                    );
                });
        };

        $scope.customerProfile = function (customer) {
            customerFactory.setCustomer(customer);
            $state.go("customerProfile", {sid: customer.sid});
        };
    }]);
});