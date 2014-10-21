define([
    'schedule/module',
    'services/courseService',
    'services/customerService'
], function (module) {

    module.controller('subscribeClassController', function ($scope, customer, courseFactory, courseService, customerFactory, $modalInstance) {
        $scope.day = '';
        $scope.customer = customer;
        $scope.classes = courseFactory.findRegistration();

        $scope.select = function (course) {
            if ($scope.selected == course) {
                $scope.selected = null;
                return;
            }
            $scope.selected = course;
        }

        $scope.subscribe = function (course) {
            customerFactory.subscribe({ sid: $scope.customer.sid }, course).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }

        $scope.cancel = function () {
            $modalInstance.dismiss();
        }
    });

});