angular.module('activePortal.schedule')

    .config(function ($stateProvider) {
        $stateProvider.state('roomReservation', {
            url: "/room/reservation",
            templateUrl: "schedule/reservation/roomReservation.tpl.html",
            controller: "roomReservationCtrl"
        });
    })

    .controller('roomReservationCtrl', function ($scope, $modal, notificationService, coreHttpClient, reservationHttpClient, $filter) {
        $scope.loading = true;

        $scope.days = [
            "PN", "WT", "SR", "CZ", "PT", "SB", "ND"
        ];
        $scope.events = [];
        $scope.reservationList = [];
        $scope.roomList = [];
        coreHttpClient.findAll({type: "room"}).$promise.then(
            function (result) {
                $scope.roomList = result;
            }
        );

        $scope.add = function () {
            $modal.open(
                {
                    templateUrl: 'schedule/reservation/modal/addReservation.tpl.html',
                    controller: "addReservationCtrl",
                    resolve: {
                        rooms: function () {
                            return $scope.roomList;
                        }
                    }
                }
            ).result.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    $("#calendar").fullCalendar('refetchEvents');
                }
            );
        };

        function resolveClassName(event) {
            var colors = [
                ['themed-color-dark-flatie themed-border-dark-amethyst themed-background-flatie'],
                ['themed-border-fire themed-background-coral']
            ];
            for (var i = 0; i < $scope.roomList.length; i++) {
                if (event.room && $scope.roomList[i].sid === event.room.sid) {
                    return colors[i];
                }
            }
            return ['themed-border-fire themed-background-autumn'];
        }

        function resolveEventTitle(event) {
            var $translate = $filter('translate');
            var result = "";
            if (event.type == "COURSE") {
                result = event.description;
            }
            else {
                result = $translate(event.eventType);
            }
            return result;
        }

        function resolveEventList(from, to) {
            from.forEach(function (event) {
                to.push({
                    title: resolveEventTitle(event),
                    allDay: false,
                    start: getStartDate(event),
                    end: getEndDate(event),
                    className: resolveClassName(event),
                    event: event
                });
            });
        }

        function getStartDate(event) {
            var year = event.date.values[0];
            var month = event.date.values[1] - 1;
            var day = event.date.values[2];

            var hour = event.startHour;
            var minute = event.startMinute;

            return new Date(year, month, day, hour, minute, 0, 0);
        }

        function getEndDate(event) {
            var year = event.date.values[0];
            var month = event.date.values[1] - 1;
            var day = event.date.values[2];

            var hour = event.endHour;
            var minute = event.endMinute;

            return new Date(year, month, day, hour, minute, 0, 0);
        }

        $scope.eventsFunction = function (start, end, timezone, callback) {
            $scope.loading = true;
            var events = [];
            reservationHttpClient.findByDateRange({start: start, end: end}).$promise.then(
                function (result) {
                    $scope.reservationList = result;
                    resolveEventList(result, events);
                    callback(events);
                    $scope.loading = false;
                }
            );
        };

        $scope.onEventClick = function (cell) {
            $modal.open(
                {
                    templateUrl: 'schedule/reservation/modal/showReservation.tpl.html',
                    controller: "showReservationCtrl",
                    resolve: {
                        event: function () {
                            return cell.event;
                        }
                    }
                }
            ).result.then(
                function () {

                }
            );
        };
        $scope.uiConfig = {
            calendar: {
                defaultView: "agendaWeek",
                axisFormat: 'H:mm',
                allDaySlot: false,
                slotDuration: "00:15:00",
                minTime: "07:00:00",
                firstDay: 1,
                maxTime: "23:00:00",
                height: 'auto',
                timeFormat: 'H:mm',
                columnFormat: {
                    week: 'dddd'
                },
                editable: false,
                header: {
                    left: 'title',
                    center: '',
                    right: 'today prev,next'
                },
                eventClick: $scope.onEventClick
            }
        };

        $scope.eventSources = [$scope.eventsFunction];
    })
;