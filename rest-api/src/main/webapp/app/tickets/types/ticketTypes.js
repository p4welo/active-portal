define([
    'tickets/module',
    'core/modal/deleteConfirm',
    'tickets/types/modal/addType',
    'services/ticketTypeService',
    'services/ticketTypeGroupService',
    'services/notificationService'
], function (module) {

    module.controller("ticketTypesController", ['$scope', '$modal', 'ticketTypeHttpClient', 'ticketTypeGroupHttpClient', 'notificationService', function ($scope, $modal, ticketTypeHttpClient, ticketTypeGroupHttpClient, notificationService) {
        var GROUP_KEY = "group";
        var NAME_KEY = "name";
        var OBJECT_PROPERTIES = [GROUP_KEY, NAME_KEY];

        // =======================================
        $scope.typeLoading = true;
        ticketTypeHttpClient.findAll().$promise.then(
            function (result) {
                $scope.types = result;
                $scope.typeLoading = false;
            }
        );
        $scope.groups = ticketTypeGroupHttpClient.findAll();

        // =======================================
        $scope.sort = {
            column: 'name',
            descending: false
        };
        $scope.toggleSort = function (column) {
            var sort = $scope.sort;
            if (sort.column == column) {
                sort.descending = !sort.descending;
            } else {
                sort.column = column;
                sort.descending = false;
            }
        };
        $scope.sortIcon = function (column) {
            var sort = $scope.sort;
            if (sort.column == column) {
                return sort.descending ? "fa fa-caret-down" : "fa fa-caret-up";
            }
            return "";
        };

        // =======================================
        $scope.add = function () {
            var modalInstance = $modal.open({
                templateUrl: 'app/tickets/types/modal/addType.html',
                controller: "addTicketTypeController"
            });

            modalInstance.result.then(function () {
                ticketTypeHttpClient.findAll().$promise.then(
                    function (result) {
                        $scope.types = result;
                    });
                notificationService.success("Pomyślnie zapisano");
            });
        };
        $scope.delete = function (type) {
            if (type !== undefined) {
                var modalInstance = $modal.open({
                    templateUrl: 'app/core/modal/deleteConfirm.html',
                    controller: "deleteConfirmDialogController"
                });

                modalInstance.result.then(function () {
                    ticketTypeHttpClient.delete({sid: type.sid}).$promise.then(
                        function () {
                            notificationService.success("Pomyślnie usunięto");
                            ticketTypeHttpClient.findAll().$promise.then(
                                function (result) {
                                    $scope.types = result;
                                });
                        }
                    );
                });
            }
        };
        // =======================================
        $scope.select = function (object) {
            if ($scope.selected !== undefined && $scope.selected.sid == object.sid) {
                $scope.selected = undefined;
                return;
            }
            $scope.selected = angular.copy(object);

            for (var i = 0; i < OBJECT_PROPERTIES.length; i++) {
                $scope.selected[OBJECT_PROPERTIES[i]] = {
                    value: object[OBJECT_PROPERTIES[i]],
                    edit: false,
                    saving: false,
                    hover: false,
                    oldVal: {}
                };
            }
        };
        $scope.edit = function (object, property) {
            object[property].edit = true;
            object[property].oldVal = object[property].value;
        };
        $scope.cancel = function (object, property) {
            object[property].value = object[property].oldVal;
            object[property].edit = false;
            object[property].hover = false;
        };
        $scope.save = function (object, property) {
            object[property].saving = true;
            if (property == GROUP_KEY) {
                ticketTypeHttpClient.setGroup({sid: object.sid}, object.group.value).$promise.then(
                    function () {
                        object[property].edit = false;
                        object[property].saving = false;
                        object[property].hover = false;

                        notificationService.success("Pomyślnie zapisano");
                        ticketTypeHttpClient.findAll().$promise.then(
                            function (result) {
                                $scope.types = result;
                            });
                    });
            }
            else if (property == NAME_KEY) {
                var obj = _.findWhere($scope.styles, {sid: object.sid});
                obj.name = object.name.value;
                if (obj !== undefined) {
                    ticketTypeHttpClient.update({ sid: object.sid }, obj).$promise.then(
                        function () {
                            object[property].edit = false;
                            object[property].saving = false;
                            object[property].hover = false;

                            notificationService.success("Pomyślnie zapisano");
                            ticketTypeHttpClient.findAll().$promise.then(
                                function (result) {
                                    $scope.types = result;
                                });
                        });
                }
            }
        };
        $scope.hover = function (object, property) {
            object[property].hover = true;
        };
        $scope.leave = function (object, property) {
            object[property].hover = false;
        };
    }]);
});