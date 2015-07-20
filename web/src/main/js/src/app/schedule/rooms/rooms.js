angular.module('activePortal.schedule')

    .config(function ($stateProvider) {
        $stateProvider.state('rooms', {
            url: "/rooms",
            templateUrl: "schedule/rooms/rooms.tpl.html",
            controller: "roomsCtrl"
        });
    })

    .controller('roomsCtrl', function ($scope, roomHttpClient, $modal, notificationService) {
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
            $modal.open(
                {
                    templateUrl: 'schedule/rooms/modal/addRoom.tpl.html',
                    controller: "addRoomCtrl",
                    backdrop: 'static'
                }
            ).result.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    return roomHttpClient.findAll().$promise;
                }
            ).then(
                function (result) {
                    $scope.rooms = result;
                }
            );
        };
        // =======================================
        $scope.select = function (room) {
            if (angular.isObject($scope.selected) && $scope.selected.sid == room.sid) {
                $scope.selected = undefined;
                return;
            }
            $scope.selected = angular.copy(room);
            //OBJECT_PROPERTIES.forEach(function (property) {
            //    $scope.selected[property] = {
            //        value: room[property],
            //        edit: false,
            //        saving: false,
            //        oldVal: {}
            //    };
            //});
        };
        $scope.edit = function (object, property) {
            object[property].edit = true;
            object[property].oldVal = object[property].value;
        };
        $scope.cancel = function (object, property) {
            object[property].value = object[property].oldVal;
            object[property].edit = false;
        };
        $scope.save = function (object, property, callback) {
            if (property == NAME_KEY) {
                var obj = _.findWhere($scope.rooms, {sid: object.sid});
                obj[NAME_KEY] = object[NAME_KEY];
                if (obj !== undefined) {
                    roomHttpClient.update({sid: object.sid}, obj).$promise.then(
                        function () {
                            notificationService.success("Pomyślnie zapisano");
                            callback();
                            roomHttpClient.findAll().$promise.then(
                                function (result) {
                                    $scope.rooms = result;
                                });
                        });
                }
            }
        };
        //$scope.save = function (object, property) {
        //    object[property].saving = true;
        //    if (property == NAME_KEY) {
        //        var obj = _.findWhere($scope.rooms, {sid: object.sid});
        //        obj[NAME_KEY] = object[NAME_KEY].value;
        //        if (obj !== undefined) {
        //            roomHttpClient.update({sid: object.sid}, obj).$promise.then(
        //                function () {
        //                    object[property].edit = false;
        //                    object[property].saving = false;
        //
        //                    notificationService.success("Pomyślnie zapisano");
        //                    roomHttpClient.findAll().$promise.then(
        //                        function (result) {
        //                            $scope.rooms = result;
        //                        });
        //                });
        //        }
        //    }
        //};

        // =======================================
        $scope.delete = function (room) {
            if (angular.isObject(room)) {
                $modal.open(
                    {
                        templateUrl: 'common/modal/deleteConfirm.tpl.html',
                        controller: "deleteConfirmDialogCtrl",
                        backdrop: 'static'
                    }
                ).result.then(
                    function () {
                        $scope.selected = undefined;
                        return roomHttpClient.delete({sid: room.sid}).$promise;
                    }
                ).then(
                    function () {
                        notificationService.success("Pomyślnie usunięto");
                        return roomHttpClient.findAll().$promise;
                    }
                ).then(
                    function (result) {
                        $scope.rooms = result;
                    }
                );
            }
        };
    })
;