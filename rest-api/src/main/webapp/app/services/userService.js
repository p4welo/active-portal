define([
    'services/module'
], function (module) {

    module.factory('userHttpClient', function ($resource) {

        return $resource(null, null, {

            findAll: {
                url: "rest/user/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/user/create",
                method: 'POST'
            },
            get: {
                url: "rest/user/:sid",
                method: 'GET'
            },
            activate: {
                url: "rest/user/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: "rest/user/:sid/deactivate",
                method: 'GET'
            },
            update: {
                url: "rest/user/:sid",
                method: 'PUT'
            },
            delete: {
                url: "rest/user/:sid",
                method: 'DELETE'
            }
        })
    });

    module.service("userService", function () {
        this.copyProperties = function (user) {
            if (user == null) {
                return;
            }
            return {
                sid: user.sid,
                objectState: user.objectState,
                firstName: user.firstName,
                lastName: user.lastName,
                login: user.login,
                email: user.email,
                role: user.role
            }
        }
    })
});