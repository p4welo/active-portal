/* jshint -W024 */
angular.module('activePortal.services')

    .factory('ticketTypeHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.REST_URL;

        return $resource(null, null, {
            findAll: {
                url: url + "ticket/type/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "ticket/type/create",
                method: 'POST'
            },
            activate: {
                url: url + "ticket/type/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "ticket/type/:sid/deactivate",
                method: 'GET'
            },
            get: {
                url: url + "ticket/type/:sid",
                method: 'GET'
            },
            update: {
                url: url + "ticket/type/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "ticket/type/:sid",
                method: 'DELETE'
            }
        });
    })
;