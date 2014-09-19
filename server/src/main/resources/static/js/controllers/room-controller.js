angular.module('PortalApp.controllers')

    .controller('roomController', function ($scope, roomFactory, roomService, notificationService) {

        $scope.rooms = roomFactory.find();

        $scope.add = function() {
            $scope.new = {};
            showModal("#add-room-modal")
        };

        $scope.create = function (room) {

            roomFactory.create(room, function () {
                $scope.rooms = roomFactory.find();
                hideModal("#add-room-modal");
                notificationService.success("Pomyślnie zapisano");
            });
        };



        $scope.edit = function (room) {

            $scope.selected = {};
            roomService.copyProperties(room, $scope.selected);
            showModal("#edit-room-modal");
        };

        $scope.update = function (room) {

            $scope.updateLoading = true;
            roomFactory.update({sid: room.sid}, room, function () {

                $scope.rooms = roomFactory.find();
                hideModal("#edit-room-modal");
                notificationService.success("Pomyślnie zapisano");
                $scope.updateLoading = false;

            }, function () {
                notificationService.error("Error occured");
            });
        };
    });