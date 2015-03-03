define([
    'customers/module',
    'services/customerService'
], function (module) {

    module.controller("customerCardController", ['$scope', '$stateParams', '$state', 'customerHttpClient', function ($scope, $stateParams, $state, customerHttpClient) {
        $scope.ticketCode = $stateParams.code;

        customerHttpClient.get({sid: $stateParams.sid}).$promise.then(
            function (result) {
                $scope.customer = result;
                if ($scope.customer === undefined || !$scope.customer.hasOwnProperty("sid")) {
                    $state.go("customerBase");
                }
            }
        );

        $scope.customerProfile = function () {
            $state.go("customerProfile", {sid: $scope.customer.sid});
        };
    }]);
});