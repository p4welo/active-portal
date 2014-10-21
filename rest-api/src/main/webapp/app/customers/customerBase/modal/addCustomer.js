define([
    'schedule/module',
    'services/customerService'
], function (module) {

    module.controller('addCustomerController', function ($scope, customerFactory, $modalInstance) {
        $scope.create = function (customer) {
            customerFactory.create(customer).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }

        $scope.cancel = function () {
            $modalInstance.dismiss();
        }
    });
});