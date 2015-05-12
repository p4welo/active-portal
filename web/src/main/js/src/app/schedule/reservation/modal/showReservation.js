angular.module('activePortal.schedule')

    .controller('showReservationCtrl', function (event, $scope, $modalInstance, $filter, $modal) {
        $scope.event = event;

        var $translate = $filter('translate');
        if (event.type == "COURSE") {
            $scope.name = event.description;
        }
        else {
            $scope.name = $translate($scope.event.eventType);
        }
        $scope.date = event.date.toString();

        $scope.delete = function () {
            $modal.open(
                {
                    templateUrl: 'common/modal/deleteConfirm.tpl.html',
                    controller: "deleteConfirmDialogCtrl"
                }
            );
        }

        $scope.isEvent = function (event) {
            return event.type == "EVENT";
        }

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    })
;