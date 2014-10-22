define([
    'schedule/module',
    'services/instructorService'
], function (module) {

    module.controller('addInstructorController', function ($scope, $modalInstance, instructorHttpClient) {
        $scope.instructor = {};

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (instructor) {
            instructorHttpClient.create(instructor).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }
    });

});