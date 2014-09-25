define([
    'schedule/module',
    'services/classService'
], function (module) {

    module.controller('joinClassController', function ($scope, classFactory) {
        $scope.day = 'PN';
        $scope.classes = classFactory.find();
    });

});