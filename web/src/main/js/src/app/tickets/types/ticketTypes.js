angular.module('activePortal.schedule')

    .config(function ($stateProvider) {
        $stateProvider.state('ticketTypes', {
            url: "/ticket/types",
            templateUrl: "tickets/types/ticketTypes.tpl.html",
            controller: "ticketTypesCtrl"
        });
    })

    .controller('ticketTypesCtrl', function ($scope, ticketTypeHttpClient, notificationService, $modal) {
    })
;