/* jshint -W024 */
angular.module('activePortal.services')

    .factory('coreHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.URL;

        return $resource(null, null, {
            findAll: {
                url: url + "rest/:type/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "rest/:type/create",
                method: 'POST'
            },
            get: {
                url: url + "rest/:type/:sid",
                method: 'GET'
            },
            activate: {
                url: url + "rest/:type/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "rest/:type/:sid/deactivate",
                method: 'GET'
            },
            update: {
                url: url + "rest/:type/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "rest/:type/:sid",
                method: 'DELETE'
            }
        });
    })
;