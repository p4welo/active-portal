define([
    'services/module'
], function (module) {

    module.factory('styleFactory', function ($resource) {
        var STYLE_LIST_KEY = "rest/style/list";
        var CREATE_STYLE_KEY = "rest/style";
        var GET_STYLE_KEY = "test/style/:sid";

        return $resource(null, null, {

            findAll: {
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