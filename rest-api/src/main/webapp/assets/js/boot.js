(function (head) {
    "use strict";
    head.js(
        { require: "./vendor/requirejs/require.js" },
        { jquery: "./vendor/jquery/dist/jquery.min.js" },
        { angular: "./vendor/angular/angular.min.js" },
        { ngLocale: "./vendor/angular-locale/angular-locale_pl-pl.js" },
        { bootstrap: "./vendor/bootstrap/dist/js/bootstrap.min.js" }
    )
        .ready("ALL", function () {

            require.config({
                baseUrl: './app',
                paths: {
                    'ngResource': "../vendor/angular-resource/angular-resource",
                    'uiRouter': "../vendor/angular-ui-router/release/angular-ui-router",
                    'uiBootstrap': "../vendor/angular-ui-bootstrap/ui-bootstrap-tpls",
                    'uiUtils': "../vendor/angular-ui-utils/ui-utils",
                    'ngTranslate': "../vendor/angular-translate/angular-translate",
                    'ngAnimate': "../vendor/angular-animate/angular-animate",
                    'ngSanitize': "../vendor/angular-sanitize/angular-sanitize",
                    'ngTouch': "../vendor/angular-touch/angular-touch",
                    'loadingBar': "../vendor/angular-loading-bar/build/loading-bar",
                    'pnotify': "../vendor/pnotify/pnotify.core",
                    'proUiPlugins': "../assets/lib/pro-ui/js/plugins",
                    'proUiApp': "../assets/lib/pro-ui/js/app"
                },
                shim: {
                    'ngAnimate': {
                        'exports': 'ngAnimate'
                    },
                    'loadingBar': {
                        'exports': 'loadingBar',
                        'deps': ['ngAnimate']
                    },
                    'proUiPlugins': {
                        'exports': 'proUiPlugins'
                    },
                    'proUiApp': {
                        'exports': 'proUiApp',
                        'deps': ['proUiPlugins']
                    }
                }
            });

            require([
                    "proUiApp",
                    "main"
                ],

                function (bootstrap) {
                });
        });
}(window.head));