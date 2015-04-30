/* jshint -W024 */
angular.module('activePortal.services')

    .factory('menuHttpClient', function ($resource) {
        var GET_MENU_KEY = "rest/menu";

        return $resource(null, null, {
            get: {
                url: GET_MENU_KEY,
                method: 'GET'
            }
        });
    })
;