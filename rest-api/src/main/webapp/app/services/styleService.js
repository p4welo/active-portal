define([
    'services/module'
], function (module) {

    module.factory('styleFactory', function ($resource) {

        return $resource(null, null, {

            findAll: {
                url: "rest/style/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/style/create",
                method: 'POST'
            },
            get: {
                url: "rest/style/:sid",
                method: 'GET'
            },
            activate: {
                url: "rest/style/:sid/activate",
                method: 'PUT'
            },
            deactivate: {
                url: "rest/style/:sid/deactivate",
                method: 'PUT'
            },
            update: {
                url: "rest/style/:sid",
                method: 'PUT'
            },
            delete: {
                url: "rest/style/:sid",
                method: 'DELETE'
            },
            setCategory: {
                url: "rest/style/:sid/category",
                method: "PUT"
            }
        })
    });

    module.service("styleService", function () {
        this.copyProperties = function (style) {
            if (style == null) {
                return;
            }
            return {
                sid: style.sid,
                objectState: style.objectState,
                name: style.name,
                category: style.category
            }
        }
    })
});