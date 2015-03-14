define([
    'jquery',
    'schedule/module',
    'services/ticketTypeGroupService',
    'services/ticketTypeService'
], function ($, module) {

    module.controller('addTicketTypeController', ['$scope', '$modalInstance', 'ticketTypeGroupHttpClient', 'ticketTypeHttpClient', '$timeout', function ($scope, $modalInstance, ticketTypeGroupHttpClient, ticketTypeHttpClient, $timeout) {
        $scope.type = {};
        $scope.groups = ticketTypeGroupHttpClient.findAll();
        $scope.periodList = [];
        for (var i = 0; i < 31; i++) {
            $scope.periodList.push(i);
        }

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.save = function (type) {
            type.price = type.price.replace(",", ".");
            ticketTypeHttpClient.create(type).$promise.then(
                function () {
                    $modalInstance.close();
                });
        };

        $scope.$watch('type.price', function(newValue, oldValue) {
            if (newValue !== undefined && newValue !== oldValue) {
                $scope.type.price = newValue.replace(",", ".");
            }
        });

        $scope.focusInput = function (id) {
            $timeout(function () {
                $(id).focus();
            }, 100);
        };
    }]);
});