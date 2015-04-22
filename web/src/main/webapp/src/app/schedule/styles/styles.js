angular.module('activePortal.schedule')

    .config(function ($stateProvider) {
        $stateProvider.state('styles', {
            url: "/styles",
            templateUrl: "schedule/styles/styles.tpl.html",
            controller: "stylesCtrl"
        });
    })

    .controller('stylesCtrl', function ($scope) {
        $scope.test = "styles";
    })
;