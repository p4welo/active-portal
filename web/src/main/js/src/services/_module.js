angular.module('activePortal.services', [
    'ngResource'
])
    .constant("serverConf", {
        URL: "http://localhost:8080/ap/"
    });