define([
    'tickets/module',
    'tickets/sell/modal/confirmTicketSale',
    'services/ticketService',
    'services/customerService',
], function (module) {

    module.controller("sellTicketController", ['$scope', 'ticketService', '$stateParams', 'customerHttpClient', '$modal', '$state', 'customerFactory', function ($scope, ticketService, $stateParams, customerHttpClient, $modal, $state, customerFactory) {
        $scope.code = $stateParams.code;
        $scope.tickets = ticketService.getTickets();
        $scope.newCustomer = {};
        $scope.customers = customerHttpClient.findAll();
        $scope.existingCustomer = true;
        $scope.setExistingCustomer = function (isExistingCustomer) {
            $scope.existingCustomer = isExistingCustomer;
        }
        $scope.selectCustomer = function (customer) {
            if ($scope.customer == customer) {
                $scope.customer = null;
                return;
            }
            $scope.customer = customer;
        }
        $scope.selectType = function (ticket) {
            if ($scope.ticket == ticket) {
                $scope.ticket = null;
                return;
            }
            $scope.ticket = ticket;
        }
        $scope.isValidCustomer = function () {
            var validNew = !$scope.existingCustomer
                && $scope.newCustomer.firstName != null
                && $scope.newCustomer.lastName != null
                && $scope.newCustomer.gender != null
                && $scope.newCustomer.mobile != null;

            var validExisting = $scope.existingCustomer && $scope.customer != null;
            return $scope.ticket != null && (validNew || validExisting);
        }

        $scope.confirm = function () {
            var modalInstance = $modal.open({
                templateUrl: 'app/tickets/sell/modal/confirmTicketSale.html',
                controller: "confirmTicketSaleDialogController",
                resolve: {
                    customer: function () {
                        return $scope.existingCustomer ? $scope.customer : $scope.newCustomer;
                    },
                    ticket: function () {
                        return $scope.ticket;
                    }
                }
            });

            modalInstance.result.then(function () {
                if ($scope.existingCustomer) {
                    customerHttpClient.buyTicket({sid: $scope.customer.sid}, {
                        type: $scope.ticket.type,
                        barcode: $scope.code
                    }).$promise.then(
                        function (result) {
                            if (result != null && result.hasOwnProperty("sid")) {
                                customerFactory.setCustomer(result);
                                $state.go("customerCard", {sid: result.sid});
                            }
                        }
                    )
                }
            });
        }
    }]);
});