/* jshint -W024 */
angular.module('activePortal.services')

    .factory('ticketTypeGroupHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.REST_URL;

        return $resource(null, null, {
            findAll: {
                url: url + "ticket/group/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "ticket/group/create",
                method: 'POST'
            },
            activate: {
                url: url + "ticket/group/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "ticket/group/:sid/deactivate",
                method: 'GET'
            },
            get: {
                url: url + "ticket/group/:sid",
                method: 'GET'
            },
            update: {
                url: url + "ticket/group/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "ticket/group/:sid",
                method: 'DELETE'
            }
        });
    })
;