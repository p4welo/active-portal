define([
    'core/module',
    'services/ticketService'
], function (module) {

    module.controller('scanTicketDialogController', ['$scope', '$state', '$modalInstance', '$timeout', 'ticketHttpClient', function ($scope, $state, $modalInstance, $timeout, ticketHttpClient) {

        $scope.code = "";
        $scope.customerLoading = false;
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.confirm = function (code) {
            $scope.customerLoading = true;
            if (code != null) {
                ticketHttpClient.findCustomerByCode({code: code}).$promise.then(
                    function (result) {
                        if (result != null && result.hasOwnProperty("sid")) {
                            $state.go("customerDetails", {sid: result.sid})
                        }
                        else {
                            $state.go("sellTicket", {code: code});
                        }
                        $modalInstance.close();
                    }
                )
            }
        };
        $scope.focusInput = function () {
            $timeout(function () {
                $("#code").focus();
            }, 100);
        };
    }
    ])
});