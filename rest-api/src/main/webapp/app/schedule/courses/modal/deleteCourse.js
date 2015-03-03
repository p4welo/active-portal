define([
    'schedule/module'
], function (module) {
    module.controller('deleteCourseController', ['$scope, $modalInstance', function ($scope, $modalInstance) {
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.confirm = function () {
            $modalInstance.close();
        };
    }]);
});