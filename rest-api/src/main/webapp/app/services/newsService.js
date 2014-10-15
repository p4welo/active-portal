define([
    'services/module'
], function (module) {

    module.factory('newsFactory', function ($resource) {

        return $resource(null, null, {

            findAll: {
                url: "rest/news/list",
                method: 'GET',
                isArray: true
            },
            findPublic: {
                url: "rest/news/public/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/news/create",
                method: 'POST'
            },
            get: {
                url: "rest/news/:sid",
                method: 'GET'
            },
            update: {
                url: "rest/news/:sid",
                method: 'PUT'
            },
            publish: {
                url: "rest/news/:sid/publish",
                method: 'PUT'
            },
            deactivate: {
                url: "rest/news/:sid/deactivate",
                method: 'PUT'
            },
            delete: {
                url: "rest/news/:sid",
                method: 'DELETE'
            }
        })
    })
});