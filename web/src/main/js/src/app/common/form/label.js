angular.module('activePortal.common')

    .directive('formLabel', function () {
        return {
            restrict: 'EA',
            replace: true,
            scope: {
                ngModel: '=',
                label: "@"
            },
            templateUrl: 'common/form/label.tpl.html'
        };
    })
;