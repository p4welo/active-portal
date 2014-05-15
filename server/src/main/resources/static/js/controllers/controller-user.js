angular.module('PortalApp.controllers')

    .controller('LoginCtrl', function ($scope, userFactory, menuFactory, $location, $rootScope, $cookieStore, focus) {

        focus('login');

        $scope.login = function () {
            var result = userFactory.authenticate({login: $scope.username, pass: $scope.password}, null, function () {
                $rootScope.token = result.token;
                $cookieStore.put('authToken', $rootScope.token);
                $rootScope.user = userFactory.get(function () {
                    $rootScope.menu = menuFactory.get(function () {
                        $location.path("/");
                    });

                });
            });
        };
    });