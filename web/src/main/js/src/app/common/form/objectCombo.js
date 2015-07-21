angular.module('activePortal.common')

    .directive('formObjectCombo', function () {
        return {
            restrict: 'E',
            scope: {
                object: '=',
                label: "@",
                field: "@",
                orderBy: "@",
                trackBy: "@",
                list: "=",
                onSave: "="
            },
            replace: true,
            templateUrl: 'common/form/objectCombo.tpl.html',
            controller: function ($scope) {
                if (!$scope.orderBy) {
                    $scope.orderBy = 'name';
                }
                if (!$scope.trackBy) {
                    $scope.trackBy = 'sid';
                }

                $scope.editing = false;
                $scope.edit = function () {
                    $scope.oldValue = $scope.object[$scope.field];
                    $scope.editing = true;
                };
                $scope.cancel = function () {
                    $scope.object[$scope.field] = $scope.oldValue;
                    $scope.editing = false;
                };
                $scope.save = function () {
                    $scope.saving = true;
                    $scope.onSave($scope.object, $scope.field, function () {
                        $scope.saving = false;
                        $scope.editing = false;
                    });
                };
            }
        };
    })
;