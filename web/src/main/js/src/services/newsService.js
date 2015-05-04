/* jshint -W024 */
angular.module('activePortal.services')

    .factory('newsHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.URL;

        return $resource(null, null, {

            findAll: {
                url: url + "rest/news/list",
                method: 'GET',
                isArray: true
            },
            findPublic: {
                url: url + "rest/news/public/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "rest/news/create",
                method: 'POST'
            },
            get: {
                url: url + "rest/news/:sid",
                method: 'GET'
            },
            update: {
                url: url + "rest/news/:sid",
                method: 'PUT'
            },
            publish: {
                url: url + "rest/news/:sid/publish",
                method: 'GET'
            },
            deactivate: {
                url: url + "rest/news/:sid/deactivate",
                method: 'GET'
            },
            delete: {
                url: url + "rest/news/:sid",
                method: 'DELETE'
            }
        });
    })
;