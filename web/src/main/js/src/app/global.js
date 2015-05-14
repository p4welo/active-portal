angular.module('activePortal')
    .run(function ($rootScope, $location, $modal, $log) {
        $rootScope.isActive = function (obj) {
            return obj.objectState == 'ACTIVE';
        };
        $rootScope.isEqual = function (obj1, obj2) {
            return obj1 !== undefined && obj2.sid == obj1.sid;
        };
        $rootScope.isLocal = function () {
            return $location.host() == 'localhost';
        };
        $rootScope.scan = function () {
            $modal.open({
                templateUrl: 'common/modal/scanTicket.tpl.html',
                controller: "scanTicketDialogCtrl",
                size: 'sm'
            });
        };
        $rootScope.log = function (message) {
            $log.debug(message);
        };
    });