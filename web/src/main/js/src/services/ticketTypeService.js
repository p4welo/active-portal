/* jshint -W024 */
angular.module('activePortal.services')

    .factory('ticketTypeHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.URL;

        return $resource(null, null, {
            findAll: {
                url: url + "rest/ticket/type/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "rest/ticket/type/create",
                method: 'POST'
            },
            activate: {
                url: url + "rest/ticket/type/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "rest/ticket/type/:sid/deactivate",
                method: 'GET'
            },
            get: {
                url: url + "rest/ticket/type/:sid",
                method: 'GET'
            },
            update: {
                url: url + "rest/ticket/type/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "rest/ticket/type/:sid",
                method: 'DELETE'
            }
        });
    })
;