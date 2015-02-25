define([
    'customers/module',
    'services/customerService'
], function (module) {

    module.controller("customerProfileController", ['$scope', '$stateParams', '$state', 'customerHttpClient', function ($scope, $stateParams, $state, customerHttpClient) {
        customerHttpClient.get({sid: $stateParams.sid}).$promise.then(
            function (result) {
                $scope.customer = result;
                if ($scope.customer === undefined && !$scope.customer.hasOwnProperty("sid")) {
                    $state.go("customerBase");
                }
            }
        );
    }]);
});