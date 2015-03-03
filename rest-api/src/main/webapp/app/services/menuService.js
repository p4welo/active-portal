define([
    'services/module'
], function (module) {

    module.factory('menuHttpClient', ['$resource', function ($resource) {
        var GET_MENU_KEY = "rest/menu";

        return $resource(null, null, {
            get: {
                url: GET_MENU_KEY,
                method: 'GET'
            }
        });
    }]);
});