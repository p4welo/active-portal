angular.module('activePortal.schedule')

    .directive('scheduleSubmenu', function () {
        return {
            restrict: 'EA',
            replace: true,
            templateUrl: 'schedule/submenu/scheduleSubmenu.tpl.html'
        };
    })
;