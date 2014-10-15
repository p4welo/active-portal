define([
    'services/module'
], function (module) {

    module.factory('courseFactory', function ($resource) {
        var CLASS_LIST_KEY = "rest/danceClass/all/list";
        var CLASS_IN_PROGRESS_LIST_KEY = "rest/danceClass/inProgress/list";
        var CLASS_REGISTRATION_LIST_KEY = "rest/danceClass/registration/list";
        var CREATE_CLASS_KEY = "rest/danceClass";
        var GET_CLASS_KEY = "rest/danceClass/:sid";

        return $resource(null, null, {
            findAll: {
                url: CLASS_LIST_KEY,
                method: 'GET',
                isArray: true
            },
            findInProgress: {
                url: CLASS_IN_PROGRESS_LIST_KEY,
                method: 'GET',
                isArray: true
            },
            findRegistration: {
                url: CLASS_REGISTRATION_LIST_KEY,
                method: 'GET',
                isArray: true
            },
            create: {
                url: CREATE_CLASS_KEY,
                method: 'POST'
            },
            get: {
                url: GET_CLASS_KEY,
                method: 'GET'
            },
            update: {
                url: GET_CLASS_KEY,
                method: 'PUT'
            },
            delete: {
                url: GET_CLASS_KEY,
                method: 'DELETE'
            }
        })
    })

});