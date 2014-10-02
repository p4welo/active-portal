define([
    'services/module'
], function (module) {

    module.factory('roomFactory', function ($resource) {
        var ROOM_LIST_KEY = "rest/room/list";
        var CREATE_ROOM_KEY = "rest/room";
        var GET_ROOM_KEY = "rest/room/:sid";

        return $resource(null, null, {
            find: {
                url: ROOM_LIST_KEY,
                method: 'GET',
                isArray: true
            },
            create: {
                url: CREATE_ROOM_KEY,
                method: 'POST'
            },
            get: {
                url: GET_ROOM_KEY,
                method: 'GET'
            },
            update: {
                url: GET_ROOM_KEY,
                method: 'PUT'
            },
            delete: {
                url: GET_ROOM_KEY,
                method: 'DELETE'
            }
        })
    })

});