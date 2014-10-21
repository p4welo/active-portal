define([
    'schedule/module',
    'services/courseService',
    'services/customerService'
], function (module) {

    module.controller('joinClassController', function ($scope, customer, courseFactory, customerFactory, $modalInstance) {
        $scope.day = '';
        $scope.customer = customer;
        $scope.classes = courseFactory.findInProgress();

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