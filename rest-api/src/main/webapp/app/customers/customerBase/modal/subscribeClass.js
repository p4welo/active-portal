define([
    'schedule/module',
    'services/courseService'
], function (module) {

    module.controller('subscribeClassController', function ($scope, courseFactory) {
        $scope.classes = courseFactory.find();
    });

});