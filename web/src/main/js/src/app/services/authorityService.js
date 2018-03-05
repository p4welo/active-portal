/* jshint -W024 */
angular.module('activePortal.services')

    .factory('authorityHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.REST_URL;

        return $resource(null, null, {
            findRoles: {
                url: url + "role/list",
                method: 'GET',
                isArray: true
            },
            findAll: {
                url: url + "authority/list",
                method: 'GET',
                isArray: true
            },
            findByRole: {
                url: url + "role/:sid/authority/list",
                method: 'GET',
                isArray: true
            },
            check: {
                url: url + "role/:sid/authority/check",
                method: 'PUT'
            },
            uncheck: {
                url: url + "role/:sid/authority/uncheck",
                method: 'PUT'
            },
            getCurrentAuthorities: {
                url: url + "authority/current/list",
                method: 'GET',
                isArray: true
            }
        });
    })
;