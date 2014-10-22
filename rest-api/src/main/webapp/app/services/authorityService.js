define([
    'services/module'
], function (module) {

    module.factory('authorityHttpClient', function ($resource) {

        return $resource(null, null, {
            findRoles: {
                url: "rest/role/list",
                method: 'GET',
                isArray: true
            },
            findAll: {
                url: "rest/authority/list",
                method: 'GET',
                isArray: true
            },
            findByRole: {
                url: "rest/role/:sid/authority/list",
                method: 'GET',
                isArray: true
            },
            check: {
                url: "rest/role/:sid/authority/check",
                method: 'PUT'
            },
            uncheck: {
                url: "rest/role/:sid/authority/uncheck",
                method: 'PUT'
            },
            getCurrentAuthorities: {
                url: "rest/authority/current/list",
                method: 'GET',
                isArray: true
            }
        })
    });

    module.factory('roleService', function () {
        var copyProperties = function (role) {
            if (role == null) {
                return;
            }
            return {
                sid: role.sid,
                objectState: role.objectState,
                name: role.name
            }
        }

        return {
            copyProperties: copyProperties
        }
    })

});