angular.module('activePortal.schedule')

    .config(function ($stateProvider) {
        $stateProvider.state('categories', {
            url: "/categories",
            templateUrl: "schedule/categories/categories.tpl.html",
            controller: "categoriesCtrl"
        });
    })

    .controller('categoriesCtrl', function ($scope) {
        $scope.test = "dupa";
    })
;