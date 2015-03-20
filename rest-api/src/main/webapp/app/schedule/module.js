define([
    'angular',
    'uiBootstrap',
    'ngTranslate'
], function (angular) {
    "use strict";

    return angular.module('activePortal.schedule', [
        'pascalprecht.translate',
        'ui.bootstrap'
    ], ['$stateProvider',
        function ($stateProvider) {
            $stateProvider
                .state('categories', {
                    url: "/categories",
                    templateUrl: "dist/app/schedule/categories/categories.html",
                    controller: "categoriesController"
                })
                .state('courses', {
                    url: "/courses",
                    templateUrl: "dist/app/schedule/courses/courses.html",
                    controller: "coursesController"
                })
                .state('instructors', {
                    url: "/instructors",
                    templateUrl: "dist/app/schedule/instructors/instructors.html",
                    controller: "instructorsController"
                })
                .state('rooms', {
                    url: "/rooms",
                    templateUrl: "dist/app/schedule/rooms/rooms.html",
                    controller: "roomsController"
                })
                .state('styles', {
                    url: "/styles",
                    templateUrl: "dist/app/schedule/styles/styles.html",
                    controller: "stylesController"
                });
        }
    ]);
});