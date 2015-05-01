/* jshint -W024 */
angular.module('activePortal.services')

    .factory('userHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.URL;

        return $resource(null, null, {

            findAll: {
                url: url + "rest/user/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "rest/user/create",
                method: 'POST'
            },
            get: {
                url: url + "rest/user/:sid",
                method: 'GET'
            },
            activate: {
                url: url + "rest/user/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "rest/user/:sid/deactivate",
                method: 'GET'
            },
            update: {
                url: url + "rest/user/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "rest/user/:sid",
                method: 'DELETE'
            }
        });
    })
;