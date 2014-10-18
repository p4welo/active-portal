define([
    'services/module'
], function (module) {

    module.factory('categoryFactory', function ($resource) {

        return $resource(null, null, {

            findAll: {
                url: "rest/category/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/category/create",
                method: 'POST'
            },
            get: {
                url: "rest/category/:sid",
                method: 'GET'
            },
            activate: {
                url: "rest/category/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: "rest/category/:sid/deactivate",
                method: 'GET'
            },
            update: {
                url: "rest/category/:sid",
                method: 'PUT'
            },
            delete: {
                url: "rest/category/:sid",
                method: 'DELETE'
            }
        })
    });

    module.service("categoryService", function () {
        this.copyProperties = function (category) {
            if (category == null) {
                return;
            }
            return {
                sid: category.sid,
                objectState: category.objectState,
                name: category.name,
                code: category.code
            }
        }
    })
});