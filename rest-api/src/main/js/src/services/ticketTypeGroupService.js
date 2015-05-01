/* jshint -W024 */
angular.module('activePortal.services')

    .factory('ticketTypeGroupHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.URL;

        return $resource(null, null, {
            findAll: {
                url: url + "rest/ticket/group/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "rest/ticket/group/create",
                method: 'POST'
            },
            activate: {
                url: url + "rest/ticket/group/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "rest/ticket/group/:sid/deactivate",
                method: 'GET'
            },
            get: {
                url: url + "rest/ticket/group/:sid",
                method: 'GET'
            },
            update: {
                url: url + "rest/ticket/group/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "rest/ticket/group/:sid",
                method: 'DELETE'
            }
        });
    })
;