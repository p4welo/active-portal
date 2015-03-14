define([
    'jquery',
    'schedule/module',
    'services/instructorService'
], function ($, module) {

    module.controller('addInstructorController', ['$scope', '$modalInstance', 'instructorHttpClient', '$timeout', function ($scope, $modalInstance, instructorHttpClient, $timeout) {
        $scope.instructor = {};

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (instructor) {
            instructorHttpClient.create(instructor).$promise.then(
                function () {
                    $modalInstance.close();
                });
        };
        $scope.focusInput = function (id) {
            $timeout(function () {
                $(id).focus();
            }, 100);
        };
    }]);
});