angular.module('activePortal.schedule')

    .config(function ($stateProvider) {
        $stateProvider.state('courses', {
            url: "/courses",
            templateUrl: "schedule/courses/courses.tpl.html",
            controller: "coursesCtrl"
        });
    })

    .controller('coursesCtrl', function ($scope) {
        $scope.test = "courses";
    })
;