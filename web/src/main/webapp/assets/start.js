require.config({
    baseUrl: './app',
    paths: {
        'jquery': "../vendor/jquery/dist/jquery.min",
        'lodash': "../vendor/lodash/lodash.min",
        'angular': "../vendor/angular/angular.min",
        'ngResource': "../vendor/angular-resource/angular-resource",
        'ngTranslate': "../vendor/angular-translate/angular-translate",
        'ngAnimate': "../vendor/angular-animate/angular-animate",
        'ngSanitize': "../vendor/angular-sanitize/angular-sanitize",
        'ngLocale': "../assets/lib/angular-locale_pl-pl",
        'ngTouch': "../vendor/angular-touch/angular-touch",

        'uiRouter': "../vendor/angular-ui-router/release/angular-ui-router",
        'uiBootstrap': "../assets/lib/ui-bootstrap-tpls",

        'loadingBar': "../vendor/angular-loading-bar/build/loading-bar",
        'pnotify': "../vendor/pnotify/pnotify.core"
    },
    shim: {
        'jquery': {
            'exports': '$'
        },
        'angular': {
            'exports': 'angular',
            'deps': ['jquery']
        },
        'lodash': {
            'exports': '_'
        },
        'ngAnimate': ['angular'],
        'ngSanitize': ['angular'],
        'ngResource': ['angular'],
        'ngLocale': ['angular'],
        'ngTranslate': ['angular'],
        'ngTouch': ['angular'],
        'uiRouter': ['angular'],
        'uiBootstrap': ['bootstrap', 'angular'],
        'pnotify': {
            'exports': 'PNotify',
            'deps': ['jquery']
        },
        'loadingBar': ['ngAnimate']
    }
});

require(['proui', "main"],
    function (App) {
        App.init();
    }
);