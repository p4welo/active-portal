/* jshint -W024 */
angular.module('activePortal.services')

    .factory('ticketTypeGroupHttpClient', function ($resource) {

        return $resource(null, null, {
            findAll: {
                url: "rest/ticket/group/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/ticket/group/create",
                method: 'POST'
            },
            activate: {
                url: "rest/ticket/group/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: "rest/ticket/group/:sid/deactivate",
                method: 'GET'
            },
            get: {
                url: "rest/ticket/group/:sid",
                method: 'GET'
            },
            update: {
                url: "rest/ticket/group/:sid",
                method: 'PUT'
            },
            delete: {
                url: "rest/ticket/group/:sid",
                method: 'DELETE'
            }
        });
    })
;