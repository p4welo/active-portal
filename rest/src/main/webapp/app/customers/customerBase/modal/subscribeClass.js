define([
    'schedule/module',
    'services/classService'
], function (module) {

    module.controller('subscribeClassController', function ($scope, classFactory) {
        $scope.classes = classFactory.find();
    });

});