define([
    'schedule/module',
    'services/ticketTypeGroupService',
    'services/ticketTypeService'
], function (module) {

    module.controller('addTicketTypeController', ['$scope', '$modalInstance', 'ticketTypeGroupHttpClient', 'ticketTypeHttpClient', '$timeout', function ($scope, $modalInstance, ticketTypeGroupHttpClient, ticketTypeHttpClient, $timeout) {
        $scope.type = {};
        $scope.groups = ticketTypeGroupHttpClient.findAll();

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (type) {
            ticketTypeHttpClient.create(type).$promise.then(
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