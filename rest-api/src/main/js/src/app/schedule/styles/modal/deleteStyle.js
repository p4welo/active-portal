angular.module('activePortal.schedule')

    .controller('deleteStyleCtrl', function (courses, $scope, $modalInstance) {
        $scope.courses = courses;
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.confirm = function () {
            $modalInstance.close();
        };
    })
;