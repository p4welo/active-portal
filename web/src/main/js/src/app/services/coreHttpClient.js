/* jshint -W024 */
angular.module('activePortal.services')

    .factory('coreHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.REST_URL;

        return $resource(null, null, {
            findAll: {
                url: url + ":type/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + ":type/create",
                method: 'POST'
            },
            get: {
                url: url + ":type/:sid",
                method: 'GET'
            },
            activate: {
                url: url + ":type/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + ":type/:sid/deactivate",
                method: 'GET'
            },
            update: {
                url: url + ":type/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + ":type/:sid",
                method: 'DELETE'
            }
        });
    })
;