define([
    'schedule/module',
    'services/courseService',
    'services/customerService'
], function (module) {

    module.controller('joinClassController', ['$scope', 'customer', 'customerHttpClient', '$modalInstance', function ($scope, customer, customerHttpClient, $modalInstance) {
        $scope.day = '';
        $scope.customer = customer;
        $scope.classes = customerHttpClient.coursesToJoin({ sid: customer.sid });

        $scope.select = function (course) {
            if ($scope.selected == course) {
                $scope.selected = null;
                return;
            }
            $scope.selected = course;
        }

        $scope.join = function (course) {
            customerHttpClient.join({ sid: $scope.customer.sid }, course).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }

        $scope.cancel = function () {
            $modalInstance.dismiss();
        }
    }]);
});