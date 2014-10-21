define([
    'schedule/module',
    'services/courseService',
    'services/customerService'
], function (module) {

    module.controller('subscribeClassController', function ($scope, customer, customerHttpClient, $modalInstance) {
        $scope.day = '';
        $scope.customer = customer;
        $scope.classes = customerHttpClient.coursesToRegister({ sid: customer.sid });

        $scope.select = function (course) {
            if ($scope.selected == course) {
                $scope.selected = null;
                return;
            }
            $scope.selected = course;
        }

        $scope.subscribe = function (course) {
            customerHttpClient.subscribe({ sid: $scope.customer.sid }, course).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }

        $scope.cancel = function () {
            $modalInstance.dismiss();
        }
    });

});