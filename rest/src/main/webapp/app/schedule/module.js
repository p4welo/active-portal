define([
    'uiBootstrap',
    'ngTranslate'
], function () {

    return angular.module('activePortal.schedule', ['pascalprecht.translate','ui.bootstrap'], function ($stateProvider) {
        $stateProvider
            .state('categories', {
                url: "/categories",
                templateUrl: "app/schedule/categories/categories.html",
                controller: "categoriesController"
            })
            .state('classes', {
                url: "/classes",
                templateUrl: "app/schedule/classes/classes.html",
                controller: "classesController"
            })
            .state('instructors', {
                url: "/instructors",
                templateUrl: "app/schedule/instructors/instructors.html",
                controller: "instructorsController"
            })
            .state('rooms', {
                url: "/rooms",
                templateUrl: "app/schedule/rooms/rooms.html",
                controller: "roomsController"
            })
            .state('styles', {
                url: "/styles",
                templateUrl: "app/schedule/styles/styles.html",
                controller: "stylesController"
            });
    });
});