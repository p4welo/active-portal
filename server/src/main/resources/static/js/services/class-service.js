angular.module('PortalApp.services')

    .factory('classFactory', function ($resource) {
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

    .service('classService', function () {
        this.copyProperties = function (source, destination) {
            destination.sid = source.sid;
            destination.objectState = source.objectState;
            destination.style = source.style;
            destination.instructor = source.instructor;
            destination.day = source.day;
            destination.startTime = source.startTime;
            destination.endTime = source.endTime;
            destination.canJoin = source.canJoin;
            destination.canRegister = source.canRegister;
            destination.inProgress = source.inProgress;
            destination.level = source.level;
            destination.room = source.room;
        }
    })
;