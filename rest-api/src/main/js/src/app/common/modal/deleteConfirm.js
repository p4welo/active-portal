angular.module('activePortal.common')

    .controller('deleteConfirmDialogCtrl', function ($scope, $modalInstance) {

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.confirm = function () {
            $modalInstance.close();
        };
    })
;