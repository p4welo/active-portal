define([
    'jquery',
    'schedule/module',
    'services/ticketTypeGroupService'
], function ($, module) {

    module.controller('addTicketTypeGroupController', ['$scope', '$modalInstance', 'ticketTypeGroupHttpClient', '$timeout', function ($scope, $modalInstance, ticketTypeGroupHttpClient, $timeout) {
        $scope.group = {};

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (group) {
            ticketTypeGroupHttpClient.create(group).$promise.then(
                function () {
                    $modalInstance.close();
                });
        };
        $scope.focusInput = function (id) {
            $timeout(function () {
                $(id).focus();
            }, 100);
        };
    }]);
});