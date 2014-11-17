define([
    'schedule/module',
    'services/customerService'
], function (module) {

    module.controller('addCustomerController', function ($scope, customerHttpClient, $modalInstance) {
        $scope.create = function (customer) {
            customerHttpClient.create(customer).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }

        $scope.cancel = function () {
            $modalInstance.dismiss();
        }
    });
});