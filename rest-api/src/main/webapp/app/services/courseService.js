define([
    'services/module'
], function (module) {

    module.factory('courseFactory', function ($resource) {

        return $resource(null, null, {

            findAll: {
                url: "rest/course/list",
                method: 'GET',
                isArray: true
            },
            findInProgress: {
                url: "rest/course/inProgress/list",
                method: 'GET',
                isArray: true
            },
            findRegistration: {
                url: "rest/course/registration/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/course/create",
                method: 'POST'
            },
            get: {
                url: "test/course/:sid",
                method: 'GET'
            },
            publish: {
                url: "rest/course/:sid/publish",
                method: 'PUT'
            },
            deactivate: {
                url: "rest/course/:sid/deactivate",
                method: 'PUT'
            },
            update: {
                url: "rest/course/:sid",
                method: 'PUT'
            },
            delete: {
                url: "rest/course/:sid",
                method: 'DELETE'
            },
            setState: {
                url: "rest/course/:sid/state",
                method: "PUT"
            },
            setInstructor: {
                url: "rest/course/:sid/instructor",
                method: "PUT"
            },
            setRoom: {
                url: "rest/course/:sid/room",
                method: "PUT"
            }
        })
    })

});