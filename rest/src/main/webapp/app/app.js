define([
    'uiRouter',
    'ngAnimate',
    'ngTouch',
    'loadingBar',

    'services/module',

    'customers/index',
    'news/index',
    'schedule/index',
    'system/index'
], function () {

    return angular.module('activePortal', [
        'ngAnimate',
        'ngTouch',
        'ui.router',
        'angular-loading-bar',

        'activePortal.system',
        'activePortal.schedule',
        'activePortal.news',
        'activePortal.customers',
        'activePortal.services',

        'activePortal.services'
    ], function ($urlRouterProvider) {

        $urlRouterProvider.otherwise("/users");
    });
});