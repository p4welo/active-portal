define([
    'services/module'
], function (module) {

    module.factory('instructorFactory', function ($resource) {
        var INSTRUCTOR_LIST_KEY = "rest/instructor/list";
        var CREATE_INSTRUCTOR_KEY = "rest/instructor";
        var GET_INSTRUCTOR_KEY = "test/instructor/:sid";

        return $resource(null, null, {
            findAll: {
                url: "rest/instructor/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/instructor/create",
                method: 'POST'
            },
            get: {
                url: "test/instructor/:sid",
                method: 'GET'
            },
            activate: {
                url: "rest/instructor/:sid/activate",
                method: 'PUT'
            },
            deactivate: {
                url: "rest/instructor/:sid/deactivate",
                method: 'PUT'
            },
            update: {
                url: "rest/instructor/:sid",
                method: 'PUT'
            },
            delete: {
                url: "rest/instructor/:sid",
                method: 'DELETE'
            },
            courses: {
                url: "rest/instructor/:sid/courses",
                method: "GET"
            }
        })
    })

});