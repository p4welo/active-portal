define([
    'schedule/module',
    'services/ticketTypeGroupService'
], function (module) {

    module.controller('addTicketTypeGroupController', ['$scope', '$modalInstance', 'ticketTypeGroupHttpClient', function ($scope, $modalInstance, ticketTypeGroupHttpClient) {
        $scope.group = {};

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (group) {
            ticketTypeGroupHttpClient.create(group).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }
    }]);
});