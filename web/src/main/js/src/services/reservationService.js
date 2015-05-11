/* jshint -W024 */
angular.module('activePortal.services')

    .factory('reservationHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.URL;

        return $resource(null, null, {

            findByDateRange: {
                url: url + "rest/reservation/findByDateRange",
                method: 'POST',
                isArray: true
            }
        });
    })
;