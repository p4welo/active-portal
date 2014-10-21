define([
    'services/module'
], function (module) {

    module.factory('authorityHttpClient', function ($resource) {

        return $resource(null, null, {
            findRoles: {
                url: "rest/authority/role/list",
                method: 'GET',
                isArray: true
            },
            findAll: {
                url: "rest/authority/list",
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
                name: role.name
            }
        }

        return {
            copyProperties: copyProperties
        }
    })

});