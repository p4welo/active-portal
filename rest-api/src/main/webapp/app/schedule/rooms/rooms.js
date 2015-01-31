define([
    'schedule/module',
    'schedule/rooms/modal/addRoom',
    'services/notificationService',
    'services/roomService'
], function (module) {

    module.controller("roomsController", function ($scope, roomHttpClient, $modal, notificationService) {

        $scope.roomLoading = true;
        roomHttpClient.findAll().$promise.then(
            function (result) {
                $scope.rooms = result;
                $scope.roomLoading = false;
            }
        );

        $scope.add = function () {

            var modalInstance = $modal.open({
                templateUrl: 'app/schedule/rooms/modal/addRoom.html',
                controller: "addRoomController"
            });

            modalInstance.result.then(function () {
                notificationService.success("Pomyślnie zapisano");
                roomHttpClient.findAll().$promise.then(
                    function (result) {
                        $scope.rooms = result;
                    });
            });
        }

        $scope.select = function (room) {
            if ($scope.selected != null && $scope.selected.sid == room.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selected = angular.copy(room);
            $scope.selected.edit = false;
        }

        $scope.update = function (room) {
            delete room['edit'];
            roomHttpClient.update({ sid: room.sid }, room).$promise.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    roomHttpClient.findAll().$promise.then(
                        function (result) {
                            $scope.rooms = result;
                        });
                });
        }

        $scope.resolveStatusCss = function (room) {
            return {'label-success': room.objectState == 'ACTIVE', 'label-danger': room.objectState == 'INACTIVE'}
        }
    });
});