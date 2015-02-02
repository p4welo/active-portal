define([
    'schedule/module',
    'schedule/rooms/modal/addRoom',
    'core/modal/deleteConfirm',
    'services/notificationService',
    'services/roomService'
], function (module) {

    module.controller("roomsController", function ($scope, roomHttpClient, $modal, notificationService) {

        var NAME_KEY = "name";
        var OBJECT_PROPERTIES = [NAME_KEY];

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

            for (var i = 0; i < OBJECT_PROPERTIES.length; i++) {
                $scope.selected[OBJECT_PROPERTIES[i]] = {
                    value: room[OBJECT_PROPERTIES[i]],
                    edit: false,
                    saving: false,
                    hover: false,
                    oldVal: {}
                }
            }
        }
        $scope.edit = function (object, property) {
            object[property].edit = true;
            object[property].oldVal = object[property].value;
        }
        $scope.cancel = function (object, property) {
            object[property].value = object[property].oldVal;
            object[property].edit = false;
            object[property].hover = false;
        }
        $scope.hover = function (object, property) {
            object[property].hover = true;
        }
        $scope.leave = function (object, property) {
            object[property].hover = false;
        }
        $scope.save = function (object, property) {
            object[property].saving = true;
            if (property == NAME_KEY) {
                var obj = _.findWhere($scope.rooms, {sid: object.sid});
                obj.name = object.name.value;
                if (obj != null) {
                    roomHttpClient.update({ sid: object.sid }, obj).$promise.then(
                        function () {
                            object[property].edit = false;
                            object[property].saving = false;
                            object[property].hover = false;

                            notificationService.success("Pomyślnie zapisano");
                            roomHttpClient.findAll().$promise.then(
                                function (result) {
                                    $scope.rooms = result;
                                });
                        });
                }
            }
        }

//        $scope.update = function (room) {
//            delete room['edit'];
//            roomHttpClient.update({ sid: room.sid }, room).$promise.then(
//                function () {
//                    notificationService.success("Pomyślnie zapisano");
//                    roomHttpClient.findAll().$promise.then(
//                        function (result) {
//                            $scope.rooms = result;
//                        });
//                });
//        }

        $scope.delete = function (room) {
            var modalInstance = $modal.open({
                templateUrl: 'app/core/modal/deleteConfirm.html',
                controller: "deleteConfirmDialogController"
            });

            modalInstance.result.then(function () {
                $scope.selected = null;
                roomHttpClient.delete({sid: room.sid}).$promise.then(
                    function () {
                        notificationService.success("Pomyślnie usunięto");
                        roomHttpClient.findAll().$promise.then(
                            function (result) {
                                $scope.rooms = result;
                            })
                    }
                )
            });
        }

        $scope.resolveStatusCss = function (room) {
            return {'label-success': room.objectState == 'ACTIVE', 'label-danger': room.objectState == 'INACTIVE'}
        }
    });
});