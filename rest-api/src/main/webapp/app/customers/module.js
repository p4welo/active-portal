define([
    'uiBootstrap',
    'ngTranslate'
], function () {

    return angular.module('activePortal.customers', [
        'pascalprecht.translate',
        'ui.bootstrap.modal'
    ], function ($stateProvider) {
        $stateProvider
            .state('attendance', {
                url: "/attendance",
                templateUrl: "app/customers/attendance/attendance.html",
                controller: "attendanceController"
            })
            .state('customerBase', {
                url: "/customers",
                templateUrl: "app/customers/customerBase/customerBase.html",
                controller: "customerBaseController"
            })
            .state('customerProfile', {
                url: "/customer/:sid/profile",
                templateUrl: "app/customers/profile/customerProfile.html",
                controller: "customerProfileController"
            })
            .state('customerCard', {
                url: "/customer/:sid/card/:code",
                templateUrl: "app/customers/card/customerCard.html",
                controller: "customerCardController"
            });
    });
});