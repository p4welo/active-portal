angular.module('activePortal.schedule')

    .controller('addStyleCtrl', function ($scope, $modalInstance, categoryHttpClient, styleHttpClient, $timeout) {
        $scope.style = {};
        $scope.categories = categoryHttpClient.findAll();

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (style) {
            styleHttpClient.create(style).$promise.then(
                function () {
                    $modalInstance.close();
                });
        };

        $scope.focusInput = function (id) {
            $timeout(function () {
                $(id).focus();
            }, 100);
        };
    })
;