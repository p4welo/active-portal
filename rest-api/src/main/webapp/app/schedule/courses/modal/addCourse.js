define([
    'schedule/module',
    'services/courseService',
    'services/styleService',
    'services/instructorService',
    'services/roomService'
], function (module) {

    module.controller('addCourseController', function ($scope, $modalInstance, courseHttpClient, styleHttpClient, instructorHttpClient, roomHttpClient) {
        $scope.course = {};

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

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (course) {
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
    });

});