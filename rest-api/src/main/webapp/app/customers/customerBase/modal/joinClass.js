define([
    'schedule/module',
    'services/courseService'
], function (module) {

    module.controller('joinClassController', function ($scope, courseFactory) {
        $scope.day = 'PN';
        $scope.classes = courseFactory.find();
    });

});