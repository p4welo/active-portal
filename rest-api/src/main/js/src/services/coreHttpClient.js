/* jshint -W024 */
angular.module('activePortal.services')

    .factory('coreHttpClient', function ($resource) {
        "use strict";
        return $resource(null, null, {
            findAll: {
                url: "rest/:type/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/:type/create",
                method: 'POST'
            },
            get: {
                url: "rest/:type/:sid",
                method: 'GET'
            },
            activate: {
                url: "rest/:type/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: "rest/:type/:sid/deactivate",
                method: 'GET'
            },
            update: {
                url: "rest/:type/:sid",
                method: 'PUT'
            },
            delete: {
                url: "rest/:type/:sid",
                method: 'DELETE'
            }
        });
    })
;