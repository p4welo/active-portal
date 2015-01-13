define([
    'schedule/module',
    'services/customerService'
], function (module) {

    module.controller('addCustomerController', function ($scope, customerHttpClient, $modalInstance) {
        $scope.page = 0;
        $scope.customer = {};
        $scope.courses = [];
        $scope.day = 'PN';

//        WIDOK 0
        $scope.createCustomer = function (customer) {
            customerHttpClient.create(customer).$promise.then(
                function (result) {
                    $scope.customer = result;
                    $scope.courses = customerHttpClient.coursesToJoin({ sid: result.sid });
                    $scope.page = 1;

                });
        }
        $scope.isNotValid = function (customer) {
            return customer == null || customer.firstName == null || customer.lastName == null || customer.gender == null || customer.mobile == null;
        }

        $scope.cancel = function () {
            $modalInstance.dismiss();
        }
        $scope.close = function () {
            $modalInstance.close();
        }

//        WIDOK 1
        $scope.selectCourse = function (course) {
            if ($scope.selected == course) {
                $scope.selected = null;
                return;
            }
            $scope.selected = course;
        }
        $scope.setDay = function (day) {
            $scope.selected = null;
            $scope.day = day;
        }
        $scope.subscribe = function (course) {
            customerHttpClient.subscribe({ sid: $scope.customer.sid }, course).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }
    });
});