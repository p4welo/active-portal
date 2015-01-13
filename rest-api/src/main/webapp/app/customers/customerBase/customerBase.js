define([
    'customers/module',
    'customers/customerBase/modal/subscribeClass',
    'customers/customerBase/modal/joinClass',
    'customers/customerBase/modal/addCustomer',
    'services/customerService',
    'services/notificationService'
], function (module) {

    module.controller("customerBaseController", function ($scope, $modal, customerHttpClient, customerFactory, notificationService, $state) {
        $scope.customers = customerHttpClient.findAll();

        $scope.select = function (customer) {
            if ($scope.selected != null && $scope.selected.sid == customer.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selected = angular.copy(customer);
            customerHttpClient.presence(customer).$promise.then(
                function (result) {
                    $scope.customerPresence = result;
                }
            );
            customerHttpClient.courses(customer).$promise.then(
                function (result) {
                    $scope.customerCourses = result;
                }
            );
            $scope.selected.edit = false;
        }

        $scope.subscribe = function (customer) {
            var modalInstance = $modal.open({
                templateUrl: 'app/customers/customerBase/modal/subscribeClass.html',
                controller: "subscribeClassController",
                size: 'lg',
                resolve: {
                    customer: function () {
                        return customer;
                    }
                }
            });

            modalInstance.result.then(function () {
                notificationService.success("Pomyślnie zapisano");
                customerHttpClient.courses(customer).$promise.then(
                    function (result) {
                        $scope.customerCourses = result;
                    }
                );
            });
        };

        $scope.join = function (customer) {
            var modalInstance = $modal.open({
                templateUrl: 'app/customers/customerBase/modal/joinClass.html',
                controller: "joinClassController",
                size: 'lg',
                resolve: {
                    customer: function () {
                        return customer;
                    }
                }
            });

            modalInstance.result.then(function () {
                notificationService.success("Pomyślnie zapisano");
                customerHttpClient.courses(customer).$promise.then(
                    function (result) {
                        $scope.customerCourses = result;
                    }
                );
            });
        };

        $scope.add = function () {
            var modalInstance = $modal.open({
                templateUrl: 'app/customers/customerBase/modal/addCustomer.html',
                controller: "addCustomerController"
            });

            modalInstance.result.then(function () {
                notificationService.success("Pomyślnie zapisano");
                customerHttpClient.findAll().$promise.then(
                    function (result) {
                        $scope.customers = result;
                    }
                );
            });
        }

        $scope.update = function (customer) {
            delete customer['edit'];
            customerHttpClient.update({ sid: customer.sid }, customer).$promise.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    customerHttpClient.findAll().$promise.then(
                        function (result) {
                            $scope.customers = result;
                        }
                    );
                });
        }

        $scope.customerDetails = function (customer) {
            customerFactory.setCustomer(customer);
            $state.go("customerDetails", {sid: customer.sid})
        }
    });
});