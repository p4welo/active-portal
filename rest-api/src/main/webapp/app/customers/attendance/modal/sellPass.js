define([
    'customers/module'
], function (module) {

    module.controller('sellPassController', function ($scope, $modalInstance) {
        $scope.cancel = function () {
            $modalInstance.dismiss();
        }
    });

});