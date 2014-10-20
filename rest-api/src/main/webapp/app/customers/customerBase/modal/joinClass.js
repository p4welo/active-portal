define([
    'schedule/module',
    'services/courseService'
], function (module) {

    module.controller('joinClassController', function ($scope, courseFactory, courseService) {
        $scope.day = '';
        $scope.classes = courseFactory.findInProgress();

        $scope.select = function (course) {
            if ($scope.selected != null && $scope.selected.sid == course.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selected = courseService.copyProperties(course);
            $scope.selected.edit = false;
        }
    });

});