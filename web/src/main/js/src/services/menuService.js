/* jshint -W024 */
angular.module('activePortal.services')

    .factory('menuHttpClient', function ($resource, serverConf) {
        "use strict";

        var url = serverConf.URL;
        var GET_MENU_KEY = url + "rest/menu";

        return $resource(null, null, {
            get: {
                url: GET_MENU_KEY,
                method: 'GET'
            }
        });
    })
;