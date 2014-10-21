define([
    'schedule/module',
    'services/courseService',
    'services/customerService'
], function (module) {

    module.controller('joinClassController', function ($scope, customer, customerFactory, $modalInstance) {
        $scope.day = '';
        $scope.customer = customer;
        $scope.classes = customerFactory.coursesToJoin({ sid: customer.sid });

        $scope.select = function (course) {
            if ($scope.selected == course) {
                $scope.selected = null;
                return;
            }
            $scope.selected = course;
        }

        $scope.join = function (course) {
            customerFactory.join({ sid: $scope.customer.sid }, course).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }

        $scope.cancel = function () {
            $modalInstance.dismiss();
        }
    });
});