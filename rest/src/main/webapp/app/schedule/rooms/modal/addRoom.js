define([
    'schedule/module',
    'services/roomService'
], function (module) {

    module.controller('addRoomController', function ($scope, $modalInstance, roomFactory) {
        $scope.room = {};

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (room) {
            roomFactory.create(room);
            $modalInstance.close();
        }
    });

});