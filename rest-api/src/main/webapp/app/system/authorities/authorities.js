define([
    'system/module',
    'services/authorityService'
], function (module) {

    module.controller("authorityController", function ($scope, authorityHttpClient, roleService) {
        $scope.roles = authorityHttpClient.findRoles();
        $scope.authorities = [];

        $scope.select = function (role) {
            if ($scope.selected != null && $scope.selected.name == role.name) {
                $scope.selected = null;
                return;
            }
            $scope.selected = roleService.copyProperties(role);
            $scope.authorities = authorityHttpClient.findByRole({ sid: role.sid });
            $scope.selected.edit = false;
        }

        $scope.change = function ($event, relation) {
            var checkbox = $event.target;
            if (checkbox.checked) {
                authorityHttpClient.check({ sid : $scope.selected.sid }, relation.authority)
            }
            else {
                authorityHttpClient.uncheck({ sid : $scope.selected.sid }, relation.authority)
            }
        }
    });
});