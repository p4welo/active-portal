define([
    'angular',
    'system/module',
    'services/authorityService',
    'services/notificationService'
], function (angular, module) {
    "use strict";

    module.controller("authorityController", ['$scope', 'authorityHttpClient', 'notificationService', function ($scope, authorityHttpClient, notificationService) {
        $scope.roles = authorityHttpClient.findRoles();
        $scope.authorities = [];

        $scope.select = function (role) {
            if ($scope.selected !== undefined && $scope.selected.name == role.name) {
                $scope.selected = undefined;
                return;
            }
            $scope.selected = angular.copy(role);
            authorityHttpClient.findByRole({ sid: role.sid }).$promise.then(
                function (result) {
                    $scope.authorities = result;
                }
            );
            $scope.selected.edit = false;
        };

        $scope.change = function ($event, relation) {
            var role = $scope.selected;
            var checkbox = $event.target;
            if (checkbox.checked) {
                authorityHttpClient.check({ sid: role.sid }, relation.authority).$promise.then(
                    function (result) {
                        relation.checked = result.checked;
                        notificationService.success("Pomyślnie zapisano");
                    }
                );
            }
            else {
                authorityHttpClient.uncheck({ sid: role.sid }, relation.authority).$promise.then(
                    function (result) {
                        relation.checked = result.checked;
                        notificationService.success("Pomyślnie zapisano");
                    }
                );
            }
        };
    }]);
});