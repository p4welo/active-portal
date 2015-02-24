define([
    'customers/module',
    'services/customerService'
], function (module) {

    module.controller("customerDetailsController", ['$scope', '$stateParams', '$state', 'customerFactory', function ($scope, $stateParams, $state, customerFactory) {
        $scope.customer = customerFactory.getCustomer($stateParams.sid);
        if ($scope.customer == null) {
            $state.go("customerBase");
        }
    }]);
});