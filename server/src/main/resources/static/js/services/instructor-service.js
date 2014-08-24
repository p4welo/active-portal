angular.module('PortalApp.services')

    .factory('instructorFactory', function ($resource) {
        var INSTRUCTOR_LIST_KEY = getRestUrl("/instructor/list");
        var CREATE_INSTRUCTOR_KEY = getRestUrl("/instructor");
        var GET_INSTRUCTOR_KEY = getRestUrl("/instructor/:sid");

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

    .service('instructorService', function () {
        this.copyProperties = function (source, destination) {
            destination.sid = source.sid;
            destination.objectState = source.objectState;
            destination.firstName = source.firstName;
            destination.lastName = source.lastName;
            destination.nick = source.nick;
        }
    })
;