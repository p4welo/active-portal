define([

], function () {

    return angular.module('activePortal.news', [], function ($stateProvider) {
        $stateProvider
            .state('newsletter', {
                url: "/newsletter",
                templateUrl: "app/news/newsletter/newsletter.html"
            })
            .state('newsList', {
                url: "/newsList",
                templateUrl: "app/news/newsList/newsList.html"
            });
    });
});