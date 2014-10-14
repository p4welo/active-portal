define([
    'ngSanitize'
], function () {

    return angular.module('activePortal.news', [
        'ngSanitize'
    ], function ($stateProvider) {
        $stateProvider
            .state('newsletter', {
                url: "/newsletter",
                templateUrl: "app/news/newsletter/newsletter.html",
                controller: "newsletterController"
            })
            .state('newsList', {
                url: "/newsList",
                templateUrl: "app/news/newsList/newsList.html",
                controller: "newsListController"
            });
    });
});