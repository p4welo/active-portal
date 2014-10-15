define([
    'schedule/module',
    'schedule/courses/modal/addCourse',
    'services/notificationService',
    'services/courseService'
], function (module) {

    module.controller("coursesController", function ($scope, courseFactory, notificationService, $modal) {
        $scope.day = '';
        $scope.classes = courseFactory.findAll();
        $scope.days = [
            "PN", "WT", "SR", "CZ", "PT", "SB", "ND"
        ];

        $scope.add = function () {
            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/schedule/classes/modal/addCourse.html',
                    controller: "addCourseController"
                });

            modalInstance.result.then(function () {
                $scope.classes = courseFactory.find();
                notificationService.success("Pomyślnie zapisano");
            });

        };
    });
});