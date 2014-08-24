angular.module('PortalApp.services')

    .factory('roomFactory', function ($resource) {
        var ROOM_LIST_KEY = getRestUrl("/room/list");
        var CREATE_ROOM_KEY = getRestUrl("/room");
        var GET_ROOM_KEY = getRestUrl("/room/:sid");

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

    .service('roomService', function () {
        this.copyProperties = function (source, destination) {
            destination.sid = source.sid;
            destination.objectState = source.objectState;
            destination.name = source.name;
        }
    })
;