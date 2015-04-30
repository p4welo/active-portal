define([
    'angular',
    'uiBootstrap',
    'ngTranslate'
], function (angular) {
    "use strict";

    return angular.module('activePortal.customers', ['pascalprecht.translate', 'ui.bootstrap.modal'],
        ['$stateProvider',
            function ($stateProvider) {
                $stateProvider
                    .state('attendance', {
                        url: "/attendance",
                        templateUrl: "dist/app/customers/attendance/attendance.html",
                        controller: "attendanceController"
                    })
                    .state('customerBase', {
                        url: "/customers",
                        templateUrl: "dist/app/customers/customerBase/customerBase.html",
                        controller: "customerBaseController"
                    })
                    .state('customerProfile', {
                        url: "/customer/:sid/profile",
                        templateUrl: "dist/app/customers/profile/customerProfile.html",
                        controller: "customerProfileController"
                    })
                    .state('customerCard', {
                        url: "/customer/:sid/card/:code",
                        templateUrl: "dist/app/customers/card/customerCard.html",
                        controller: "customerCardController"
                    });
            }
        ]
    );
});