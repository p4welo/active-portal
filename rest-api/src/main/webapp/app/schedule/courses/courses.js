define([
    'schedule/module',
    'schedule/courses/modal/addCourse',
    'core/modal/deleteConfirm',
    'services/notificationService',
    'services/roomService',
    'services/instructorService',
    'services/courseService',
    'services/styleService'
], function (module) {

    module.controller("coursesController", ['$scope', 'courseHttpClient', 'notificationService', '$modal', 'styleHttpClient', 'instructorHttpClient', 'roomHttpClient', function ($scope, courseHttpClient, notificationService, $modal, styleHttpClient, instructorHttpClient, roomHttpClient) {

        var STYLE_KEY = "style";
        var LEVEL_KEY = "level";
        var DAY_KEY = "day";
        var START_TIME_KEY = "startTime";
        var END_TIME_KEY = "endTime";
        var ROOM_KEY = "room";
        var INSTRUCTORS_KEY = "instructors";
        var OBJECT_PROPERTIES = [STYLE_KEY, LEVEL_KEY, DAY_KEY, START_TIME_KEY, END_TIME_KEY, ROOM_KEY, INSTRUCTORS_KEY];

        $scope.courseLoading = true;
        courseHttpClient.findAll().$promise.then(
            function (result) {
                $scope.classes = result;
                $scope.courseLoading = false;
            }
        );

        $scope.styles = styleHttpClient.findAll();
        $scope.rooms = roomHttpClient.findAll();
        $scope.instructors = instructorHttpClient.findAll();

        $scope.day = 'PN';
        $scope.days = [
            "PN", "WT", "SR", "CZ", "PT", "SB", "ND"
        ];
        $scope.levels = [
            "OPEN", "BEGINNER", "INTERMEDIATE", "ADVANCED"
        ];
        $scope.hours = [];
        $scope.minutes = [];
        for (var i = 7; i < 24; i++) {
            $scope.hours.push("" + i);
        }
        for (i = 0; i < 60; i += 5) {
            var j = i;
            if (j < 10) {
                j = "0" + j;
            }
            $scope.minutes.push("" + j);
        }

        // =======================================
        $scope.sort = {
            column: 'startTime',
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
            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/schedule/courses/modal/addCourse.html',
                    controller: "addCourseController"
                });

            modalInstance.result.then(function () {
                courseHttpClient.findAll().$promise.then(
                    function (result) {
                        $scope.classes = result;
                    });
                notificationService.success("Pomyślnie zapisano");
            });
        };
        $scope.update = function (course) {
            delete course.edit;
            courseHttpClient.update({ sid: course.sid }, course).$promise.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    courseHttpClient.findAll().$promise.then(
                        function (result) {
                            $scope.classes = result;
                        }
                    );
                });
        };

        $scope.publish = function (course) {
            if (course !== undefined) {
                courseHttpClient.publish({ sid: course.sid }).$promise.then(
                    function (result) {
                        course.objectState = result.objectState;
                        courseHttpClient.findAll().$promise.then(
                            function (result) {
                                $scope.classes = result;
                            });
                        notificationService.success("Pomyślnie zapisano");
                    });
            }
        };

        $scope.setDay = function (day) {
            $scope.selected = undefined;
            $scope.day = day;
        };

        $scope.delete = function (course) {
            if (course !== undefined) {
                var modalInstance = $modal.open({
                    templateUrl: 'app/core/modal/deleteConfirm.html',
                    controller: "deleteConfirmDialogController"
                });

                modalInstance.result.then(function () {
                    $scope.selected = undefined;
                    courseHttpClient.delete({sid: course.sid}).$promise.then(
                        function () {
                            notificationService.success("Pomyślnie usunięto");
                            courseHttpClient.findAll().$promise.then(
                                function (result) {
                                    $scope.classes = result;
                                });
                        }
                    );
                });
            }
        };

        $scope.deactivate = function (course) {
            if (course !== undefined) {
                courseHttpClient.deactivate({ sid: course.sid }).$promise.then(
                    function (result) {
                        course.objectState = result.objectState;
                        courseHttpClient.findAll().$promise.then(
                            function (result) {
                                $scope.classes = result;
                            });
                        notificationService.success("Pomyślnie zapisano");
                    });
            }
        };

        $scope.select = function (course) {
            if ($scope.selected !== undefined && $scope.selected.sid == course.sid) {
                $scope.selected = undefined;
                $scope.lessons = [];
                return;
            }
            $scope.selected = angular.copy(course);
            $scope.selected.edit = false;

            for (var i = 0; i < OBJECT_PROPERTIES.length; i++) {
                $scope.selected[OBJECT_PROPERTIES[i]] = {
                    value: course[OBJECT_PROPERTIES[i]],
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
            if (property == START_TIME_KEY || property == END_TIME_KEY) {
                var obj = object[property].value.split(":");
                object[property].value = {
                    hours: obj[0],
                    minutes: obj[1]
                };
            }
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
        $scope.save = function (course, property) {
            course[property].saving = true;
            if (property == STYLE_KEY) {
                courseHttpClient.setStyle({sid: course.sid}, course.style.value).$promise.then(
                    function () {
                        course[property].edit = false;
                        course[property].saving = false;
                        course[property].hover = false;
                        courseHttpClient.findAll().$promise.then(
                            function (result) {
                                $scope.classes = result;
                            });
                        notificationService.success("Pomyślnie zapisano");
                    });
            }
            else if (property == ROOM_KEY) {
                courseHttpClient.setRoom({sid: course.sid}, course.room.value).$promise.then(
                    function () {
                        course[property].edit = false;
                        course[property].saving = false;
                        course[property].hover = false;
                        courseHttpClient.findAll().$promise.then(
                            function (result) {
                                $scope.classes = result;
                            });
                        notificationService.success("Pomyślnie zapisano");
                    });
            }
            else {
                var obj = _.findWhere($scope.classes, {sid: course.sid});
                if (obj !== undefined) {
                    var newVal = course[property].value;
                    if (property == START_TIME_KEY || property == END_TIME_KEY) {
                        obj[property] = newVal.hours + ":" + newVal.minutes;
                        course[property].value = newVal.hours + ":" + newVal.minutes;
                    }
                    else {
                        obj[property] = newVal;
                    }
                    courseHttpClient.update({ sid: obj.sid }, obj).$promise.then(
                        function () {
                            course[property].edit = false;
                            course[property].saving = false;
                            course[property].hover = false;
                            courseHttpClient.findAll().$promise.then(
                                function (result) {
                                    $scope.classes = result;
                                });
                            notificationService.success("Pomyślnie zapisano");
                        });
                }
            }
        };
    }]);
});