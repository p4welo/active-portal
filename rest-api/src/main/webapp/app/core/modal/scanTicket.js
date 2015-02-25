define([
    'core/module',
    'services/ticketService'
], function (module) {

    module.controller('scanTicketDialogController', ['$scope', '$state', '$modalInstance', '$timeout', 'ticketHttpClient', 'customerFactory', function ($scope, $state, $modalInstance, $timeout, ticketHttpClient, customerFactory) {

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
                            customerFactory.setCustomer(result);
                            $state.go("customerCard", {sid: result.sid})
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