define([
    'services/module'
], function (module) {

    module.factory('styleFactory', function ($resource) {
        var STYLE_LIST_KEY = getRestUrl("/style/list");
        var CREATE_STYLE_KEY = getRestUrl("/style");
        var GET_STYLE_KEY = getRestUrl("/style/:sid");

        return $resource(null, null, {
            find: {
                url: STYLE_LIST_KEY,
                method: 'GET',
                isArray: true
            },
            create: {
                url: CREATE_STYLE_KEY,
                method: 'POST'
            },
            get: {
                url: GET_STYLE_KEY,
                method: 'GET'
            },
            update: {
                url: GET_STYLE_KEY,
                method: 'PUT'
            },
            delete: {
                url: GET_STYLE_KEY,
                method: 'DELETE'
            }
        })
    })

});