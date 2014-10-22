define([
    'ngTranslate'
], function () {

    return angular.module('activePortal.system', [
        'pascalprecht.translate'
    ], function ($stateProvider) {
        $stateProvider
            .state('users', {
                url: "/users",
                templateUrl: "app/system/users/users.html",
                controller: "userController"
            }).state('authorities', {
                url: "/authorities",
                templateUrl: "app/system/authorities/authorities.html",
                controller: "authorityController"
            });
    });
});