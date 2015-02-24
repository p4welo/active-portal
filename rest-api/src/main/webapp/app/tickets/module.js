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
            });
    });
});