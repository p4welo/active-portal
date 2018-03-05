/* jshint -W024 */
angular.module('activePortal.services')

    .factory('roomHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.REST_URL;

        return $resource(null, null, {

            findAll: {
                url: url + "room/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "room/create",
                method: 'POST'
            },
            activate: {
                url: url + "room/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "room/:sid/deactivate",
                method: 'GET'
            },
            get: {
                url: url + "room/:sid",
                method: 'GET'
            },
            update: {
                url: url + "room/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "room/:sid",
                method: 'DELETE'
            }
        });
    })
;