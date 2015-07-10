angular.module('activePortal.schedule')

    .config(function ($stateProvider) {
        $stateProvider.state('instructors', {
            url: "/instructors",
            templateUrl: "schedule/instructors/instructors.tpl.html",
            controller: "instructorsCtrl"
        });
    })

    .controller('instructorsCtrl', function ($scope, $modal, instructorHttpClient, notificationService) {
        var FIRST_NAME_KEY = "firstName";
        var LAST_NAME_KEY = "lastName";
        var NICK_KEY = "nick";
        var OBJECT_PROPERTIES = [FIRST_NAME_KEY, LAST_NAME_KEY, NICK_KEY];

        // =======================================
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

            for (var i = 0; i < OBJECT_PROPERTIES.length; i++) {
                $scope.selected[OBJECT_PROPERTIES[i]] = {
                    value: instructor[OBJECT_PROPERTIES[i]],
                    edit: false,
                    saving: false,
                    oldVal: {}
                };
            }

            $scope.courseLoading = true;
            instructorHttpClient.courses({sid: instructor.sid}).$promise.then(
                function (value) {
                    $scope.courseLoading = false;
                    $scope.selectedCourses = value;
                }
            );
        };
        $scope.edit = function (object, property) {
            object[property].edit = true;
            object[property].oldVal = object[property].value;
        };
        $scope.cancel = function (object, property) {
            object[property].value = object[property].oldVal;
            object[property].edit = false;
        };
        $scope.save = function (object, property) {
            object[property].saving = true;
            var obj = _.findWhere($scope.instructors, {sid: object.sid});
            obj[property] = object[property].value;
            if (obj !== undefined) {
                instructorHttpClient.update({sid: object.sid}, obj).$promise.then(
                    function () {
                        object[property].edit = false;
                        object[property].saving = false;

                        notificationService.success("Pomyślnie zapisano");
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