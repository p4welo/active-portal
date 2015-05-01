/* jshint -W024 */
angular.module('activePortal.services')

    .factory('ticketHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.URL;

        return $resource(null, null, {
            findAll: {
                url: url + "rest/ticket/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "rest/ticket/create",
                method: 'POST'
            },
            activate: {
                url: url + "rest/ticket/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "rest/ticket/:sid/deactivate",
                method: 'GET'
            },
            get: {
                url: url + "rest/ticket/:sid",
                method: 'GET'
            },
            update: {
                url: url + "rest/ticket/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "rest/ticket/:sid",
                method: 'DELETE'
            },
            findCustomerByCode: {
                url: url + "rest/ticket/:code/customer",
                method: 'GET'
            },
            findByCode: {
                url: url + "rest/ticket/code/:code",
                method: 'GET'
            }
        });
    })
;