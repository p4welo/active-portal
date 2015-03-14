define([
    'angular',
    'ngSanitize',
    'ngTranslate'
], function (angular) {

    return angular.module('activePortal.news', [
        'ngSanitize',
        'pascalprecht.translate'
    ], ['$stateProvider',
        function ($stateProvider) {
        $stateProvider
            .state('newsletter', {
                url: "/newsletter",
                templateUrl: "dist/app/news/newsletter/newsletter.html",
                controller: "newsletterController"
            })
            .state('newsList', {
                url: "/newsList",
                templateUrl: "dist/app/news/newsList/newsList.html",
                controller: "newsListController"
            });
    }
    ]);
});