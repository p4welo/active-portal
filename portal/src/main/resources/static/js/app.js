var SERVER_URL = "http://localhost:8086/api";
//var SERVER_URL = "http://vs8123.gensys.pl/server/api";
//var SERVER_URL = "http://5.133.13.149/server/api";

angular.module('PortalApp', [
    'ui.router',
    'PortalApp.loadingBar',
    'PortalApp.filters',
    'PortalApp.services',
    'PortalApp.directives',
    'PortalApp.controllers'
])

    .run(['$rootScope', '$state', '$stateParams',
        function ($rootScope, $state, $stateParams) {
            $rootScope.$state = $state;
            $rootScope.$stateParams = $stateParams;
        }])
    .config(function ($stateProvider, $locationProvider, $urlRouterProvider, $httpProvider) {

        $urlRouterProvider.otherwise("/news");
        $stateProvider
            .state('news', {
                url: "/news",
                templateUrl: "pages/company/news.html",
                controller: "NewsCtrl"
            })
            .state('classes', {
                url: "/classes",
                templateUrl: "pages/company/classes.html",
                controller: "ClassesCtrl"
            })
            .state('403', {
                url: "/403",
                templateUrl: "pages/error/403.html"
            });

        $httpProvider.interceptors.push(function ($q, $rootScope, $location, notificationService) {
                return {
                    'responseError': function (rejection) {

                        var status = rejection.status;
                        if (status == 401) {
                            window.location.replace("/login");
                        }
                        else if (status == 403) {
                            $location.path("/403");
                        }
                        else if (status == 500) {
                            notificationService.error('Internal server error');
                        }
                        return $q.reject(rejection);
                    }
                };
            }
        );

//        $httpProvider.interceptors.push(function ($q, $rootScope) {
//                return {
//                    'request': function (config) {
//                        if (angular.isDefined($rootScope.token)) {
//                            var authToken = $rootScope.token;
//                            config.headers['Authorization'] = authToken;
//                        }
//                        return config || $q.when(config);
//                    }
//                };
//            }
//        );
    })
    .run(function ($rootScope, $location, $cookieStore, userFactory, menuFactory) {

        $rootScope.hasRole = function (role) {
            if ($rootScope.user === undefined) {
                return false;
            }
            return $rootScope.user.type == role;
        };

        $rootScope.injectAuthentication = function (firstName, lastName, type) {
            $rootScope.user = {
                "firstName" : firstName,
                "lastName" : lastName,
                "type" : type
            };
        };

        $rootScope.isLoggedIn = function () {
            return $rootScope.user !== undefined;
//            return $rootScope.token !== undefined;
        }

//        var token = $cookieStore.get('authToken');
//        if (token !== undefined) {
//            $rootScope.user = userFactory.get(function () {
//                $rootScope.menu = menuFactory.get(function () {
//                    $rootScope.token = token;
//                });
//            });
//        }
    });

angular.module('PortalApp.services', ['ngResource']);
angular.module('PortalApp.controllers', ['ngSanitize', 'ngCookies']);