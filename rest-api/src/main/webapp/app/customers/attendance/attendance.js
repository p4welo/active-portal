define([
    'customers/module',
    'customers/attendance/modal/sellPass',
    'services/courseService'
], function (module) {

    module.controller("attendanceController", ['$scope', '$modal', 'courseHttpClient', function ($scope, $modal, courseHttpClient) {
        $scope.day = 'PN';
        $scope.courses = courseHttpClient.findInProgress();
        $scope.selectedCourse = null;
        $scope.selectedLesson = null;
        $scope.lessons = [];

        $scope.loadingLessons = false;
        $scope.loadingPresence = false;

        $scope.setDay = function (day) {
            $scope.selectedCourse = null;
            $scope.day = day;
        }

        $scope.sellPass = function () {
            $modal.open({
                templateUrl: 'app/customers/attendance/modal/sellPass.html',
                controller: "sellPassController",
                size: 'lg'
            });
        };
        $scope.checkByPass = function () {
            $modal.open({
                templateUrl: 'app/customers/attendance/modal/checkByPass.html'
            });
        };
        $scope.checkByCustomer = function () {
            $modal.open({
                templateUrl: 'app/customers/attendance/modal/checkByCustomer.html'
            });
        };

        $scope.selectCourse = function (course) {
            if ($scope.selectedCourse != null && $scope.selectedCourse.sid == course.sid) {
                $scope.selectedCourse = null;
                return;
            }
            $scope.selectedCourse = angular.copy(course);

            $scope.lessons = courseHttpClient.findLessons({sid: course.sid});
        }

        $scope.selectLesson = function (lesson) {
            if ($scope.selectedLesson != null && $scope.selectedLesson.sid == lesson.sid) {
                $scope.selectedLesson = null;
                return;
            }
            $scope.selectedLesson = angular.copy(lesson);

//            $scope.loadingPresence = true;
            $scope.presence = courseHttpClient.findPresence({sid: lesson.sid});
        }


    }]);
});