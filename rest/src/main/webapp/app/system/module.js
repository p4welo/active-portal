define([

], function () {

    return angular.module('activePortal.system', [], function ($stateProvider) {
        $stateProvider
            .state('users', {
                url: "/users",
                templateUrl: "app/system/users/users.html",
                controller: "userController"
            });
    });
});