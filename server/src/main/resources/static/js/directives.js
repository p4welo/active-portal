'use strict';
angular.module('PortalApp.directives', [])

//    .directive('ckEditor', [function () {
//        return {
//            require: '?ngModel',
//            link: function ($scope, elm, attr, ngModel) {
//
//                var ck = CKEDITOR.replace(elm[0]);
//                ck.on('pasteState', function () {
//                    $scope.$apply(function () {
//                        ngModel.$setViewValue(ck.getData());
//                    });
//                });
//
//                ngModel.$render = function (value) {
//                    ck.setData(ngModel.$modelValue);
//                };
//            }
//        };
//    }])

    .directive('focusOn', function() {
        return function(scope, elem, attr) {
            scope.$on('focusOn', function(e, name) {
                if(name === attr.focusOn) {
                    elem[0].focus();
                }
            });
        };
    })