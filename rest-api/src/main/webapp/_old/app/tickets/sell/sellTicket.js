define([
    'jquery',
    'tickets/module',
    'tickets/sell/modal/confirmTicketSale',
    'services/ticketService',
    'services/customerService'
], function ($, module) {
    "use strict";

    module.controller("sellTicketController", ['$scope', 'ticketTypeHttpClient', '$stateParams', 'customerHttpClient', '$modal', '$state', 'customerFactory', 'ticketTypeGroupHttpClient', function ($scope, ticketTypeHttpClient, $stateParams, customerHttpClient, $modal, $state, customerFactory, ticketTypeGroupHttpClient) {

        $scope.ticket = {
            barcode: $stateParams.code
        };
        $scope.customerValid = false;
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
        $scope.selectType = function (type) {
            if ($scope.ticket.type == type) {
                $scope.ticket.type = undefined;
                return;
            }
            $scope.ticket.type = type;
        };
        $scope.isValidCustomer = function () {
            var validNew = !$scope.existingCustomer &&
                $scope.newCustomer.firstName !== undefined &&
                $scope.newCustomer.lastName !== undefined &&
                $scope.newCustomer.gender !== undefined &&
                $scope.newCustomer.mobile !== undefined;

            var validExisting = $scope.existingCustomer && $scope.customer !== undefined;
            $scope.customerValid = $scope.ticket.type !== undefined && (validNew || validExisting);
            return $scope.customerValid;
        };
        $scope.$watch('customerValid', function (newValue, oldValue) {
            if (newValue !== oldValue && newValue === true) {
                $('html, body').animate({
                    scrollTop: $("#continue").offset().top
                }, 2000);
            }
        });

        $scope.confirm = function () {
            var modalInstance = $modal.open({
                templateUrl: 'dist/app/tickets/sell/modal/confirmTicketSale.html',
                controller: "confirmTicketSaleDialogController",
                resolve: {
                    customer: function () {
                        return $scope.existingCustomer ? $scope.customer : $scope.newCustomer;
                    },
                    ticket: function () {
                        return $scope.ticket.type;
                    }
                }
            });

            modalInstance.result.then(function () {
                if ($scope.existingCustomer) {
                    customerHttpClient.buyTicket({sid: $scope.customer.sid}, $scope.ticket).$promise.then(
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
            var result = [];
            if (searchText !== undefined) {
                items.forEach(function (item) {
                    if (item.group.sid.indexOf(searchText) > -1) {
                        result.push(item);
                    }
                });
            }
            return result;
        };
    }]);
});