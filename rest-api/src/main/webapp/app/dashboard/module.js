define([
    'angular'
], function (angular) {
    "use strict";

    return angular.module('activePortal.dashboard', [],
        ['$stateProvider',
            function ($stateProvider) {
                $stateProvider
                    .state('dashboard', {
                        url: "/dashboard",
                        templateUrl: "dist/app/dashboard/dashboard.html",
                        controller: "dashboardController"
                    });
            }
        ]);
});