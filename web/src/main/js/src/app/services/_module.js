angular.module('activePortal.services', [
    'ngResource'
])
    .constant("serverConf", {
        URL: "/ap/",
        REST_URL: "/ap/rest/"
    });