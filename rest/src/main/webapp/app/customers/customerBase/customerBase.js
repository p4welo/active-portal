define([
    'customers/module'
], function (module) {

    module.controller("customerBaseController", function ($scope) {

        $scope.customers = [
            {"firstName": "Anna", "lastName": "Fotyga", "gender": "F", "mobile": "789132665"},
            {"firstName": "Andrzej", "lastName": "Piaseczny", "gender": "M", "mobile": "556025123"},
            {"firstName": "Łukasz", "lastName": "Zagrobelny", "gender": "M", "mobile": "745212335"},
            {"firstName": "Monika", "lastName": "Kudyba", "gender": "F", "mobile": "995210236"},
            {"firstName": "Władysław", "lastName": "Pasikowski", "gender": "M", "mobile": "770550236"},
            {"firstName": "Szczepan", "lastName": "Oleksy", "gender": "M", "mobile": "112556323"},
            {"firstName": "Dagmara", "lastName": "Królikowska", "gender": "F", "mobile": "505123220"},
            {"firstName": "Honorata", "lastName": "Siudym", "gender": "F", "mobile": "793096623"},
            {"firstName": "Jacek", "lastName": "Gzella", "gender": "M", "mobile": "500120002"},
            {"firstName": "Zbigniew", "lastName": "Zamojski", "gender": "M", "mobile": "723556852"},
            {"firstName": "Anna", "lastName": "Przybylska", "gender": "F", "mobile": "601202885"},
            {"firstName": "Martyna", "lastName": "Olejnik", "gender": "F", "mobile": "506995888"},
            {"firstName": "Barbara", "lastName": "Krotoszyńska", "gender": "F", "mobile": "603338879"},
            {"firstName": "Paweł", "lastName": "Kukiz", "gender": "M", "mobile": "793432025"},
            {"firstName": "Adam", "lastName": "Bednorz", "gender": "M", "mobile": "792589660"}
        ];

        $scope.styles = [
            {"sid": "43223mcnv343445289vjkb0011168103", "id": 6, "name": "Hip hop", "category": {"sid": "43632299f3434e0889c96b50c1168103", "id": 1, "name": "Zajęcia solo", "code": "solo"}},
            {"sid": "43223mcnv343445289vjkb0585168103", "id": 7, "name": "Reggaeton", "category": {"sid": "43632299f3434e0889c96b50c1168103", "id": 1, "name": "Zajęcia solo", "code": "solo"}},
            {"sid": "53223mcnv343445289vjkb05ggvcxv03", "id": 11, "name": "Ladies latino", "category": {"sid": "43632299f3434e0889c96b50c1168103", "id": 1, "name": "Zajęcia solo", "code": "solo"}},
            {"sid": "53223mcnv34344vb89vjkb05ggvcxv03", "id": 12, "name": "Salsa solo", "category": {"sid": "43632299f3434e0889c96b50c1168103", "id": 1, "name": "Zajęcia solo", "code": "solo"}},
            {"sid": "a271dd9f273040ab90e9f4edefb4ea85", "id": 17, "name": "Zumba", "category": {"sid": "43632299f3434e0889c96b50c1168103", "id": 1, "name": "Zajęcia solo", "code": "solo"}},
            {"sid": "43632299f343445289vjkb50c1168103", "id": 2, "name": "Balet z el. gimn. art.", "category": {"sid": "53632299f3434e0889c96b50c1168103", "id": 2, "name": "Dzieci", "code": "dzieci"}},
            {"sid": "43223mcnv343445289vjkb05vvvcxv03", "id": 9, "name": "Hip hop dla dzieci 5-7 lat", "category": {"sid": "53632299f3434e0889c96b50c1168103", "id": 2, "name": "Dzieci", "code": "dzieci"}},
            {"sid": "43223mcnv343445289vjkb05ggvcxv03", "id": 10, "name": "Mix dance 4-7 lat", "category": {"sid": "53632299f3434e0889c96b50c1168103", "id": 2, "name": "Dzieci", "code": "dzieci"}},
            {"sid": "53223mcnv34344vb89vjgh05hjvcxv03", "id": 14, "name": "Balet 3 latki", "category": {"sid": "53632299f3434e0889c96b50c1168103", "id": 2, "name": "Dzieci", "code": "dzieci"}},
            {"sid": "96c3d0784adc45de98b7a7db179c5664", "id": 18, "name": "Różowe okulary", "category": {"sid": "53632299f3434e0889c96b50c1168103", "id": 2, "name": "Dzieci", "code": "dzieci"}},
            {"sid": "edd50f01a75c484f962355f99406247c", "id": 19, "name": "Balet 4-7 lat", "category": {"sid": "53632299f3434e0889c96b50c1168103", "id": 2, "name": "Dzieci", "code": "dzieci"}},
            {"sid": "e913f8b5b38342f296d6c046af700ade", "id": 20, "name": "Taniec towarzyski 6-9 lat", "category": {"sid": "53632299f3434e0889c96b50c1168103", "id": 2, "name": "Dzieci", "code": "dzieci"}},
            {"sid": "2222cd4ad3b2489a8728727138648627", "id": 22, "name": "Balet z el. gimn. art. 7-10 lat", "category": {"sid": "53632299f3434e0889c96b50c1168103", "id": 2, "name": "Dzieci", "code": "dzieci"}},
            {"sid": "43632299f3434e0889vjkb50c1168103", "id": 1, "name": "Aktywne 50+", "category": {"sid": "5vm32299f3434e0889c96b50c1168103", "id": 3, "name": "Seniorzy", "code": "seniorzy"}},
            {"sid": "43223299f343445289vjkb50c1168103", "id": 3, "name": "Taniec towarzyski", "category": {"sid": "5vm32299f3434e0889c96b50c1168nnn", "id": 4, "name": "Zajecia w parach", "code": "pary"}},
            {"sid": "43223299f343445289vjkb0011168103", "id": 4, "name": "Taniec użytkowy", "category": {"sid": "5vm32299f3434e0889c96b50c1168nnn", "id": 4, "name": "Zajecia w parach", "code": "pary"}},
            {"sid": "53223mcnv34344vb89vjgh05ggvcxv03", "id": 13, "name": "Bachata", "category": {"sid": "5vm32299f3434e0889c96b50c1168nnn", "id": 4, "name": "Zajecia w parach", "code": "pary"}},
            {"sid": "5322tycnv34344vb89vjgh05hjvcxv03", "id": 15, "name": "Salsa kubańska", "category": {"sid": "5vm32299f3434e0889c96b50c1168nnn", "id": 4, "name": "Zajecia w parach", "code": "pary"}},
            {"sid": "5322tycnv34344vb89vjgh05hjvc1233", "id": 16, "name": "Zouk", "category": {"sid": "5vm32299f3434e0889c96b50c1168nnn", "id": 4, "name": "Zajecia w parach", "code": "pary"}},
            {"sid": "e660b9cd75394737bf8e193dc3460552", "id": 21, "name": "Rueda de Casino", "category": {"sid": "5vm32299f3434e0889c96b50c1168nnn", "id": 4, "name": "Zajecia w parach", "code": "pary"}},
            {"sid": "43223369f343445289vjkb0011168103", "id": 5, "name": "Dziecięca formacja taneczna", "category": {"sid": "5vm32299f3434e0889c96b50c1mcnnnn", "id": 5, "name": "Treningi formacji", "code": "formacje"}},
            {"sid": "43223mcnv343445289vjkb05851yyv03", "id": 8, "name": "Trening El-Fuego", "category": {"sid": "5vm32299f3434e0889c96b50c1mcnnnn", "id": 5, "name": "Treningi formacji", "code": "formacje"}}
        ];

        $scope.categories = [
            {"sid": "43632299f3434e0889c96b50c1168103", "id": 1, "name": "Zajęcia solo", "code": "solo"},
            {"sid": "53632299f3434e0889c96b50c1168103", "id": 2, "name": "Dzieci", "code": "dzieci"},
            {"sid": "5vm32299f3434e0889c96b50c1168103", "id": 3, "name": "Seniorzy", "code": "seniorzy"},
            {"sid": "5vm32299f3434e0889c96b50c1168nnn", "id": 4, "name": "Zajecia w parach", "code": "pary"},
            {"sid": "5vm32299f3434e0889c96b50c1mcnnnn", "id": 5, "name": "Treningi formacji", "code": "formacje"}
        ];

    });
});