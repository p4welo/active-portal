define([
    'angular',
    'uiBootstrap',
    'ngTranslate'
], function (angular) {

    return angular.module('activePortal.tickets', [
        'pascalprecht.translate',
        'ui.bootstrap.modal'
    ], ['$stateProvider',
        function ($stateProvider) {
        $stateProvider
            .state('sellTicket', {
                url: "/ticket/:code/sell",
                templateUrl: "dist/app/tickets/sell/sellTicket.html",
                controller: "sellTicketController"
            })
            .state('ticketGroups', {
                url: "/ticket/groups",
                templateUrl: "dist/app/tickets/typeGroups/ticketTypeGroups.html",
                controller: "ticketGroupsController"
            })
            .state('ticketTypes', {
                url: "/ticket/types",
                templateUrl: "dist/app/tickets/types/ticketTypes.html",
                controller: "ticketTypesController"
            });
    }
    ]);
});