define([
    'services/module'
], function (module) {

    module.factory('categoryHttpClient', ['$resource', function ($resource) {

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
        });
    }]);
});