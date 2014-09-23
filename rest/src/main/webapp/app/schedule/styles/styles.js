define([
    'schedule/module',
    'schedule/styles/modal/addStyle',
    'services/styleService',
    'services/categoryService',
    'services/notificationService'
], function (module) {

    module.controller("stylesController", function ($scope, $modal, styleFactory, categoryFactory, notificationService) {

        $scope.styles = styleFactory.find();
        $scope.categories = categoryFactory.find();

        $scope.add = function () {
            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/schedule/styles/modal/addStyle.html',
                    controller: "addStyleController"
                });

            modalInstance.result.then(function () {
                $scope.styles = styleFactory.find();
                notificationService.success("Pomyślnie zapisano");
            });
        };

    });
});