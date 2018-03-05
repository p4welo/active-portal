/* jshint -W024 */
angular.module('activePortal.services')

    .factory('ticketHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.REST_URL;

        return $resource(null, null, {
            findAll: {
                url: url + "ticket/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "ticket/create",
                method: 'POST'
            },
            activate: {
                url: url + "ticket/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "ticket/:sid/deactivate",
                method: 'GET'
            },
            get: {
                url: url + "ticket/:sid",
                method: 'GET'
            },
            update: {
                url: url + "ticket/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "ticket/:sid",
                method: 'DELETE'
            },
            findCustomerByCode: {
                url: url + "ticket/:code/customer",
                method: 'GET'
            },
            findByCode: {
                url: url + "ticket/code/:code",
                method: 'GET'
            }
        });
    })
;