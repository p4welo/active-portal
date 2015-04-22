angular.module('activePortal.dashboard')

    .config(function ($stateProvider) {
        $stateProvider.state('dashboard', {
            url: '/dashboard',
            controller: 'dashboardCtrl',
            templateUrl: 'dashboard/start/start.tpl.html'
        });
    })

    .controller('dashboardCtrl', function ($scope) {

    })
;