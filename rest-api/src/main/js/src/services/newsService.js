/* jshint -W024 */
angular.module('activePortal.services')

    .factory('newsHttpClient', function ($resource) {

        return $resource(null, null, {

            findAll: {
                url: "rest/news/list",
                method: 'GET',
                isArray: true
            },
            findPublic: {
                url: "rest/news/public/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/news/create",
                method: 'POST'
            },
            get: {
                url: "rest/news/:sid",
                method: 'GET'
            },
            update: {
                url: "rest/news/:sid",
                method: 'PUT'
            },
            publish: {
                url: "rest/news/:sid/publish",
                method: 'GET'
            },
            deactivate: {
                url: "rest/news/:sid/deactivate",
                method: 'GET'
            },
            delete: {
                url: "rest/news/:sid",
                method: 'DELETE'
            }
        });
    })
;