define([
    'customers/module',
    'customers/customerBase/modal/subscribeClass',
    'customers/customerBase/modal/joinClass',
    'customers/customerBase/modal/addCustomer',
    'services/customerService',
    'services/notificationService'
], function (module) {

    module.controller("customerBaseController", function ($scope, $modal, customerHttpClient, customerService, notificationService) {
        $scope.customers = customerHttpClient.findAll();

        $scope.select = function (customer) {
            if ($scope.selected != null && $scope.selected.sid == customer.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selected = customerService.copyProperties(customer);
            $scope.customerPresence = customerHttpClient.presence(customer);
            $scope.customerCourses = customerHttpClient.courses(customer);
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
                $scope.customers = customerHttpClient.findAll();
            });
        }

        $scope.update = function (customer) {
            delete customer['edit'];
            customerHttpClient.update({ sid: customer.sid }, customer).$promise.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    $scope.customers = customerHttpClient.findAll();
                });
        }
    });
});