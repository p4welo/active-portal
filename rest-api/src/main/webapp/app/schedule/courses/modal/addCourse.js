define([
    'schedule/module',
    'services/categoryService',
    'services/styleService',
    'services/instructorService',
    'services/roomService'
], function (module) {

    module.controller('addCourseController', function ($scope, $modalInstance, categoryHttpClient, styleHttpClient, instructorHttpClient, roomHttpClient) {
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
            categoryHttpClient.create(course).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }
    });

});