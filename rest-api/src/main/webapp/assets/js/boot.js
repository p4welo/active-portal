(function (head) {
    "use strict";
    head.js(
        { require: "./assets/lib/requirejs/require.js" },
        { jquery: "./assets/lib/jquery/dist/jquery.js" },
        { angular: "./assets/lib/angular/angular.js" },
        { ngLocale: "./assets/lib/angular-locale/angular-locale_pl-pl.js" },
        { bootstrap: "./assets/lib/bootstrap/dist/js/bootstrap.js" },
        { proUiPlugins: "./assets/lib/pro-ui/js/plugins.js"},
        { proUiApp: "./assets/lib/pro-ui/js/app.js"}
    )
        .ready("ALL", function () {

            require.config({
                baseUrl: './app',
                paths: {
                    'ngResource': "../assets/lib/angular-resource/angular-resource",
                    'uiRouter': "../assets/lib/angular-ui-router/release/angular-ui-router",
                    'uiBootstrap': "../assets/lib/angular-ui-bootstrap/ui-bootstrap-tpls",
                    'uiUtils': "../assets/lib/angular-ui-utils/ui-utils",
                    'ngTranslate': "../assets/lib/angular-translate/angular-translate",
                    'ngAnimate': "../assets/lib/angular-animate/angular-animate",
                    'ngTouch': "../assets/lib/angular-touch/angular-touch",
                    'loadingBar': "../assets/lib/angular-loading-bar/build/loading-bar",
                    'pnotify': "../assets/lib/pnotify/pnotify.core"
                },
                shim: {
                    'ngAnimate': {'exports': 'ngAnimate'},
                    'loadingBar': ['ngAnimate']
                }
            });

            require(["main"],

                function (bootstrap) {
                });
        });
}(window.head));