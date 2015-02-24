define([
    'core/module'
], function (module) {

    module.controller('scanTicketDialogController', ['$scope', '$state', '$modalInstance', '$timeout', function ($scope, $state, $modalInstance, $timeout) {

        $scope.code = "";
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.confirm = function (code) {
            if (code.length > 0) {
//                $state.go("detailsByTicket", {id: code})
                $modalInstance.close();
            }
        };
        $scope.focusInput = function () {
            $timeout(function () {
                $("#code").focus();
            }, 100);
        };
    }])
});