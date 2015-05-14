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


        //=========================
        $scope.today = function() {
            $scope.dt = new Date();
        };
        $scope.today();

        $scope.clear = function () {
            $scope.dt = null;
        };

        // Disable weekend selection
        $scope.disabled = function(date, mode) {
            return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
        };

        $scope.toggleMin = function() {
            $scope.minDate = $scope.minDate ? null : new Date();
        };
        $scope.toggleMin();

        $scope.open = function($event) {
            $event.preventDefault();
            $event.stopPropagation();

            $scope.opened = true;
        };

        $scope.dateOptions = {
            formatYear: 'yy',
            startingDay: 1
        };

        $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
        $scope.format = $scope.formats[0];

        var tomorrow = new Date();
        tomorrow.setDate(tomorrow.getDate() + 1);
        var afterTomorrow = new Date();
        afterTomorrow.setDate(tomorrow.getDate() + 2);
        $scope.events =
            [
                {
                    date: tomorrow,
                    status: 'full'
                },
                {
                    date: afterTomorrow,
                    status: 'partially'
                }
            ];

        $scope.getDayClass = function(date, mode) {
            if (mode === 'day') {
                var dayToCheck = new Date(date).setHours(0,0,0,0);

                for (var i=0;i<$scope.events.length;i++){
                    var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

                    if (dayToCheck === currentDay) {
                        return $scope.events[i].status;
                    }
                }
            }

            return '';
        };
    })
;