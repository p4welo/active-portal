define([
    'schedule/module',
    'services/categoryService',
    'services/styleService',
    'services/instructorService',
    'services/roomService'
], function (module) {

    module.controller('addCourseController', function ($scope, $modalInstance, categoryFactory, styleFactory, instructorFactory, roomFactory) {
        $scope.course = {};

        $scope.styles = styleFactory.findAll();
        $scope.instructors = instructorFactory.findAll();
        $scope.rooms = roomFactory.findAll();
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
            categoryFactory.create(course).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }
    });

});