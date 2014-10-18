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
                url: "rest/course/:sid",
                method: 'GET'
            },
            publish: {
                url: "rest/course/:sid/publish",
                method: 'GET'
            },
            deactivate: {
                url: "rest/course/:sid/deactivate",
                method: 'GET'
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
    });

    module.service("courseService", function () {
        this.copyProperties = function (course) {
            if (course == null) {
                return;
            }
            return {
                sid: course.sid,
                objectState: course.objectState,
                style: course.style,
                instructor: course.instructor,
                day: course.day,
                startTime: course.startTime,
                endTime: course.endTime,
                canJoin: course.canJoin,
                canRegister: course.canRegister,
                inProgress: course.inProgress,
                level: course.level,
                room: course.room,
                comment: course.comment
            }
        }
    })
});