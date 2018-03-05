/* jshint -W024 */
angular.module('activePortal.services')

    .factory('styleHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.REST_URL;

        return $resource(null, null, {

            findAll: {
                url: url + "style/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "style/create",
                method: 'POST'
            },
            get: {
                url: url + "style/:sid",
                method: 'GET'
            },
            activate: {
                url: url + "style/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "style/:sid/deactivate",
                method: 'GET'
            },
            findCourses: {
                url: url + "style/:sid/courses",
                method: 'GET',
                isArray: true
            },
            findActiveCourses: {
                url: url + "style/:sid/courses/active",
                method: 'GET',
                isArray: true
            },
            update: {
                url: url + "style/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "style/:sid",
                method: 'DELETE'
            },
            setCategory: {
                url: url + "style/:sid/category",
                method: "PUT"
            }
        });
    })
;