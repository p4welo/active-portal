/* jshint -W024 */
angular.module('activePortal.services')

    .factory('instructorHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.REST_URL;

        return $resource(null, null, {

            findAll: {
                url: url + "instructor/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "instructor/create",
                method: 'POST'
            },
            get: {
                url: url + "instructor/:sid",
                method: 'GET'
            },
            activate: {
                url: url + "instructor/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: url + "instructor/:sid/deactivate",
                method: 'GET'
            },
            update: {
                url: url + "instructor/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "instructor/:sid",
                method: 'DELETE'
            },
            courses: {
                url: url + "instructor/:sid/courses",
                method: "GET",
                isArray: true
            }
        });
    })
;