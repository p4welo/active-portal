angular.module('activePortal.schedule')

    .config(function ($stateProvider) {
        $stateProvider.state('courses', {
            url: "/courses",
            templateUrl: "schedule/courses/courses.tpl.html",
            controller: "coursesCtrl"
        });
    })

    .controller('coursesCtrl', function ($scope, $rootScope, courseHttpClient, notificationService, $modal, styleHttpClient, instructorHttpClient, roomHttpClient) {
        var STYLE_KEY = "style";
        var LEVEL_KEY = "level";
        var STATE_KEY = "courseState";
        var DAY_KEY = "day";
        var START_TIME_KEY = "startTime";
        var END_TIME_KEY = "endTime";
        var ROOM_KEY = "room";
        var OBJECT_PROPERTIES = [STYLE_KEY, LEVEL_KEY, STATE_KEY, DAY_KEY, START_TIME_KEY, END_TIME_KEY, ROOM_KEY];

        $scope.courseLoading = true;
        courseHttpClient.findAll().$promise.then(
            function (result) {
                $scope.classes = result;
                $scope.courseLoading = false;
                return styleHttpClient.findAll().$promise;
            }
        ).then(
            function (result) {
                $scope.styles = result;
                return instructorHttpClient.findAll().$promise;
            }
        ).then(
            function (result) {
                $scope.instructors = result;
                return roomHttpClient.findAll().$promise;
            }
        ).then(
            function (result) {
                $scope.rooms = result;
            }
        );

        $scope.day = 'PN';
        $scope.days = [
            "PN", "WT", "SR", "CZ", "PT", "SB", "ND"
        ];
        $scope.levels = [
            "OPEN", "BEGINNER", "INTERMEDIATE", "ADVANCED"
        ];
        $scope.states = [
            "REGISTRATION",
            "CAN_JOIN",
            "NO_PLACE"
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
            $modal.open(
                {
                    templateUrl: 'schedule/courses/modal/addCourse.tpl.html',
                    controller: "addCourseCtrl",
                    resolve: {
                        styles: function () {
                            return $scope.styles;
                        },
                        instructors: function () {
                            return $scope.instructors;
                        },
                        rooms: function () {
                            return $scope.rooms;
                        }
                    },
                    backdrop: 'static'
                }
            ).result.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    return courseHttpClient.findAll().$promise;
                }
            ).then(
                function (result) {
                    $scope.classes = result;
                }
            );
        };

        $scope.publish = function (course) {
            if (angular.isObject(course)) {
                courseHttpClient.publish({sid: course.sid}).$promise.then(
                    function (result) {
                        course.objectState = result.objectState;
                        notificationService.success("Pomyślnie zapisano");

                        return courseHttpClient.findAll().$promise;
                    }
                ).then(
                    function (result) {
                        $scope.classes = result;
                    }
                );
            }
        };
        $scope.reassignInstructors = function (course) {
            if (angular.isObject(course)) {

                $modal.open(
                    {
                        templateUrl: 'schedule/courses/modal/editCourseInstructors.tpl.html',
                        controller: "editCourseInstructorsCtrl",
                        resolve: {
                            courseInstructors: function () {
                                return course.instructors;
                            },
                            allInstructors: function () {
                                return $scope.instructors;
                            },
                            course: function () {
                                return course;
                            }
                        },
                        backdrop: 'static'
                    }
                ).result.then(
                    function () {
                        notificationService.success("Pomyślnie zapisano");
                        return courseHttpClient.findAll().$promise;
                    }
                ).then(
                    function (result) {
                        $scope.classes = result;
                        course.instructors = _.findWhere(result, {sid: course.sid}).instructors;
                    }
                );
            }
        };

        $scope.setDay = function (day) {
            $scope.selected = undefined;
            $scope.day = day;
        };

        $scope.delete = function (course) {
            if (angular.isObject(course)) {

                $modal.open(
                    {
                        templateUrl: 'common/modal/deleteConfirm.tpl.html',
                        controller: "deleteConfirmDialogCtrl",
                        backdrop: 'static'
                    }
                ).result.then(
                    function () {
                        $scope.selected = undefined;
                        return courseHttpClient.delete({sid: course.sid}).$promise;
                    }
                ).then(
                    function () {
                        notificationService.success("Pomyślnie zapisano");
                        return courseHttpClient.findAll().$promise;
                    }
                ).then(
                    function (result) {
                        $scope.classes = result;
                    }
                );
            }
        };

        $scope.deactivate = function (course) {
            if (angular.isObject(course)) {
                courseHttpClient.deactivate({sid: course.sid}).$promise.then(
                    function (result) {
                        course.objectState = result.objectState;
                        notificationService.success("Pomyślnie usunięto");
                        return courseHttpClient.findAll().$promise;
                    }
                ).then(
                    function (result) {
                        $scope.classes = result;
                    }
                );
            }
        };

        $scope.select = function (course) {
            if ($scope.selected && $scope.selected.sid == course.sid) {
                $scope.selected = undefined;
                $scope.lessons = [];
                return;
            }
            $scope.selected = angular.copy(course);
        };
        //$scope.edit = function (object, property) {
        //    object[property].edit = true;
        //    object[property].oldVal = object[property].value;
        //    if (property == START_TIME_KEY || property == END_TIME_KEY) {
        //        var obj = object[property].value.split(":");
        //        object[property].value = {
        //            hours: obj[0],
        //            minutes: obj[1]
        //        };
        //    }
        //};
        //$scope.cancel = function (object, property) {
        //    object[property].value = object[property].oldVal;
        //    object[property].edit = false;
        //};
        $scope.save = function (course, property, callback) {
            var action;
            if (property == STYLE_KEY) {
                action = courseHttpClient.setStyle({sid: course.sid}, course.style);
            }
            else if (property == ROOM_KEY) {
                action = courseHttpClient.setRoom({sid: course.sid}, course.room);
            }
            else {
                var obj = _.findWhere($scope.classes, {sid: course.sid});
                if (obj) {
                    var newVal = course[property];
                    obj[property] = newVal;
                    action = courseHttpClient.update({sid: obj.sid}, obj);
                }
            }

            if (action) {
                action.$promise.then(
                    function () {
                        notificationService.success("Pomyślnie zapisano");
                        callback();
                        return courseHttpClient.findAll().$promise;
                    }
                ).then(
                    function (result) {
                        $scope.classes = result;
                    }
                );
            }
        };
    })
;