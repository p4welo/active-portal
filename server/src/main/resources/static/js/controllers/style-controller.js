angular.module('PortalApp.controllers')

    .controller('styleController', function ($scope, styleFactory, styleService, categoryFactory, notificationService) {

        $scope.styles = styleFactory.find();
        $scope.categories = categoryFactory.find();

        $scope.add = function() {
            $scope.new = {};
            showModal("#add-style-modal")
        };

        $scope.create = function (style) {

            styleFactory.create(style, function () {
                $scope.styles = styleFactory.find();
                hideModal("#add-style-modal");
                notificationService.success("Pomyślnie zapisano");
            });
        };
    });