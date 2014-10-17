define([
    'uiRouter',
    'ngAnimate',
    'ngTouch',
    'loadingBar',

    'services/module',

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

        'activePortal.system',
        'activePortal.schedule',
        'activePortal.news',
        'activePortal.customers',
        'activePortal.services',

        'activePortal.services'
    ], function ($urlRouterProvider) {

        $urlRouterProvider.otherwise("/users");
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
                FEMALE: "Kobieta"
            });
            $translateProvider.preferredLanguage('pl');
        });
});