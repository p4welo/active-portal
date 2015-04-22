/* jshint -W024 */
angular.module('activePortal.services')

    .factory('roomHttpClient', function ($resource) {

        return $resource(null, null, {

            findAll: {
                url: "rest/room/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/room/create",
                method: 'POST'
            },
            activate: {
                url: "rest/room/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: "rest/room/:sid/deactivate",
                method: 'GET'
            },
            get: {
                url: "rest/room/:sid",
                method: 'GET'
            },
            update: {
                url: "rest/room/:sid",
                method: 'PUT'
            },
            delete: {
                url: "rest/room/:sid",
                method: 'DELETE'
            }
        });
    })
;