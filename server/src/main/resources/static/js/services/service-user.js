angular.module('PortalApp.services')

    .factory('userFactory', function ($resource) {
        var AUTHENTICATE_KEY = getRestUrl("/auth?application_username=:login&application_password=:pass");
        var LOGOUT_KEY = getRestUrl("/logout");
        var CURRENT_USER_KEY = getRestUrl("/user/current");

        return $resource(null, null, {
            authenticate: {
                url: AUTHENTICATE_KEY,
                method: 'POST',
                headers: {'Accept': 'application/json'}
            },
            logout: {
                url: LOGOUT_KEY,
                method: 'GET'
            },
            get: {
                url: CURRENT_USER_KEY,
                method: 'GET'
            }
        })
    })

    .factory('focus', function ($rootScope, $timeout) {
        return function (name) {
            $timeout(function () {
                $rootScope.$broadcast('focusOn', name);
            });
        }
    })