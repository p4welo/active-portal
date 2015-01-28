define([
    'uiRouter',
    'ngAnimate',
    'ngTouch',
    'loadingBar',

    'core/module',

    'services/module',
    'services/authorityService',

    'dashboard/dashboard',
    'customers/index',
    'news/index',
    'schedule/index',
    'system/index'
], function () {

    return angular.module('activePortal', [
        'ngAnimate',
        'ngTouch',
        'ui.router',
        'angular-loading-bar',

        'activePortal.dashboard',
        'activePortal.system',
        'activePortal.schedule',
        'activePortal.news',
        'activePortal.customers',
        'activePortal.services',

        'activePortal.core',
        'activePortal.services'
    ], function ($urlRouterProvider) {

        $urlRouterProvider.otherwise("/dashboard");
    })
        .config(function ($translateProvider) {
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

                ADULT_1_ENTRANCE: "Pojedyncze wejście (1h)",
                ADULT_4_ENTRANCES_MONTH: "4 wejścia (1h) w miesiącu",
                ADULT_8_ENTRANCES_MONTH: "8 wejść (1h) w miesiącu",
                ADULT_OPEN_MONTH: "Karnet OPEN",

                CHILD_1_ENTRANCE: "Pojedyncze wejście (45 min)",
                CHILD_4_ENTRANCES_MONTH: "4 wejścia (45 min) w miesiącu",
                CHILD_8_ENTRANCES_MONTH: "8 wejść (45 min) w miesiącu",
                CHILD_OPEN_MONTH: "Karnet OPEN",
                CHILD_FORMATION_MONTH: "8 wejść (1h) - Formacja taneczna"
            });

            $translateProvider.preferredLanguage('pl');
        })

        .config(function ($stateProvider, $locationProvider, $urlRouterProvider, $httpProvider) {

            $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
                    return {
                        'responseError': function (rejection) {

                            var status = rejection.status;
                            if (status == 401) {
                                window.location.replace("/login.html");
                            }
                            else if (status == 403) {
                                $location.path("/403");
                            }
                            else if (status == 500) {
//                                notificationService.error('Internal server error');
                            }
                            return $q.reject(rejection);
                        }
                    };
                }
            );
        })

        .controller("menuController", function ($scope, authorityHttpClient) {
            $scope.currentAuth = [];
            authorityHttpClient.getCurrentAuthorities().$promise.then(
                function (result) {
                    $scope.currentAuth = result;
                }
            );

            function hasAuth(key) {

                if ($scope.currentAuth != null) {
                    return $scope.currentAuth.indexOf(key) > -1;
                }
            }
//            SYSTEM
            $scope.systemAuth = function () {
                return $scope.usersAuth() || $scope.authoritiesAuth();
            }
            $scope.usersAuth = function () {
                return hasAuth("AUTH_SYSTEM_USERS");
            }
            $scope.authoritiesAuth = function () {
                return hasAuth("AUTH_SYSTEM_AUTHORITIES");
            }
//            GRAFIK
            $scope.scheduleAuth = function () {
                return $scope.roomsAuth() || $scope.instructorsAuth() || $scope.categoriesAuth() || $scope.stylesAuth() || $scope.coursesAuth()
            }
            $scope.roomsAuth = function () {
                return hasAuth("AUTH_SCHEDULE_ROOMS");
            }
            $scope.instructorsAuth = function () {
                return hasAuth("AUTH_SCHEDULE_INSTRUCTORS");
            }
            $scope.categoriesAuth = function () {
                return hasAuth("AUTH_SCHEDULE_CATEGORIES");
            }
            $scope.stylesAuth = function () {
                return hasAuth("AUTH_SCHEDULE_STYLES");
            }
            $scope.coursesAuth = function () {
                return hasAuth("AUTH_SCHEDULE_SCHEDULE");
            }
//            SEKRETARIAT
            $scope.officeAuth = function () {
                return $scope.customerBaseAuth() || $scope.attendanceAuth();
            }
            $scope.customerBaseAuth = function () {
                return hasAuth("AUTH_CUSTOMERS_CUSTOMER_BASE");
            }
            $scope.attendanceAuth = function () {
                return hasAuth("AUTH_CUSTOMERS_CUSTOMER_PRESENCE");
            }
        })

//        .run(function ($rootScope) {
//            $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
//                if (!fromState.abstract) {
//                    if ($("#navbar-collapse-1").hasClass("in")) {
//                        $("#navbar-collapse-1").removeClass("in");
//                        $("#navbar-collapse-1").style("height", "1px");
//                        $("#nav-toggle-button").addClass("collapsed");
//                    }
//                }
//            });
//        })
});