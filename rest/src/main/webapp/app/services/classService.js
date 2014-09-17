define([
    'services/module'
], function (module) {

    module.factory('classFactory', function ($resource) {
        var CLASS_LIST_KEY = getRestUrl("/danceClass/list");
        var CREATE_CLASS_KEY = getRestUrl("/danceClass");
        var GET_CLASS_KEY = getRestUrl("/danceClass/:sid");

        return $resource(null, null, {
            find: {
                url: CLASS_LIST_KEY,
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