/* jshint -W024 */
angular.module('activePortal.services')

    .factory('instructorHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.URL;

        return $resource(null, null, {

            findAll: {
                url: url + "rest/instructor/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "rest/instructor/create",
                method: 'POST'
            },
            get: {
                url: url + "rest/instructor/:sid",
                method: 'GET'
            },
            activate: {
                url: url + "rest/instructor/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "rest/instructor/:sid/deactivate",
                method: 'GET'
            },
            update: {
                url: url + "rest/instructor/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "rest/instructor/:sid",
                method: 'DELETE'
            },
            courses: {
                url: url + "rest/instructor/:sid/courses",
                method: "GET",
                isArray: true
            }
        });
    })
;