define([
    'system/module',
    'services/userService'
], function (module) {

    module.controller("userController", function ($scope, userHttpClient) {
        userHttpClient.findAll().$promise.then(
            function (result) {
                $scope.users = result;
            }
        );
    });
});