/* jshint -W100 */
angular.module('activePortal', [
    'templates-app',
    'activePortal.common',
    'activePortal.dashboard',
    'activePortal.schedule',
    'activePortal.customers',
    'activePortal.tickets',
    'activePortal.services',

    'ngAnimate',
    'ngTouch',
    'pascalprecht.translate',
    'ui.router',
    'angular-loading-bar'
])
    .factory("httpAuthInterceptor", function ($q, $window) {
        return {
            "response": function (response) {
                var responseHeaders;
                responseHeaders = response.headers();
                if (responseHeaders["content-type"] &&
                    responseHeaders["content-type"].indexOf("text/html") !== -1 &&
                    response.data &&
                    response.data.indexOf('<meta name="unauthorized" content="true">') !== -1) {
                    $window.location.reload();
                    return $q.reject(response);
                }
                return response;
            }
        };
    })

    .factory("httpErrorInterceptor", function ($q, $location, notificationService) {
        return {
            'responseError': function (rejection) {
                var status = rejection.status;
                if (status == 401) {
                    window.location.reload();
                }
                else if (status == 403) {
                    $location.path("/403");
                }
                else {
                    notificationService.error('Błąd ' + status);
                }
                return $q.reject(rejection);
            }
        };
    })

    .config(function ($stateProvider, $urlRouterProvider, $translateProvider, $httpProvider) {

        $urlRouterProvider.otherwise('/dashboard');

        $httpProvider.interceptors.push("httpAuthInterceptor");
        $httpProvider.interceptors.push("httpErrorInterceptor");

        //if (!$httpProvider.defaults.headers.get) {
        //    $httpProvider.defaults.headers.get = {};
        //}
        ////disable IE ajax request caching
        //$httpProvider.defaults.headers.get['If-Modified-Since'] = 'Mon, 26 Jul 1997 05:00:00 GMT';
        //$httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
        //$httpProvider.defaults.headers.get.Pragma = 'no-cache';
    })
;