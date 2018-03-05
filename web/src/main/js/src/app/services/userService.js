/* jshint -W024 */
angular.module('activePortal.services')

    .factory('userHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.REST_URL;

        return $resource(null, null, {

            findAll: {
                url: url + "user/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "user/create",
                method: 'POST'
            },
            get: {
                url: url + "user/:sid",
                method: 'GET'
            },
            activate: {
                url: url + "user/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "user/:sid/deactivate",
                method: 'GET'
            },
            update: {
                url: url + "user/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "user/:sid",
                method: 'DELETE'
            }
        });
    })
;