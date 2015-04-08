define([
    'customers/module',
    'services/customerService',
    'services/ticketService'
], function (module) {
    "use strict";

    module.controller("customerCardController", ['$scope', '$stateParams', '$state', 'customerHttpClient', 'ticketHttpClient',
        function ($scope, $stateParams, $state, customerHttpClient, ticketHttpClient) {
            $scope.ticketLoading = true;
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
                    $scope.ticketLoading = false;
                }
            );

            $scope.customerProfile = function () {
                $state.go("customerProfile", {sid: $scope.customer.sid});
            };
        }
    ])

        .filter("dateTime", function () {
            return function (input) {
                var y = input.year;
                var m = input.monthOfYear < 10 ? "0" + input.monthOfYear : input.monthOfYear;
                var d = input.dayOfMonth < 10 ? "0" + input.dayOfMonth : input.dayOfMonth;
                var h = input.hourOfDay;
                var min = input.minuteOfHour;

                return y + "-" + m + "-" + d + " " + h + ":" + min;
            };
        });
});