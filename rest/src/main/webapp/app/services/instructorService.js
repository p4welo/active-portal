define([
    'services/module'
], function (module) {

    module.factory('instructorFactory', function ($resource) {
        var INSTRUCTOR_LIST_KEY = "rest/instructor/list";
        var CREATE_INSTRUCTOR_KEY = "rest/instructor";
        var GET_INSTRUCTOR_KEY = "test/instructor/:sid";

        return $resource(null, null, {
            find: {
                url: INSTRUCTOR_LIST_KEY,
                method: 'GET',
                isArray: true
            },
            create: {
                url: CREATE_INSTRUCTOR_KEY,
                method: 'POST'
            },
            get: {
                url: GET_INSTRUCTOR_KEY,
                method: 'GET'
            },
            update: {
                url: GET_INSTRUCTOR_KEY,
                method: 'PUT'
            },
            delete: {
                url: GET_INSTRUCTOR_KEY,
                method: 'DELETE'
            }
        })
    })

});