angular.module('activePortal.schedule')

    .config(function ($stateProvider) {
        $stateProvider.state('roomReservation', {
            url: "/room/reservation",
            templateUrl: "schedule/reservation/roomReservation.tpl.html",
            controller: "roomReservationCtrl"
        });
    })

    .controller('roomReservationCtrl', function ($scope, $modal, notificationService, coreHttpClient, $compile) {
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

        function resolveClassName(event) {
            var colors = [
                ['themed-color-dark-flatie themed-border-dark-amethyst themed-background-flatie'],
                ['themed-border-fire themed-background-coral']
            ]
            for (var i = 0; i < $scope.roomList.length; i++) {
                if ($scope.roomList[i].sid === event.roomSid) {
                    return colors[i];
                }
            }
            return ['themed-border-fire themed-background-autumn'];
        }

        function resolveEventList(from, to) {
            from.forEach(function (event) {
                to.push({
                    title: event.description,
                    allDay: false,
                    start: getStartDate(event),
                    end: getEndDate(event),
                    className: resolveClassName(event)
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

        $scope.eventsF = function (start, end, timezone, callback) {
            $scope.loading = true;
            var events = [];
            coreHttpClient.findAll({type: "reservation"}).$promise.then(
                function (result) {
                    $scope.reservationList = result;
                    resolveEventList(result, events);
                    callback(events);
                    $scope.loading = false;
                }
            );
        };

        $scope.alertOnEventClick = function (date, jsEvent, view) {
        };
        $scope.alertOnDrop = function (event, delta, revertFunc, jsEvent, ui, view) {
        };
        $scope.alertOnResize = function (event, delta, revertFunc, jsEvent, ui, view) {
        };
        $scope.uiConfig = {
            calendar: {
                defaultView: "agendaWeek",
                axisFormat: 'H:mm',
                allDaySlot: false,
                slotDuration: "00:15:00",
                minTime: "10:00:00",
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
                eventClick: $scope.alertOnEventClick,
                eventDrop: $scope.alertOnDrop,
                eventResize: $scope.alertOnResize,
                eventRender: $scope.eventRender
            }
        };

        $scope.eventRender = function (event, element, view) {
            $compile(element)($scope);
        };

        $scope.eventSources = [$scope.eventsF];

    })
;