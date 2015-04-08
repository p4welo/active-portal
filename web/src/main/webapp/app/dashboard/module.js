define([
    'angular'
], function (angular) {
    "use strict";

    return angular.module('activePortal',
        ['$stateProvider',
            function ($stateProvider) {
                $stateProvider
                    .state('dashboard', {
                        url: "/dashboard",
                        templateUrl: "app/dashboard/dashboard.html",
                        controller: "dashboardController"
                    });
            }
        ]);
});