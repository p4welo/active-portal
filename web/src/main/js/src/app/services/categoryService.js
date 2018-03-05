/* jshint -W024 */
angular.module('activePortal.services')

    .factory('categoryHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.REST_URL;

        return $resource(null, null, {

            findAll: {
                url: url + "category/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "category/create",
                method: 'POST'
            },
            get: {
                url: url + "category/:sid",
                method: 'GET'
            },
            activate: {
                url: url + "category/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "category/:sid/deactivate",
                method: 'GET'
            },
            update: {
                url: url + "category/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "category/:sid",
                method: 'DELETE'
            }
        });
    })
;