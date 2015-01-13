define([
    'customers/module',
    'services/customerService'
], function (module) {

    module.controller("customerDetailsController", function ($scope, $stateParams, $state, customerFactory) {
        $scope.customer = customerFactory.getCustomer($stateParams.sid);
        if ($scope.customer == null) {
            $state.go("customerBase");
        }
    });
});