angular.module('activePortal')
    .run(function ($rootScope, authorityHttpClient) {

        $rootScope.currentAuth = [];
        authorityHttpClient.getCurrentAuthorities().$promise.then(
            function (result) {
                $rootScope.currentAuth = result;
            }
        );

        function hasAuth(key) {
            if (angular.isObject($rootScope.currentAuth)) {
                return $rootScope.currentAuth.indexOf(key) > -1;
            }
        }

//              SYSTEM
        $rootScope.systemAuth = function () {
            return $rootScope.usersAuth() || $rootScope.authoritiesAuth();
        };
        $rootScope.usersAuth = function () {
            return hasAuth("AUTH_SYSTEM_USERS");
        };
        $rootScope.authoritiesAuth = function () {
            return hasAuth("AUTH_SYSTEM_AUTHORITIES");
        };
//              GRAFIK
        $rootScope.scheduleAuth = function () {
            return $rootScope.roomsAuth() || $rootScope.instructorsAuth() || $rootScope.categoriesAuth() || $rootScope.stylesAuth() || $rootScope.coursesAuth();
        };
        $rootScope.roomsAuth = function () {
            return hasAuth("AUTH_SCHEDULE_ROOMS");
        };
        $rootScope.instructorsAuth = function () {
            return hasAuth("AUTH_SCHEDULE_INSTRUCTORS");
        };
        $rootScope.categoriesAuth = function () {
            return hasAuth("AUTH_SCHEDULE_CATEGORIES");
        };
        $rootScope.stylesAuth = function () {
            return hasAuth("AUTH_SCHEDULE_STYLES");
        };
        $rootScope.coursesAuth = function () {
            return hasAuth("AUTH_SCHEDULE_SCHEDULE");
        };
//              SEKRETARIAT
        $rootScope.officeAuth = function () {
            return $rootScope.customerBaseAuth() || $rootScope.attendanceAuth();
        };
        $rootScope.customerBaseAuth = function () {
            return hasAuth("AUTH_CUSTOMERS_CUSTOMER_BASE");
        };
        $rootScope.attendanceAuth = function () {
            return hasAuth("AUTH_CUSTOMERS_CUSTOMER_PRESENCE");
        };
    });