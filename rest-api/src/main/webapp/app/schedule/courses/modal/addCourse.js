define([
    'schedule/module',
    'services/courseService',
    'services/styleService',
    'services/instructorService',
    'services/roomService'
], function (module) {

    module.controller('addCourseController', ['$scope', '$modalInstance', 'courseHttpClient', 'styleHttpClient', 'instructorHttpClient', 'roomHttpClient', function ($scope, $modalInstance, courseHttpClient, styleHttpClient, instructorHttpClient, roomHttpClient) {
        $scope.course = {};
        $scope.start = {
            hours: "15",
            minutes: "00"
        }
        $scope.end = {
            hours: "16",
            minutes: "00"
        }

        $scope.styles = styleHttpClient.findAll();
        $scope.instructors = instructorHttpClient.findAll();
        $scope.rooms = roomHttpClient.findAll();
        $scope.days = [
            "PN", "WT", "SR", "CZ", "PT", "SB", "ND"
        ];
        $scope.levels = [
            "OPEN", "BEGINNER", "INTERMEDIATE", "ADVANCED"
        ];
        $scope.types = [
            "TYPE_REGISTRATION", "TYPE_OPEN", "TYPE_CLOSED"
        ];
        $scope.hours = [];
        $scope.minutes = [];
        for (var i = 7; i < 24; i++) {$scope.hours.push("" + i)}
        for (var i = 0; i < 60; i+=5) {
            var j = i;
            if (j < 10) {
                j = "0" + j;
            }
            $scope.minutes.push("" + j);
        }

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (course) {
            course.startTime = $scope.start.hours + ":" + $scope.start.minutes;
            course.endTime = $scope.end.hours + ":" + $scope.end.minutes;
            if (course.type == 'TYPE_REGISTRATION') {
                course.canRegister = true;
                course.canJoin = false;
                course.inProgress = false;
            }
            else if (course.type == 'TYPE_OPEN') {
                course.canRegister = false;
                course.canJoin = true;
                course.inProgress = true;
            }
            else if (course.type == 'TYPE_CLOSED') {
                course.canRegister = false;
                course.canJoin = false;
                course.inProgress = true;
            }

            delete course['type'];
            courseHttpClient.create(course).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }
    }]);
});