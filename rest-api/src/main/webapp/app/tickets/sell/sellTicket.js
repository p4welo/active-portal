define([
    'tickets/module',
    'tickets/sell/modal/confirmTicketSale',
    'services/ticketService',
    'services/customerService'
], function (module) {

    module.controller("sellTicketController", ['$scope', 'ticketTypeHttpClient', '$stateParams', 'customerHttpClient', '$modal', '$state', 'customerFactory', 'ticketTypeGroupHttpClient', function ($scope, ticketTypeHttpClient, $stateParams, customerHttpClient, $modal, $state, customerFactory, ticketTypeGroupHttpClient) {
        $scope.code = $stateParams.code;
        ticketTypeGroupHttpClient.findAll().$promise.then(function (result) {
            if (result !== undefined) {
                $scope.selectedTicketGroupSid = result[0].sid;
                $scope.ticketGroups = result;
            }
        });
        $scope.ticketTypes = ticketTypeHttpClient.findAll();
        $scope.newCustomer = {};
        $scope.customers = customerHttpClient.findAll();
        $scope.existingCustomer = true;
        $scope.setExistingCustomer = function (isExistingCustomer) {
            $scope.existingCustomer = isExistingCustomer;
        };
        $scope.selectCustomer = function (customer) {
            if ($scope.customer == customer) {
                $scope.customer = undefined;
                return;
            }
            $scope.customer = customer;
        };
        $scope.selectType = function (ticket) {
            if ($scope.ticket == ticket) {
                $scope.ticket = undefined;
                return;
            }
            $scope.ticket = ticket;
        };
        $scope.isValidCustomer = function () {
            var validNew = !$scope.existingCustomer &&
                $scope.newCustomer.firstName !== undefined &&
                $scope.newCustomer.lastName !== undefined &&
                $scope.newCustomer.gender !== undefined &&
                $scope.newCustomer.mobile !== undefined;

            var validExisting = $scope.existingCustomer && $scope.customer !== undefined;
            return $scope.ticket !== undefined && (validNew || validExisting);
        };

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
                            if (result !== undefined && result.hasOwnProperty("sid")) {
                                customerFactory.setCustomer(result);
                                $state.go("customerCard", {sid: result.sid});
                            }
                        }
                    );
                }
            });
        };
    }]);

    module.filter("findByGroup", [function () {
        return function (items, searchText) {

            if (searchText !== undefined && searchText.length > 2) {
                var result = [];
                items.forEach(function (item) {
                    if (item.group.sid.indexOf(searchText) > -1) {
                        result.push(item);
                    }
                })
                return result;
            }
            else {
                return [];
            }

        };
    }]);
});