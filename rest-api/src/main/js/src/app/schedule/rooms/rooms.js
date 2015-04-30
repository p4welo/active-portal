angular.module('activePortal.schedule')

    .config(function ($stateProvider) {
        $stateProvider.state('rooms', {
            url: "/rooms",
            templateUrl: "schedule/rooms/rooms.tpl.html",
            controller: "roomsCtrl"
        });
    })

    .controller('roomsCtrl', function ($scope) {
        $scope.test = "rooms";
    })
;