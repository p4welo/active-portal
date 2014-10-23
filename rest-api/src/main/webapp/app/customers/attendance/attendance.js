define([
    'customers/module',
    'services/courseService'
], function (module) {

    module.controller("attendanceController", function ($scope, courseHttpClient) {
        $scope.day = 'PN';
        $scope.classes = courseHttpClient.findInProgress();

    });
});