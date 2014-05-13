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
                templateUrl: "pages/news.html",
                controller: "NewsCtrl"
            })
            .state('classes', {
                url: "/classes",
                templateUrl: "pages/classes.html",
                controller: "ClassesCtrl"
            });

        $httpProvider.interceptors.push(function ($q, $rootScope, $location, notificationService) {
                return {
                    'responseError': function (rejection) {

                        var status = rejection.status;
                        if (status == 401) {
                            $location.path("/login");
                        }
                        else if (status == 500){
                            notificationService.error('Internal server error');
                        }
                        return $q.reject(rejection);
                    }
                };
            }
        );

        $httpProvider.interceptors.push(function ($q, $rootScope) {
                return {
                    'request': function (config) {
                        // var isRestCall = config.url.contains('rest');
                        if (angular.isDefined($rootScope.token)) {
                            var authToken = $rootScope.token;
                            config.headers['Authorization'] = authToken;
                        }
                        return config || $q.when(config);
                    }
                };
            }
        );
    })
    .run(function($rootScope, $location, $cookieStore, userFactory, menuFactory) {

        $rootScope.hasRole = function(role) {
            if ($rootScope.user === undefined) {
                return false;
            }
            return $rootScope.user.type == role;
        };

        $rootScope.logout = function() {
            userFactory.logout(function() {
                delete $rootScope.user;
                delete $rootScope.token;
                $cookieStore.remove('authToken');
                $location.path("/login");
            });
        };

        $rootScope.isLoggedIn = function() {
            return $rootScope.token !== undefined;
        }

        var token = $cookieStore.get('authToken');
        if (token !== undefined) {
            $rootScope.user = userFactory.get(function () {
                $rootScope.menu = menuFactory.get(function () {
                    $rootScope.token = token;
                });
            });
        }
    });

angular.module('PortalApp.services', ['ngResource']);
angular.module('PortalApp.controllers', ['ngSanitize', 'ngCookies']);