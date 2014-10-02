define([
    'uiBootstrap'
], function () {

    return angular.module('activePortal.customers', ['ui.bootstrap.modal'], function ($stateProvider) {
        $stateProvider
            .state('attendance', {
                url: "/attendance",
                templateUrl: "app/customers/attendance/attendance.html",
                controller: "attendanceController"
            })
            .state('customerBase', {
                url: "/customerBase",
                templateUrl: "app/customers/customerBase/customerBase.html",
                controller: "customerBaseController"
            });
    });
});