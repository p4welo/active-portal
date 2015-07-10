angular.module('activePortal')

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

            REGISTRATION: "Grupa na zapisy",
            CAN_JOIN: "Można dołączyć",
            NO_PLACE: "Brak miejsc",

            INDIVIDUAL_LESSON: "Lekcja indywidualna",
            WORKSHOPS: "Warsztaty",
            EXTERNAL: "Wynajem sali",

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
            PERIOD_DAY: "Dni",

            "sid.not.found": "Nie znaleziono obiektu",
            "invalid.parameter": "Nieprawidłowy parametr ",
            "not.null.parameter": "Parametr pusty: "
        });
        $translateProvider.preferredLanguage('pl');
    });