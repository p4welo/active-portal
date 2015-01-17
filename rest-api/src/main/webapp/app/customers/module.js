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
            .state('customerDetails', {
                url: "/customer/:sid/details",
                templateUrl: "app/customers/customerDetails/customerDetails.html",
                controller: "customerDetailsController"
            });
    });
});