define([
    'schedule/module',
    'schedule/rooms/modal/addRoom',
    'core/modal/deleteConfirm',
    'services/notificationService',
    'services/roomService'
], function (module) {

    module.controller("roomsController", ['$scope', 'roomHttpClient', '$modal', 'notificationService', function ($scope, roomHttpClient, $modal, notificationService) {

        var NAME_KEY = "name";
        var OBJECT_PROPERTIES = [NAME_KEY];

        // =======================================
        $scope.roomLoading = true;
        roomHttpClient.findAll().$promise.then(
            function (result) {
                $scope.rooms = result;
                $scope.roomLoading = false;
            }
        );
        // =======================================
        $scope.sort = {
            column: 'code',
            descending: false
        };
        $scope.toggleSort = function (column) {
            var sort = $scope.sort;
            if (sort.column == column) {
                sort.descending = !sort.descending;
            } else {
                sort.column = column;
                sort.descending = false;
            }
        };
        $scope.sortIcon = function (column) {
            var sort = $scope.sort;
            if (sort.column == column) {
                return sort.descending ? "fa fa-caret-down" : "fa fa-caret-up";
            }
            return "";
        };

        // =======================================
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
        };
        // =======================================
        $scope.select = function (room) {
            if ($scope.selected !== undefined && $scope.selected.sid == room.sid) {
                $scope.selected = undefined;
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
                };
            }
        };
        $scope.edit = function (object, property) {
            object[property].edit = true;
            object[property].oldVal = object[property].value;
        };
        $scope.cancel = function (object, property) {
            object[property].value = object[property].oldVal;
            object[property].edit = false;
            object[property].hover = false;
        };
        $scope.hover = function (object, property) {
            object[property].hover = true;
        };
        $scope.leave = function (object, property) {
            object[property].hover = false;
        };
        $scope.save = function (object, property) {
            object[property].saving = true;
            if (property == NAME_KEY) {
                var obj = _.findWhere($scope.rooms, {sid: object.sid});
                obj[NAME_KEY] = object[NAME_KEY].value;
                if (obj !== undefined) {
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
        };

        // =======================================
        $scope.delete = function (room) {
            if (room !== undefined) {
                var modalInstance = $modal.open({
                    templateUrl: 'app/core/modal/deleteConfirm.html',
                    controller: "deleteConfirmDialogController"
                });

                modalInstance.result.then(function () {
                    $scope.selected = undefined;
                    roomHttpClient.delete({sid: room.sid}).$promise.then(
                        function () {
                            notificationService.success("Pomyślnie usunięto");
                            roomHttpClient.findAll().$promise.then(
                                function (result) {
                                    $scope.rooms = result;
                                });
                        }
                    );
                });
            }
        };
    }]);
});