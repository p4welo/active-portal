define([
    'angular',
    'ngTranslate',
    'uiBootstrap'
], function (angular) {

    return angular.module('activePortal.system', [
        'pascalprecht.translate'
    ], ['$stateProvider',
        function ($stateProvider) {
            $stateProvider
                .state('users', {
                    url: "/users",
                    templateUrl: "dist/app/system/users/users.html",
                    controller: "userController"
                }).state('authorities', {
                    url: "/authorities",
                    templateUrl: "dist/app/system/authorities/authorities.html",
                    controller: "authorityController"
                });
        }
    ]);
});