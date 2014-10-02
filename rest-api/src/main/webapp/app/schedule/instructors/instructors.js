define([
    'schedule/module',
    'schedule/instructors/modal/addInstructor',
    'services/notificationService',
    'services/instructorService'
], function (module) {

    module.controller("instructorsController", function ($scope, $modal, instructorFactory, notificationService) {
        $scope.instructors = instructorFactory.find();

        $scope.add = function () {

            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/schedule/instructors/modal/addInstructor.html',
                    controller: "addInstructorController"
                });

            modalInstance.result.then(function () {
                $scope.rooms = instructorFactory.find();
                notificationService.success("Pomyślnie zapisano");
            });
        }
    });
});