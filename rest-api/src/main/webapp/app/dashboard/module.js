define([
], function () {

    return angular.module('activePortal.dashboard', [
    ], function ($stateProvider) {
        $stateProvider
            .state('dashboard', {
                url: "/dashboard",
                templateUrl: "app/dashboard/dashboard.html",
                controller: "dashboardController"
            });
    });
});