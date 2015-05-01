angular.module('activePortal.common')

    .directive('viewHeader', function () {
        return {
            restrict: 'EA',
            scope: {
                headerLabel: '@',
                iconClass: '@'
            },
            transclude: true,
            templateUrl: 'common/directive/viewHeader.tpl.html'
        };
    })
;