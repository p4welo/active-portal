/* jshint -W024 */
angular.module('activePortal.services')

    .factory('roomHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.URL;

        return $resource(null, null, {

            findAll: {
                url: url + "rest/room/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "rest/room/create",
                method: 'POST'
            },
            activate: {
                url: url + "rest/room/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "rest/room/:sid/deactivate",
                method: 'GET'
            },
            get: {
                url: url + "rest/room/:sid",
                method: 'GET'
            },
            update: {
                url: url + "rest/room/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "rest/room/:sid",
                method: 'DELETE'
            }
        });
    })
;