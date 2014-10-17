define([
    'services/module'
], function (module) {

    module.factory('instructorFactory', function ($resource) {

        return $resource(null, null, {

            findAll: {
                url: "rest/instructor/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/instructor/create",
                method: 'POST'
            },
            get: {
                url: "rest/instructor/:sid",
                method: 'GET'
            },
            activate: {
                url: "rest/instructor/:sid/activate",
                method: 'PUT'
            },
            deactivate: {
                url: "rest/instructor/:sid/deactivate",
                method: 'PUT'
            },
            update: {
                url: "rest/instructor/:sid",
                method: 'PUT'
            },
            delete: {
                url: "rest/instructor/:sid",
                method: 'DELETE'
            },
            courses: {
                url: "rest/instructor/:sid/courses",
                method: "GET"
            }
        })
    });

    module.service("instructorService", function () {
        this.copyProperties = function (instructor) {
            if (instructor == null) {
                return;
            }
            return {
                sid: instructor.sid,
                objectState: instructor.objectState,
                firstName: instructor.firstName,
                lastName: instructor.lastName,
                nick: instructor.nick
            }
        }
    })
});