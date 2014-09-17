define([

], function () {

    return angular.module('activePortal.schedule', [], function ($stateProvider) {
        $stateProvider
            .state('categories', {
                url: "/categories",
                templateUrl: "app/schedule/categories/categories.html"
            })
            .state('classes', {
                url: "/classes",
                templateUrl: "app/schedule/classes/classes.html"
            })
            .state('instructors', {
                url: "/instructors",
                templateUrl: "app/schedule/instructors/instructors.html"
            })
            .state('rooms', {
                url: "/rooms",
                templateUrl: "app/schedule/rooms/rooms.html"
            })
            .state('styles', {
                url: "/styles",
                templateUrl: "app/schedule/styles/styles.html"
            });
    });
});