/* jshint -W024 */
angular.module('activePortal.services')

    .factory('courseHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.REST_URL;

        return $resource(null, null, {

            findAll: {
                url: url + "course/list",
                method: 'GET',
                isArray: true
            },
            findInProgress: {
                url: url + "course/inProgress/list",
                method: 'GET',
                isArray: true
            },
            findRegistration: {
                url: url + "course/registration/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "course/create",
                method: 'POST'
            },
            get: {
                url: url + "course/:sid",
                method: 'GET'
            },
            publish: {
                url: url + "course/:sid/publish",
                method: 'GET'
            },
            deactivate: {
                url: url + "course/:sid/deactivate",
                method: 'GET'
            },
            update: {
                url: url + "course/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "course/:sid",
                method: 'DELETE'
            },
            setState: {
                url: url + "course/:sid/state",
                method: "PUT"
            },
            setInstructor: {
                url: url + "course/:sid/instructor",
                method: "PUT"
            },
            reassignInstructors: {
                url: url + "course/:sid/instructors/reassign",
                method: "PUT"
            },
            setRoom: {
                url: url + "course/:sid/room",
                method: "PUT"
            },
            findLessons: {
                url: url + "course/:sid/lessons",
                method: 'GET',
                isArray: true
            },
            findCustomers: {
                url: url + "course/:sid/customers",
                method: 'GET',
                isArray: true
            },
            setStyle: {
                url: url + "course/:sid/style",
                method: "PUT"
            }
        });
    });