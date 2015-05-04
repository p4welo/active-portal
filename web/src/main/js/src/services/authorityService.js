/* jshint -W024 */
angular.module('activePortal.services')

    .factory('authorityHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.URL;

        return $resource(null, null, {
            findRoles: {
                url: url + "rest/role/list",
                method: 'GET',
                isArray: true
            },
            findAll: {
                url: url + "rest/authority/list",
                method: 'GET',
                isArray: true
            },
            findByRole: {
                url: url + "rest/role/:sid/authority/list",
                method: 'GET',
                isArray: true
            },
            check: {
                url: url + "rest/role/:sid/authority/check",
                method: 'PUT'
            },
            uncheck: {
                url: url + "rest/role/:sid/authority/uncheck",
                method: 'PUT'
            },
            getCurrentAuthorities: {
                url: url + "rest/authority/current/list",
                method: 'GET',
                isArray: true
            }
        });
    })
;