angular.module('activePortal.schedule')

    .controller('editCourseInstructorsCtrl', function ($scope, $rootScope, $modalInstance, courseHttpClient, courseInstructors, allInstructors, course, $timeout) {
        $scope.courseInstructors = courseInstructors;
        $scope.allInstructors = allInstructors;
        $scope.course = course;
        $scope.instructorLoading = true;

        $scope.load = function () {
            $scope.allInstructors.forEach(function (instructor) {
                if (_.findWhere($scope.courseInstructors, {'sid': instructor.sid})) {
                    instructor.isActive = true;
                }
                else {
                    instructor.isActive = false;
                }
            });
            $scope.instructorLoading = false;
            $scope.selectionCount = $scope.courseInstructors.length;
        };

        $scope.toggle = function (selected) {
            selected.isActive = !selected.isActive;
            $timeout(function () {
                var result = [];
                $scope.allInstructors.forEach(function (instructor) {
                    if (instructor.isActive) {
                        result.push(instructor);
                    }
                });
                $scope.selectionCount = result.length;
            }, 1, true);
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function () {
            var result = [];
            $scope.allInstructors.forEach(function (instructor) {
                if (instructor.isActive) {
                    result.push(instructor.sid);
                }
            });
            if (result.length > 0) {
                courseHttpClient.reassignInstructors({sid: $scope.course.sid}, {sids: result}).$promise.then(
                    function () {
                        $modalInstance.close();
                    }
                );
            }
        };
    })
;