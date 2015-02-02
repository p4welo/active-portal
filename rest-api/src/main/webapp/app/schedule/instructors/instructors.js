define([
    'schedule/module',
    'schedule/instructors/modal/addInstructor',
    'services/notificationService',
    'services/instructorService'
], function (module) {

    module.controller("instructorsController", function ($scope, $modal, instructorHttpClient, notificationService) {

        var FIRST_NAME_KEY = "firstName";
        var LAST_NAME_KEY = "lastName";
        var NICK_KEY = "nick";
        var OBJECT_PROPERTIES = [FIRST_NAME_KEY, LAST_NAME_KEY, NICK_KEY];

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

            for (var i = 0; i < OBJECT_PROPERTIES.length; i++) {
                $scope.selected[OBJECT_PROPERTIES[i]] = {
                    value: instructor[OBJECT_PROPERTIES[i]],
                    edit: false,
                    saving: false,
                    hover: false,
                    oldVal: {}
                }
            }

            $scope.courseLoading = true;
            instructorHttpClient.courses({sid: instructor.sid}).$promise.then(
                function (value) {
                    $scope.courseLoading = false;
                    $scope.selectedCourses = value;
                });
        }
        $scope.edit = function (object, property) {
            object[property].edit = true;
            object[property].oldVal = object[property].value;
        }
        $scope.cancel = function (object, property) {
            object[property].value = object[property].oldVal;
            object[property].edit = false;
            object[property].hover = false;
        }
        $scope.hover = function (object, property) {
            object[property].hover = true;
        }
        $scope.leave = function (object, property) {
            object[property].hover = false;
        }
        $scope.save = function (object, property) {
            object[property].saving = true;
            var obj = _.findWhere($scope.instructors, {sid: object.sid});
            obj[property] = object[property].value;
            if (obj != null) {
                instructorHttpClient.update({ sid: object.sid }, obj).$promise.then(
                    function () {
                        object[property].edit = false;
                        object[property].saving = false;
                        object[property].hover = false;

                        notificationService.success("Pomyślnie zapisano");
                        instructorHttpClient.findAll().$promise.then(
                            function (result) {
                                $scope.rooms = result;
                            });
                    });
            }
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

        $scope.delete = function (instructor) {
            var modalInstance = $modal.open({
                templateUrl: 'app/core/modal/deleteConfirm.html',
                controller: "deleteConfirmDialogController"
            });

            modalInstance.result.then(function () {
                $scope.selected = null;
                instructorHttpClient.delete({sid: instructor.sid}).$promise.then(
                    function () {
                        notificationService.success("Pomyślnie usunięto");
                        instructorHttpClient.findAll().$promise.then(
                            function (result) {
                                $scope.instructors = result;
                            })
                    }
                )
            });
        }
    });
});