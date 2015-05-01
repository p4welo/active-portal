/* jshint -W024 */
angular.module('activePortal.services')

    .factory('courseHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.URL;

        return $resource(null, null, {

            findAll: {
                url: url + "rest/course/list",
                method: 'GET',
                isArray: true
            },
            findInProgress: {
                url: url + "rest/course/inProgress/list",
                method: 'GET',
                isArray: true
            },
            findRegistration: {
                url: url + "rest/course/registration/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "rest/course/create",
                method: 'POST'
            },
            get: {
                url: url + "rest/course/:sid",
                method: 'GET'
            },
            publish: {
                url: url + "rest/course/:sid/publish",
                method: 'GET'
            },
            deactivate: {
                url: url + "rest/course/:sid/deactivate",
                method: 'GET'
            },
            update: {
                url: url + "rest/course/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "rest/course/:sid",
                method: 'DELETE'
            },
            setState: {
                url: url + "rest/course/:sid/state",
                method: "PUT"
            },
            setInstructor: {
                url: url + "rest/course/:sid/instructor",
                method: "PUT"
            },
            setRoom: {
                url: url + "rest/course/:sid/room",
                method: "PUT"
            },
            findLessons: {
                url: url + "rest/course/:sid/lessons",
                method: 'GET',
                isArray: true
            },
            findCustomers: {
                url: url + "rest/course/:sid/customers",
                method: 'GET',
                isArray: true
            },
            setStyle: {
                url: url + "rest/course/:sid/style",
                method: "PUT"
            }
        });
    });