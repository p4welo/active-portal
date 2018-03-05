/* jshint -W024 */
angular.module('activePortal.services')

    .factory('newsHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.REST_URL;

        return $resource(null, null, {

            findAll: {
                url: url + "news/list",
                method: 'GET',
                isArray: true
            },
            findPublic: {
                url: url + "news/public/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "news/create",
                method: 'POST'
            },
            get: {
                url: url + "news/:sid",
                method: 'GET'
            },
            update: {
                url: url + "news/:sid",
                method: 'PUT'
            },
            publish: {
                url: url + "news/:sid/publish",
                method: 'GET'
            },
            deactivate: {
                url: url + "news/:sid/deactivate",
                method: 'GET'
            },
            delete: {
                url: url + "news/:sid",
                method: 'DELETE'
            }
        });
    })
;