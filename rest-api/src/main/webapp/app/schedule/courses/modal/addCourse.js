define([
    'schedule/module',
    'services/categoryService',
    'services/styleService',
    'services/instructorService',
    'services/roomService'
], function (module) {

    module.controller('addCourseController', function ($scope, $modalInstance, categoryFactory, styleFactory, instructorFactory, roomFactory) {
        $scope.style = {};

        $scope.styles = styleFactory.find();
        $scope.instructors = instructorFactory.find();
        $scope.rooms = roomFactory.find();
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

        $scope.save = function (style) {
            styleFactory.create(style);
            $modalInstance.close();
        }
    });

});