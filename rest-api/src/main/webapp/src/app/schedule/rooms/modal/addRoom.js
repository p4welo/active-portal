angular.module('activePortal.schedule')

    .controller('addRoomCtrl', function ($scope, $modalInstance, roomHttpClient, $timeout) {
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
    })
;