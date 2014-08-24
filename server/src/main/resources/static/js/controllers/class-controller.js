angular.module('PortalApp.controllers')

    .controller('class-controller', function ($scope) {
        /*
         =================================================================
         CLASS LOADING
         =================================================================
         */
        $scope.loading = true;
        $scope.classes = classFactory.find(function () {

            $scope.loading = false;
        });
    });
;