define([
    'system/module',
    'services/userService'
], function (module) {

    module.controller("userController", function ($scope, userFactory) {
        $scope.users = userFactory.findAll();
    });
});