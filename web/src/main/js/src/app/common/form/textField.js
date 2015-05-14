angular.module('activePortal.common')

    .directive('formTextField', function () {
        return {
            restrict: 'EA',
            scope: {
                ngModel: '=',
                label: "@",
                field: "@",
                onSave: "&"
            },
            templateUrl: 'common/form/textField.tpl.html',
            controller: function ($scope) {
                $scope.editing = false;

                $scope.edit = function () {
                    $scope.oldValue = $scope.ngModel[$scope.field];
                    $scope.editing = true;
                };
                $scope.cancel = function () {
                    $scope.ngModel[$scope.field] = $scope.oldValue;
                    $scope.editing = false;
                };
                $scope.save = function () {
                    //$scope.onSave();
                };
            }
        };
    })
;