define([
    'schedule/module',
    'schedule/instructors/modal/addInstructor',
    'services/notificationService',
    'services/instructorService'
], function (module) {

    module.controller("instructorsController", function ($scope, $modal, instructorFactory, instructorService, notificationService) {
        $scope.instructors = instructorFactory.findAll();
        $scope.selectedCourses = [];

        $scope.add = function () {
            var modalInstance = $modal.open({
                templateUrl: 'app/schedule/instructors/modal/addInstructor.html',
                controller: "addInstructorController"
            });

            modalInstance.result.then(function () {
                $scope.rooms = instructorFactory.findAll();
                notificationService.success("Pomyślnie zapisano");
            });
        }

        $scope.select = function (instructor) {
            if ($scope.selected != null && $scope.selected.sid == instructor.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selectedCourses = [];
            $scope.selected = instructorService.copyProperties(instructor);
            instructorFactory.courses({sid: instructor.sid}).$promise.then(
                function (value) {
                    $scope.selectedCourses = value;
                });
            $scope.selected.edit = false;
        }

        $scope.update = function (instructor) {
            delete instructor['edit'];
            instructorFactory.update({ sid: instructor.sid }, instructor).$promise.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    $scope.instructors = instructorFactory.findAll();
                });
        }

        $scope.resolveStatusCss = function (instructor) {
            return {'label-success': instructor.objectState == 'ACTIVE', 'label-danger': instructor.objectState == 'INACTIVE'}
        }
    });
});