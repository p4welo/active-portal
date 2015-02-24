define([
    'schedule/module'
], function (module) {

    module.controller('deleteStyleController', ['courses', '$scope', '$modalInstance', function (courses, $scope, $modalInstance) {

        $scope.courses = courses;
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.confirm = function () {
            $modalInstance.close();
        }
    }]);
});