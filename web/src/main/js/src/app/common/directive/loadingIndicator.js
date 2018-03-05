angular.module('activePortal.common')

    .directive('loadingIndicator', function () {
        return {
            restrict: 'EA',
            require: '^ngLoading',
            replace: true,
            scope: {
                ngLoading: '=',
                ngContentClass: '@'
            },
            transclude: true,
            template:
            '<div class="loading-indicator">' +
                '<div ng-if="ngLoading" class="row text-center">' +
                    '<div>' +
                        '<i class="fa fa-spin fa-spinner"></i>' +
                        '<span style="margin-left: 10px;">Ładowanie...</span>' +
                    '</div>' +
                '</div>' +
                '<div ng-transclude class="{{ngContentClass}}" ng-show="!ngLoading"></div>' +
            '</div>'
        };
    })
;