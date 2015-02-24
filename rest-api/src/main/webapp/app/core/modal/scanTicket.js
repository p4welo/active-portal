define([
    'core/module'
], function (module) {

    module.controller('scanTicketDialogController', ['$scope', '$state', '$modalInstance', '$timeout', function ($scope, $state, $modalInstance, $timeout) {

        $scope.code = "";
        $scope.customerLoading = false;
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.confirm = function (code) {
            $scope.customerLoading = true;
//                $modalInstance.close();
//            }
        };
        $scope.focusInput = function () {
            $timeout(function () {
                $("#code").focus();
            }, 100);
        };
    }])
});