define([
    'schedule/module',
    'schedule/courses/modal/addCourse',
    'services/notificationService',
    'services/courseService'
], function (module) {

    module.controller("coursesController", function ($scope, courseHttpClient, notificationService, $modal) {
        $scope.day = 'PN';
        $scope.classes = courseHttpClient.findAll();
        $scope.days = [
            "PN", "WT", "SR", "CZ", "PT", "SB", "ND"
        ];
        $scope.levels = [
            "OPEN", "BEGINNER", "INTERMEDIATE", "ADVANCED"
        ];
//        $scope.customers = [];

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
                $scope.customers = [];
                return;
            }
            $scope.selected = angular.copy(course);
            $scope.selected.edit = false;
        }

        $scope.resolveStatusCss = function (course) {
            return {'label-success': course.objectState == 'ACTIVE', 'label-danger': course.objectState == 'INACTIVE'}
        }
    });
});