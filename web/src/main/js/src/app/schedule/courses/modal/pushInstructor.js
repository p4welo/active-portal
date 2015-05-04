angular.module('activePortal.schedule')

    .controller('pushInstructorCtrl', function ($scope, $modalInstance, instructorHttpClient, $timeout) {
        $scope.instructorLoading = true;
        instructorHttpClient.findAll().$promise.then(
            function (result) {
                $scope.instructors = result;
                $scope.instructorLoading = false;
            }
        )

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (category) {
        };
        $scope.focusInput = function (id) {
            $timeout(function () {
                $(id).focus();
            }, 100);
        };
    })
;