define([
    'customers/module',
    'services/customerService',
    'services/ticketService'
], function (module) {
    "use strict";

    module.controller("customerCardController", ['$scope', '$stateParams', '$state', 'customerHttpClient', 'ticketHttpClient',
        function ($scope, $stateParams, $state, customerHttpClient, ticketHttpClient) {
            $scope.ticketCode = $stateParams.code;

            customerHttpClient.get({sid: $stateParams.sid}).$promise.then(
                function (result) {
                    $scope.customer = result;
                    if ($scope.customer === undefined || !$scope.customer.hasOwnProperty("sid")) {
                        $state.go("customerBase");
                    }
                }
            );

            ticketHttpClient.findByCode({code: $stateParams.code}).$promise.then(
                function (result) {
                    $scope.ticket = result;
                }
            );

            $scope.customerProfile = function () {
                $state.go("customerProfile", {sid: $scope.customer.sid});
            };
        }
    ]);
});