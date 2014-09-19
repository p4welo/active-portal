define([
    'schedule/module',
    'schedule/rooms/modal/addRoom',
    'services/notificationService',
    'services/roomService'
], function (module) {

    module.controller("roomsController", function ($scope, roomFactory, $modal, notificationService) {

        $scope.rooms = roomFactory.find();

        $scope.add = function () {
            $scope.new = {};

            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/schedule/rooms/modal/addRoom.html',
                    controller: "addRoomController"
                });

            modalInstance.result.then(function () {
                $scope.rooms = roomFactory.find();
                notificationService.success("Pomyślnie zapisano");
            });
        }

        $scope.edit = function (room) {
            $scope.selected = {};
        };

    });
});