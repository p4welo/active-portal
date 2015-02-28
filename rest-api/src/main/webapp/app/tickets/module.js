define([
    'uiBootstrap',
    'ngTranslate'
], function () {

    return angular.module('activePortal.tickets', [
        'pascalprecht.translate',
        'ui.bootstrap.modal'
    ], function ($stateProvider) {
        $stateProvider
            .state('sellTicket', {
                url: "/ticket/:code/sell",
                templateUrl: "app/tickets/sell/sellTicket.html",
                controller: "sellTicketController"
            })
            .state('ticketGroups', {
                url: "/ticket/groups",
                templateUrl: "app/tickets/typeGroups/ticketTypeGroups.html",
                controller: "ticketGroupsController"
            })
            .state('ticketTypes', {
                url: "/ticket/types",
                templateUrl: "app/tickets/types/ticketTypes.html",
                controller: "ticketTypesController"
            });
    });
});