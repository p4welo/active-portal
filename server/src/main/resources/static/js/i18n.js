angular.module('PortalApp')
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
            d: "Duża"

        });
        $translateProvider.preferredLanguage('pl');
    });