require([
    'angular',
    'app'
], function (angular) {
    "use strict";

    angular.bootstrap(document.getElementsByTagName("body")[0], ['activePortal']);
});