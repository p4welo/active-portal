define([
    'schedule/module',
    'schedule/classes/modal/addClass',
    'services/notificationService',
    'services/classService'
], function (module) {

    module.controller("classesController", function ($scope, classFactory, notificationService, $modal) {
        $scope.day = '';
        $scope.classes = classFactory.find();
        $scope.days = [
            "PN", "WT", "SR", "CZ", "PT", "SB", "ND"
        ];

        $scope.add = function () {
            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/schedule/classes/modal/addClass.html',
                    controller: "addClassController"
                });

            modalInstance.result.then(function () {
                $scope.classes = classFactory.find();
                notificationService.success("Pomyślnie zapisano");
            });

        };
    });
});