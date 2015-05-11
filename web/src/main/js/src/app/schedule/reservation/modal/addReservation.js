angular.module('activePortal.schedule')

    .controller('addReservationCtrl', function (rooms, $scope, $modalInstance, $timeout, coreHttpClient) {
        $scope.rooms = rooms;
        $scope.reservation = {};
        $scope.types = [
            "INDIVIDUAL_LESSON",
            "WORKSHOPS",
            "EXTERNAL"
        ];
        $scope.start = {
            hours: "15",
            minutes: "00"
        };
        $scope.end = {
            hours: "16",
            minutes: "00"
        };
        $scope.hours = [];
        $scope.minutes = [];
        for (var i = 7; i < 24; i++) {$scope.hours.push("" + i);}
        for (i = 0; i < 60; i+=5) {
            var j = i;
            if (j < 10) {
                j = "0" + j;
            }
            $scope.minutes.push("" + j);
        }

        $scope.onStartHoursChange = function (newValue) {
            $scope.end.hours = (parseInt(newValue) + 1) + "";
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (reservation) {
            reservation.startTime = $scope.start.hours + ":" + $scope.start.minutes;
            reservation.endTime = $scope.end.hours + ":" + $scope.end.minutes;
            coreHttpClient.create({type: "reservation"}, reservation).$promise.then(
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