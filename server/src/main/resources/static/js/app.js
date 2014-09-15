var SERVER_URL = "http://localhost:8086/api";

angular.module('PortalApp', [
    'ui.router',
    'ngAnimate',
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

//        $urlRouterProvider.otherwise("/rooms");
        $urlRouterProvider.otherwise("/news");
        $stateProvider
            .state('news', {
                url: "/news",
                templateUrl: "pages/news/news.html",
                controller: "newsController"
            })
            .state('classes', {
                url: "/classes",
                templateUrl: "pages/classes/classes.html",
                controller: "classController"
            })
            .state('rooms', {
                url: "/rooms",
                templateUrl: "pages/rooms/rooms.html",
                controller: "roomController"
            })
            .state('instructors', {
                url: "/instructors",
                templateUrl: "pages/instructors/instructors.html",
                controller: "instructorController"
            })
            .state('categories', {
                url: "/categories",
                templateUrl: "pages/categories/categories.html",
                controller: "categoryController"
            })
            .state('styles', {
                url: "/styles",
                templateUrl: "pages/styles/styles.html",
                controller: "styleController"
            })
            .state('customerBase', {
                url: "/customerBase",
                templateUrl: "pages/customerBase/customerBase.html",
                controller: "customerBaseController"
            })
            .state('presence', {
                url: "/presence",
                templateUrl: "pages/presence/presence.html",
                controller: "presenceController"
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
        }
    });

angular.module('PortalApp.services', ['ngResource']);
angular.module('PortalApp.controllers', ['ngSanitize', 'ngCookies']);