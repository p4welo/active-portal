define([
    'angular',
    //'uiRouter',
    'ngAnimate',
    'ngLocale',
    'ngTouch',
    'ngTranslate',
    'loadingBar',

    'dashboard/dashboard'
], function (angular) {
    "use strict";

    return angular.module('activePortal', [
        'ngAnimate',
        'ngTouch',
        //'ui.router',
        'angular-loading-bar',
        'pascalprecht.translate'
    ])
        .controller("menuCtrl", ["$scope", function ($scope) {
            $scope.test = "dupa";
        }]);

        //.config(['$locationProvider', '$translateProvider', '$urlRouterProvider', '$httpProvider',
        //    function ($locationProvider, $translateProvider, $urlRouterProvider, $httpProvider) {
        //
        //        $urlRouterProvider.otherwise("/dashboard");
        //        $translateProvider.preferredLanguage('pl');
        //    }
        //])
});