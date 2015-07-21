angular.module('activePortal.schedule')

    .config(function ($stateProvider) {
        $stateProvider.state('instructors', {
            url: "/instructors",
            templateUrl: "schedule/instructors/instructors.tpl.html",
            controller: "instructorsCtrl"
        });
    })

    .controller('instructorsCtrl', function ($scope, $modal, instructorHttpClient, notificationService) {

        $scope.instructorLoading = true;
        instructorHttpClient.findAll().$promise.then(
            function (result) {
                $scope.instructors = result;
                $scope.instructorLoading = false;
            }
        );

        // =======================================
        $scope.sort = {
            column: 'firstName',
            descending: false
        };
        $scope.toggleSort = function (column) {
            var sort = $scope.sort;
            if (sort.column == column) {
                sort.descending = !sort.descending;
            } else {
                sort.column = column;
                sort.descending = false;
            }
        };
        $scope.sortIcon = function (column) {
            var sort = $scope.sort;
            if (sort.column == column) {
                return sort.descending ? "fa fa-caret-down" : "fa fa-caret-up";
            }
            return "";
        };

        // =======================================
        $scope.selectedCourses = [];
        $scope.add = function () {
            $modal.open(
                {
                    templateUrl: 'schedule/instructors/modal/addInstructor.tpl.html',
                    controller: "addInstructorCtrl",
                    backdrop: 'static'
                }
            ).result.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    return instructorHttpClient.findAll().$promise;
                }
            ).then(
                function (result) {
                    $scope.instructors = result;
                }
            );
        };

        // =======================================
        $scope.select = function (instructor) {
            if (angular.isObject($scope.selected) && $scope.selected.sid == instructor.sid) {
                $scope.selected = undefined;
                return;
            }
            $scope.selectedCourses = [];
            $scope.selected = angular.copy(instructor);

            $scope.courseLoading = true;
            instructorHttpClient.courses({sid: instructor.sid}).$promise.then(
                function (value) {
                    $scope.courseLoading = false;
                    $scope.selectedCourses = value;
                }
            );
        };
        $scope.save = function (object, property, callback) {
            var obj = _.findWhere($scope.instructors, {sid: object.sid});
            if (obj) {
                obj[property] = object[property];
                instructorHttpClient.update({sid: object.sid}, obj).$promise.then(
                    function () {
                        notificationService.success("Pomyślnie zapisano");
                        callback();
                        return instructorHttpClient.findAll().$promise;
                    }
                ).then(
                    function (result) {
                        $scope.rooms = result;
                    }
                );
            }
        };

        // =======================================
        $scope.delete = function (instructor) {
            if (instructor !== undefined) {
                $modal.open(
                    {
                        templateUrl: 'common/modal/deleteConfirm.tpl.html',
                        controller: "deleteConfirmDialogCtrl",
                        backdrop: 'static'
                    }
                ).result.then(
                    function () {
                        $scope.selected = undefined;
                        return instructorHttpClient.delete({sid: instructor.sid}).$promise;
                    }
                ).then(
                    function () {
                        notificationService.success("Pomyślnie usunięto");
                        return instructorHttpClient.findAll().$promise;
                    }
                ).then(
                    function (result) {
                        $scope.instructors = result;
                    }
                );
            }
        };
    })
;