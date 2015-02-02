define([
    'schedule/module'
], function (module) {

    module.controller('deleteCourseController', function ($scope, $modalInstance) {

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.confirm = function () {
            $modalInstance.close();
        }
    })
});