define([
    'system/module',
    'services/authorityService',
    'services/notificationService'
], function (module) {

    module.controller("authorityController", function ($scope, authorityHttpClient, roleService, notificationService) {
        $scope.roles = authorityHttpClient.findRoles();
        $scope.authorities = [];

        $scope.select = function (role) {
            if ($scope.selected != null && $scope.selected.name == role.name) {
                $scope.selected = null;
                return;
            }
            $scope.selected = roleService.copyProperties(role);
            authorityHttpClient.findByRole({ sid: role.sid }).$promise.then(
                function (result) {
                    $scope.authorities = result;
                }
            );
            $scope.selected.edit = false;
        }

        $scope.change = function ($event, relation) {
            var role = $scope.selected;
            var checkbox = $event.target;
            if (checkbox.checked) {
                authorityHttpClient.check({ sid: role.sid }, relation.authority).$promise.then(
                    function (result) {
                        relation.checked = result.checked;
                        notificationService.success("Pomyślnie zapisano");
                    }
                )
            }
            else {
                authorityHttpClient.uncheck({ sid: role.sid }, relation.authority).$promise.then(
                    function (result) {
                        relation.checked = result.checked;
                        notificationService.success("Pomyślnie zapisano");
                    }
                )
            }
        }
    });
});