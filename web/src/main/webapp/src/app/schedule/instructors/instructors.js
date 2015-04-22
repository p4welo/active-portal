angular.module('activePortal.schedule')

    .config(function ($stateProvider) {
        $stateProvider.state('instructors', {
            url: "/instructors",
            templateUrl: "schedule/instructors/instructors.tpl.html",
            controller: "instructorsCtrl"
        });
    })

    .controller('instructorsCtrl', function ($scope) {
        $scope.test = "instructorsCtrl";
    })
;