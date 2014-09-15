angular.module('PortalApp.controllers')

    .controller('categoryController', function ($scope, categoryFactory, categoryService, notificationService) {

        $scope.categories = categoryFactory.find();

        $scope.add = function() {
            $scope.new = {};
            showModal("#add-category-modal")
        };

        $scope.create = function (category) {

            categoryFactory.create(category, function () {
                $scope.categories = categoryFactory.find();
                hideModal("#add-category-modal");
                notificationService.success("Pomyślnie zapisano");
            });
        };
    });