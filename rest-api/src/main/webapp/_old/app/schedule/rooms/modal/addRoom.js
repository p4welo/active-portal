define([
    'jquery',
    'schedule/module',
    'services/roomService'
], function ($, module) {
    "use strict";

    module.controller('addRoomController', ['$scope', '$modalInstance', 'roomHttpClient', '$timeout', function ($scope, $modalInstance, roomHttpClient, $timeout) {
        $scope.room = {};
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.save = function (room) {
            roomHttpClient.create(room).$promise.then(
                function () {
                    $modalInstance.close();
                });
        };
        $scope.focusInput = function (id) {
            $timeout(function () {
                $(id).focus();
            }, 100);
        };
    }]);
});