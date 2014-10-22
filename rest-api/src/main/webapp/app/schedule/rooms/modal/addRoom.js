define([
    'schedule/module',
    'services/roomService'
], function (module) {

    module.controller('addRoomController', function ($scope, $modalInstance, roomHttpClient) {
        $scope.room = {};

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (room) {
            roomHttpClient.create(room).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }
    });

});