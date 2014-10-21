define([
    'schedule/module',
    'services/instructorService'
], function (module) {

    module.controller('addInstructorController', function ($scope, $modalInstance, instructorFactory) {
        $scope.instructor = {};

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (instructor) {
            instructorFactory.create(instructor).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }
    });

});