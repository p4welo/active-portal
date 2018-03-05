/* jshint -W024 */
angular.module('activePortal.services')

    .factory('reservationHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.REST_URL;

        return $resource(null, null, {

            findByDateRange: {
                url: url + "reservation/findByDateRange",
                method: 'POST',
                isArray: true
            }
        });
    })
;