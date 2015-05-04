/* jshint -W024 */
angular.module('activePortal.services')

    .factory('styleHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.URL;

        return $resource(null, null, {

            findAll: {
                url: url + "rest/style/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "rest/style/create",
                method: 'POST'
            },
            get: {
                url: url + "rest/style/:sid",
                method: 'GET'
            },
            activate: {
                url: url + "rest/style/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "rest/style/:sid/deactivate",
                method: 'GET'
            },
            findCourses: {
                url: url + "rest/style/:sid/courses",
                method: 'GET',
                isArray: true
            },
            findActiveCourses: {
                url: url + "rest/style/:sid/courses/active",
                method: 'GET',
                isArray: true
            },
            update: {
                url: url + "rest/style/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "rest/style/:sid",
                method: 'DELETE'
            },
            setCategory: {
                url: url + "rest/style/:sid/category",
                method: "PUT"
            }
        });
    })
;