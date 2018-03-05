angular.module('activePortal.dashboard')

    .config(function ($stateProvider) {
        $stateProvider.state('dashboard', {
            url: '/dashboard',
            controller: 'dashboardCtrl',
            templateUrl: 'dashboard/start/start.tpl.html'
        });
    })

    .controller('dashboardCtrl', function ($scope, $timeout) {
        //$scope.labels = ["Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela"];
        //$timeout(function () {
        //    $scope.data = [
        //        [74,65,85,45,22,15,0]
        //    ];
        //}, 1000);
        //
        //$scope.colours = [
        //    '#d9416c',
        //    '#1bbae1'
        //];
        //
        //$scope.genderLabels = ["Mężczyźni", "Kobiety"];
        //$timeout(function() {
        //    $scope.genderData = [34, 66];
        //}, 500);
    })
;