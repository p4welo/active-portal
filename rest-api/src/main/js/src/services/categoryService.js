/* jshint -W024 */
angular.module('activePortal.services')

    .factory('categoryHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.URL;

        return $resource(null, null, {

            findAll: {
                url: url + "rest/category/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "rest/category/create",
                method: 'POST'
            },
            get: {
                url: url + "rest/category/:sid",
                method: 'GET'
            },
            activate: {
                url: url + "rest/category/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "rest/category/:sid/deactivate",
                method: 'GET'
            },
            update: {
                url: url + "rest/category/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "rest/category/:sid",
                method: 'DELETE'
            }
        });
    })
;