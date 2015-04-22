/* jshint -W024 */
angular.module('activePortal.services')

    .factory('ticketTypeHttpClient', function ($resource) {

        return $resource(null, null, {
            findAll: {
                url: "rest/ticket/type/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/ticket/type/create",
                method: 'POST'
            },
            activate: {
                url: "rest/ticket/type/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: "rest/ticket/type/:sid/deactivate",
                method: 'GET'
            },
            get: {
                url: "rest/ticket/type/:sid",
                method: 'GET'
            },
            update: {
                url: "rest/ticket/type/:sid",
                method: 'PUT'
            },
            delete: {
                url: "rest/ticket/type/:sid",
                method: 'DELETE'
            }
        });
    })
;