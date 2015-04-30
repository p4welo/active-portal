require([
    'angular',
    'app',
    'proui'
], function (angular, App) {
    "use strict";
    angular.bootstrap(document.getElementsByTagName("body")[0], ['activePortal']);
    setTimeout(
        function() {
            App.init();
        }, 100
    );
});