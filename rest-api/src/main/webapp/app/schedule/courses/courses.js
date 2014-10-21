define([
    'schedule/module',
    'schedule/courses/modal/addCourse',
    'services/notificationService',
    'services/courseService'
], function (module) {

    module.controller("coursesController", function ($scope, courseHttpClient, courseService, notificationService, $modal) {
        $scope.day = '';
        $scope.classes = courseHttpClient.findAll();
        $scope.days = [
            "PN", "WT", "SR", "CZ", "PT", "SB", "ND"
        ];

        $scope.add = function () {
            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/schedule/courses/modal/addCourse.html',
                    controller: "addCourseController"
                });

            modalInstance.result.then(function () {
                $scope.classes = courseHttpClient.findAll();
                notificationService.success("Pomyślnie zapisano");
            });
        };

        $scope.publish = function (course) {
            courseHttpClient.publish({ sid: course.sid }).$promise.then(
                function (value) {
                    course.objectState = value.objectState;
                    $scope.classes = courseHttpClient.findAll();
                    notificationService.success("Pomyślnie zapisano");
                });
        }

        $scope.deactivate = function (course) {
            courseHttpClient.deactivate({ sid: course.sid }).$promise.then(
                function (value) {
                    course.objectState = value.objectState;
                    $scope.classes = courseHttpClient.findAll();
                    notificationService.success("Pomyślnie zapisano");
                });
        }

        $scope.select = function (course) {
            if ($scope.selected != null && $scope.selected.sid == course.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selected = courseService.copyProperties(course);
            $scope.selected.edit = false;
        }

        $scope.resolveStatusCss = function (course) {
            return {'label-success': course.objectState == 'ACTIVE', 'label-danger': course.objectState == 'INACTIVE'}
        }
    });
});