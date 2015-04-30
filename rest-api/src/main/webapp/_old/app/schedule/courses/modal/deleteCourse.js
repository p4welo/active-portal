define([
    'schedule/module'
], function (module) {
    "use strict";

    module.controller('deleteCourseController', ['$scope, $modalInstance', function ($scope, $modalInstance) {
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.confirm = function () {
            $modalInstance.close();
        };
    }]);
});