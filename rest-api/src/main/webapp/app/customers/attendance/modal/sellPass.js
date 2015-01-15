define([
    'customers/module',
    'services/customerService'
], function (module) {

    module.controller('sellPassController', function ($scope, $modalInstance, customerHttpClient) {
        $scope.cancel = function () {
            $modalInstance.dismiss();
        }

        $scope.customers = customerHttpClient.findAll();
        $scope.customerSubview = 0;
        $scope.setSubview = function (viewId) {
            $scope.customerSubview = viewId;
        }

    });

});