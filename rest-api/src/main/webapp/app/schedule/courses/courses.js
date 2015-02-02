define([
    'schedule/module',
    'schedule/courses/modal/addCourse',
    'schedule/courses/modal/deleteCourse',
    'services/notificationService',
    'services/courseService'
], function (module) {

    module.controller("coursesController", function ($scope, courseHttpClient, notificationService, $modal) {

        $scope.courseLoading = true;
        courseHttpClient.findAll().$promise.then(
            function (result) {
                $scope.classes = result;
                $scope.courseLoading = false;
            }
        );

        $scope.day = 'PN';
        $scope.days = [
            "PN", "WT", "SR", "CZ", "PT", "SB", "ND"
        ];
        $scope.levels = [
            "OPEN", "BEGINNER", "INTERMEDIATE", "ADVANCED"
        ];

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
            delete course['edit'];
            courseHttpClient.update({ sid: course.sid }, course).$promise.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    courseHttpClient.findAll().$promise.then(
                        function (result) {
                            $scope.classes = result;
                        }
                    );
                });
        }

        $scope.publish = function (course) {
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

        $scope.setDay = function (day) {
            $scope.selected = null;
            $scope.day = day;

        }

        $scope.delete = function (course) {
            var modalInstance = $modal.open({
                templateUrl: 'app/schedule/courses/modal/deleteCourse.html',
                controller: "deleteCourseController"
            });

            modalInstance.result.then(function () {
                $scope.selected = null;
                courseHttpClient.delete({sid: course.sid}).$promise.then(
                    function () {
                        notificationService.success("Pomyślnie usunięto");
                        courseHttpClient.findAll().$promise.then(
                            function (result) {
                                $scope.classes = result;
                            })
                    }
                )
            });
        }

        $scope.deactivate = function (course) {
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

        $scope.select = function (course) {
            if ($scope.selected != null && $scope.selected.sid == course.sid) {
                $scope.selected = null;
                $scope.lessons = [];
                return;
            }
            $scope.selected = angular.copy(course);
            $scope.selected.edit = false;
            $scope.lessons = courseHttpClient.findLessons({sid: course.sid});
        }
    });
});