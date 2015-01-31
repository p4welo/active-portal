define([
    'core/module'
], function (module) {

    module.controller('deleteStyleController', function (courses, $scope, $modalInstance) {

        $scope.courses = courses;
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.confirm = function () {
            $modalInstance.close();
        }
    })
});