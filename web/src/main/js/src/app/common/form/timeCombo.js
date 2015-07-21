angular.module('activePortal.common')

    .directive('formTimeCombo', function () {
        return {
            restrict: 'E',
            scope: {
                object: '=',
                label: "@",
                field: "@",
                hourStep: "@",
                hourStart: "@",
                hourEnd: "@",
                minuteStep: "@",
                minuteStart: "@",
                minuteEnd: "@",
                onSave: "="
            },
            replace: true,
            templateUrl: 'common/form/timeCombo.tpl.html',
            controller: function ($scope) {
                if (!$scope.hourStep) {
                    $scope.hourStep = 1;
                }
                if (!$scope.hourStart) {
                    $scope.hourStart = 7;
                }
                if (!$scope.hourEnd) {
                    $scope.hourEnd = 24;
                }
                if (!$scope.minuteStep) {
                    $scope.minuteStep = 5;
                }
                if (!$scope.minuteStart) {
                    $scope.minuteStart = 0;
                }
                if (!$scope.minuteEnd) {
                    $scope.minuteEnd = 60;
                }

                $scope.hours = [];
                $scope.minutes = [];
                for (var i = $scope.hourStart; i < $scope.hourEnd; i += $scope.hourStep) {
                    $scope.hours.push("" + i);
                }
                for (i = $scope.minuteStart; i < $scope.minuteEnd; i += $scope.minuteStep) {
                    var j = i;
                    if (j < 10) {
                        j = "0" + j;
                    }
                    $scope.minutes.push("" + j);
                }

                $scope.editing = false;
                $scope.edit = function () {
                    $scope.oldValue = $scope.object[$scope.field];
                    var obj = $scope.oldValue.split(":");
                    $scope.value = {
                        hours: obj[0],
                        minutes: obj[1]
                    };
                    $scope.editing = true;
                };
                $scope.cancel = function () {
                    $scope.object[$scope.field] = $scope.oldValue;
                    $scope.editing = false;
                };
                $scope.save = function () {
                    $scope.saving = true;
                    $scope.object[$scope.field] = $scope.value.hours + ":" + $scope.value.minutes;
                    $scope.onSave($scope.object, $scope.field, function () {
                        $scope.saving = false;
                        $scope.editing = false;
                    });
                };
            }
        };
    })
;