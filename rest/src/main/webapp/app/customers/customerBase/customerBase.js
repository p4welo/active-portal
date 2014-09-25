define([
    'customers/module',
    'customers/customerBase/modal/subscribeClass',
    'customers/customerBase/modal/joinClass'
], function (module) {

    module.controller("customerBaseController", function ($scope, $modal) {
        $scope.select = function (customer) {
            if ($scope.selected == customer) {
                $scope.selected = null;
                return;
            }
            $scope.selected = customer;
            $scope.selected.edit == false;
        }
        $scope.deselect = function () {
            $scope.selected = null;
            return;
        }

        $scope.subscribe = function (customer) {
            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/customers/customerBase/modal/subscribeClass.html',
                    controller: "subscribeClassController",
                    size: 'lg'
                });

            modalInstance.result.then(function () {

            });
        };

        $scope.join = function (customer) {
            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/customers/customerBase/modal/joinClass.html',
                    controller: "joinClassController",
                    size: 'lg'
                });

            modalInstance.result.then(function () {

            });
        };

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
    });
});