define([
    'schedule/module',
    'schedule/instructors/modal/addInstructor',
    'services/notificationService',
    'services/instructorService'
], function (module) {

    module.controller("instructorsController", function ($scope, $modal, instructorFactory, instructorService, notificationService) {
        $scope.instructors = instructorFactory.findAll();

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
            $scope.selected = instructorService.copyProperties(instructor);
            $scope.selected.edit = false;
        }

        $scope.resolveStatusCss = function (instructor) {
            return {'label-success': instructor.objectState == 'ACTIVE', 'label-danger': instructor.objectState == 'INACTIVE'}
        }
    });
});