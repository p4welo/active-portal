/* jshint -W024 */
angular.module('activePortal.services')

    .factory('ticketHttpClient', function ($resource) {

        return $resource(null, null, {
            findAll: {
                url: "rest/ticket/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/ticket/create",
                method: 'POST'
            },
            activate: {
                url: "rest/ticket/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: "rest/ticket/:sid/deactivate",
                method: 'GET'
            },
            get: {
                url: "rest/ticket/:sid",
                method: 'GET'
            },
            update: {
                url: "rest/ticket/:sid",
                method: 'PUT'
            },
            delete: {
                url: "rest/ticket/:sid",
                method: 'DELETE'
            },
            findCustomerByCode: {
                url: "rest/ticket/:code/customer",
                method: 'GET'
            },
            findByCode: {
                url: "rest/ticket/code/:code",
                method: 'GET'
            }
        });
    })
;