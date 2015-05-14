angular.module('activePortal.schedule')

    .controller('showReservationCtrl', function (event, $scope, $modalInstance, $filter, $modal, coreHttpClient) {
        $scope.event = event;

        var $translate = $filter('translate');
        if (event.type == "COURSE") {
            $scope.name = event.description;
        }
        else {
            $scope.name = $translate($scope.event.eventType);
        }
        var year = event.date.values[0];
        var month = event.date.values[1] - 1;
        var day = event.date.values[2];
        $scope.date = new Date(year, month, day,0, 0, 0, 0);

        $scope.delete = function () {
            $modal.open(
                {
                    templateUrl: 'common/modal/deleteConfirm.tpl.html',
                    controller: "deleteConfirmDialogCtrl"
                }
            ).result.then(
                function () {
                    return coreHttpClient.delete({type: "event", sid: $scope.event.sid}).$promise;
                }
            ).then(
                function () {
                    $modalInstance.close();
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