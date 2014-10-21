define([
    'system/module',
    'services/authorityService'
], function (module) {

    module.controller("authorityController", function ($scope, authorityHttpClient, roleService) {
        $scope.roles = authorityHttpClient.findRoles();
        $scope.authorities = authorityHttpClient.findAll();

        $scope.select = function (role) {
            if ($scope.selected != null && $scope.selected.name == role.name) {
                $scope.selected = null;
                return;
            }
            $scope.selected = roleService.copyProperties(role);
            $scope.selected.edit = false;
        }
    });
});