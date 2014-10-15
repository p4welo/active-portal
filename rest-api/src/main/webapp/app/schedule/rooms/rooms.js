define([
    'schedule/module',
    'schedule/rooms/modal/addRoom',
    'services/notificationService',
    'services/roomService'
], function (module) {

    module.controller("roomsController", function ($scope, roomFactory, $modal, notificationService) {

        $scope.rooms = roomFactory.findAll();

        $scope.add = function () {

            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/schedule/rooms/modal/addRoom.html',
                    controller: "addRoomController"
                });

            modalInstance.result.then(function () {
                $scope.rooms = roomFactory.findAll();
                notificationService.success("Pomyślnie zapisano");
            });
        }

        $scope.select = function (room) {
            if ($scope.selected == room) {
                $scope.selected = null;
                return;
            }
            $scope.selected = room;
            $scope.selected.edit = false;
        }

        $scope.resolveStatusCss = function (room) {
            return {'label-success': room.objectState == 'ACTIVE', 'label-danger': room.objectState == 'INACTIVE'}
        }
    });
});