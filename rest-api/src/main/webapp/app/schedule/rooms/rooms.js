define([
    'schedule/module',
    'schedule/rooms/modal/addRoom',
    'services/notificationService',
    'services/roomService'
], function (module) {

    module.controller("roomsController", function ($scope, roomFactory, roomService, $modal, notificationService) {

        $scope.rooms = roomFactory.findAll();

        $scope.add = function () {

            var modalInstance = $modal.open({
                templateUrl: 'app/schedule/rooms/modal/addRoom.html',
                controller: "addRoomController"
            });

            modalInstance.result.then(function () {
                notificationService.success("Pomyślnie zapisano");
                $scope.rooms = roomFactory.findAll();
            });
        }

        $scope.select = function (room) {
            if ($scope.selected != null && $scope.selected.sid == room.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selected = roomService.copyProperties(room);
            $scope.selected.edit = false;
        }

        $scope.update = function (room) {
            delete room['edit'];
            roomFactory.update({ sid: room.sid }, room).$promise.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    $scope.rooms = roomFactory.findAll();
                });
        }

        $scope.resolveStatusCss = function (room) {
            return {'label-success': room.objectState == 'ACTIVE', 'label-danger': room.objectState == 'INACTIVE'}
        }
    });
});