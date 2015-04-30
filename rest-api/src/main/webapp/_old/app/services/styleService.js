define([
    'services/module'
], function (module) {
    "use strict";

    module.factory('styleHttpClient', ['$resource', function ($resource) {

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
                method: 'GET'
            },
            deactivate: {
                url: "rest/style/:sid/deactivate",
                method: 'GET'
            },
            findCourses: {
                url: "rest/style/:sid/courses",
                method: 'GET',
                isArray: true
            },
            findActiveCourses: {
                url: "rest/style/:sid/courses/active",
                method: 'GET',
                isArray: true
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
        });
    }]);
});