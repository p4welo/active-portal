define([
    'schedule/module',
    'schedule/instructors/modal/addInstructor',
    'services/notificationService',
    'services/instructorService'
], function (module) {

    module.controller("instructorsController", function ($scope, $modal, instructorHttpClient, notificationService) {
        $scope.instructorLoading = true;
        instructorHttpClient.findAll().$promise.then(
            function (result) {
                $scope.instructors = result;
                $scope.instructorLoading = false;
            }
        );
        $scope.selectedCourses = [];

        $scope.add = function () {
            var modalInstance = $modal.open({
                templateUrl: 'app/schedule/instructors/modal/addInstructor.html',
                controller: "addInstructorController"
            });

            modalInstance.result.then(function () {
                instructorHttpClient.findAll().$promise.then(
                    function (result) {
                        $scope.instructors = result;
                    });
                notificationService.success("Pomyślnie zapisano");
            });
        }

        $scope.select = function (instructor) {
            if ($scope.selected != null && $scope.selected.sid == instructor.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selectedCourses = [];
            $scope.selected = angular.copy(instructor);
            $scope.courseLoading = true;
            instructorHttpClient.courses({sid: instructor.sid}).$promise.then(
                function (value) {
                    $scope.courseLoading = false;
                    $scope.selectedCourses = value;
                });
            $scope.selected.edit = false;
        }

        $scope.update = function (instructor) {
            delete instructor['edit'];
            instructorHttpClient.update({ sid: instructor.sid }, instructor).$promise.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    instructorHttpClient.findAll().$promise.then(
                        function (result) {
                            $scope.instructors = result;
                        });
                });
        }

        $scope.resolveStatusCss = function (instructor) {
            return {'label-success': instructor.objectState == 'ACTIVE', 'label-danger': instructor.objectState == 'INACTIVE'}
        }
    });
});