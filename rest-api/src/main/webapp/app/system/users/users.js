define([
    'system/module',
    'services/userService'
], function (module) {

    module.controller("userController", function ($scope, userHttpClient) {
        $scope.users = userHttpClient.findAll();
    });
});