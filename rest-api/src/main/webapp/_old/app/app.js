define([
    'angular',
    'uiRouter',
    'ngAnimate',
    'ngLocale',
    'ngTouch',
    'loadingBar',

    'services/authorityService',
    'services/notificationService',

    'dashboard/dashboard',
    'customers/index',
    'schedule/index',
    'system/index',
    'tickets/index',

    'core/modal/scanTicket'
], function (angular) {
    "use strict";

    return angular.module('activePortal', [
        'ngAnimate',
        'ngTouch',
        'ui.router',
        'angular-loading-bar',

        'activePortal.dashboard',
        'activePortal.system',
        'activePortal.schedule',
        'activePortal.customers',
        'activePortal.services',
        'activePortal.tickets',
        'activePortal.core',
        'activePortal.services'
    ])
        .config(['$stateProvider', '$locationProvider', '$translateProvider', '$urlRouterProvider', '$httpProvider',
            function ($stateProvider, $locationProvider, $translateProvider, $urlRouterProvider, $httpProvider) {

                $urlRouterProvider.otherwise("/dashboard");

                $translateProvider.translations('pl', {

                    PN: 'Poniedziałek',
                    WT: 'Wtorek',
                    SR: 'Środa',
                    CZ: 'Czwartek',
                    PT: 'Piątek',
                    SB: 'Sobota',
                    ND: 'Niedziela',

                    BEGINNER: "Początkujący",
                    INTERMEDIATE: "Średniozaawansowany",
                    ADVANCED: "Zaawansowany",
                    OPEN: "Otwarty",

                    m: "Mała",
                    d: "Duża",

                    TYPE_REGISTRATION: "Grupa na zapisy",
                    TYPE_OPEN: "Można dołączyć",
                    TYPE_CLOSED: "Nie można dołączyć",

                    ACTIVE: "Aktywny",
                    INACTIVE: "Nieaktywny",
                    DELETED: "Usunięty",

                    MALE: "Mężczyzna",
                    FEMALE: "Kobieta",

                    AUTH_SYSTEM_USERS: "SYSTEM: Użytkownicy",
                    AUTH_SYSTEM_AUTHORITIES: "SYSTEM: Uprawnienia",
                    AUTH_NEWS_NEWS_LIST: "AKTUALNOŚCI: Lista",
                    AUTH_NEWS_NEWSLETTER: "AKTUALNOŚCI: Newsletter",
                    AUTH_SCHEDULE_ROOMS: "GRAFIK: Pomieszczenia",
                    AUTH_SCHEDULE_INSTRUCTORS: "GRAFIK: Instruktorzy",
                    AUTH_SCHEDULE_CATEGORIES: "GRAFIK: Kategorie zajęć",
                    AUTH_SCHEDULE_STYLES: "GRAFIK: Style taneczne",
                    AUTH_SCHEDULE_SCHEDULE: "GRAFIK: Grafik zajęć",
                    AUTH_CUSTOMERS_CUSTOMER_BASE: "SEKRETARIAT: Baza klientów",
                    AUTH_CUSTOMERS_CUSTOMER_PRESENCE: "SEKRETARIAT: Obecności",

                    PASS_ADULT: "DOROŚLI",
                    PASS_CHILD: "DZIECI",

                    PERIOD_MONTH: "Miesięcy",
                    PERIOD_DAY: "Dni"
                });

                $translateProvider.preferredLanguage('pl');
                $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
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
                    }
                );
            }
        ])

        .run(['$rootScope', '$location', '$modal',
            function ($rootScope, $location, $modal) {
                $rootScope.isActive = function (obj) {
                    return obj.objectState == 'ACTIVE';
                };
                $rootScope.isEqual = function (obj1, obj2) {
                    return obj1 !== undefined && obj2.sid == obj1.sid;
                };
                $rootScope.isLocal = function () {
                    return $location.host() == 'localhost';
                };
                $rootScope.scan = function () {
                    $modal.open({
                        templateUrl: 'dist/app/core/modal/scanTicket.html',
                        controller: "scanTicketDialogController",
                        size: 'sm'
                    });
                };
                $rootScope.toggleSidebar = function () {
                    //App.sidebar('toggle-sidebar');
                };
            }
        ])

        .controller("menuController", ['$scope', 'authorityHttpClient',
            function ($scope, authorityHttpClient) {
                $scope.currentAuth = [];
                authorityHttpClient.getCurrentAuthorities().$promise.then(
                    function (result) {
                        $scope.currentAuth = result;
                    }
                );

                function hasAuth(key) {
                    if ($scope.currentAuth !== undefined) {
                        return $scope.currentAuth.indexOf(key) > -1;
                    }
                }

//              SYSTEM
                $scope.systemAuth = function () {
                    return $scope.usersAuth() || $scope.authoritiesAuth();
                };
                $scope.usersAuth = function () {
                    return hasAuth("AUTH_SYSTEM_USERS");
                };
                $scope.authoritiesAuth = function () {
                    return hasAuth("AUTH_SYSTEM_AUTHORITIES");
                };
//              GRAFIK
                $scope.scheduleAuth = function () {
                    return $scope.roomsAuth() || $scope.instructorsAuth() || $scope.categoriesAuth() || $scope.stylesAuth() || $scope.coursesAuth();
                };
                $scope.roomsAuth = function () {
                    return hasAuth("AUTH_SCHEDULE_ROOMS");
                };
                $scope.instructorsAuth = function () {
                    return hasAuth("AUTH_SCHEDULE_INSTRUCTORS");
                };
                $scope.categoriesAuth = function () {
                    return hasAuth("AUTH_SCHEDULE_CATEGORIES");
                };
                $scope.stylesAuth = function () {
                    return hasAuth("AUTH_SCHEDULE_STYLES");
                };
                $scope.coursesAuth = function () {
                    return hasAuth("AUTH_SCHEDULE_SCHEDULE");
                };
//              SEKRETARIAT
                $scope.officeAuth = function () {
                    return $scope.customerBaseAuth() || $scope.attendanceAuth();
                };
                $scope.customerBaseAuth = function () {
                    return hasAuth("AUTH_CUSTOMERS_CUSTOMER_BASE");
                };
                $scope.attendanceAuth = function () {
                    return hasAuth("AUTH_CUSTOMERS_CUSTOMER_PRESENCE");
                };
            }
        ]);
});