angular.module('PortalApp.services')

    .factory('menuFactory', function ($resource) {
        var GET_MENU_KEY = getRestUrl("/menu");

        return $resource(null, null, {
            get: {
                url: GET_MENU_KEY,
                method: 'GET'
            }
        })
    })