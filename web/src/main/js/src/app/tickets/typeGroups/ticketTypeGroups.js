angular.module('activePortal.schedule')

    .config(function ($stateProvider) {
        $stateProvider.state('ticketGroups', {
            url: "/ticket/groups",
            templateUrl: "tickets/typeGroups/ticketTypeGroups.tpl.html",
            controller: "ticketGroupsCtrl"
        });
    })

    .controller('ticketGroupsCtrl', function ($scope, ticketTypeGroupHttpClient, notificationService, $modal) {
        var NAME_KEY = "name";
        var DESCRIPTION_KEY = "description";
        var OBJECT_PROPERTIES = [NAME_KEY, DESCRIPTION_KEY];

        // =======================================
        $scope.groupLoading = true;
        ticketTypeGroupHttpClient.findAll().$promise.then(
            function (result) {
                $scope.groups = result;
                $scope.groupLoading = false;
            }
        );
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
            $modal.open(
                {
                    templateUrl: 'tickets/typeGroups/modal/addGroup.tpl.html',
                    controller: "addTicketTypeGroupCtrl"
                }
            ).result.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    return ticketTypeGroupHttpClient.findAll().$promise;
                }
            ).then(
                function (result) {
                    $scope.groups = result;
                }
            );
        };
        // =======================================
        $scope.select = function (group) {
            if ($scope.selected !== undefined && $scope.selected.sid == group.sid) {
                $scope.selected = undefined;
                return;
            }
            $scope.selected = angular.copy(group);

            for (var i = 0; i < OBJECT_PROPERTIES.length; i++) {
                $scope.selected[OBJECT_PROPERTIES[i]] = {
                    value: group[OBJECT_PROPERTIES[i]],
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
        $scope.hover = function (object, property) {
            object[property].hover = true;
        };
        $scope.leave = function (object, property) {
            object[property].hover = false;
        };
        $scope.save = function (object, property) {
            object[property].saving = true;
            if (property == NAME_KEY || property == DESCRIPTION_KEY) {
                var obj = _.findWhere($scope.groups, {sid: object.sid});
                obj[property] = object[property].value;
                if (obj !== undefined) {
                    ticketTypeGroupHttpClient.update({sid: object.sid}, obj).$promise.then(
                        function () {
                            object[property].edit = false;
                            object[property].saving = false;
                            object[property].hover = false;

                            notificationService.success("Pomyślnie zapisano");
                            return ticketTypeGroupHttpClient.findAll().$promise;
                        }
                    ).then(
                        function (result) {
                            $scope.groups = result;
                        }
                    );
                }
            }
        };
        // =======================================
        $scope.delete = function (group) {
            if (group !== undefined) {
                $modal.open(
                    {
                        templateUrl: 'common/modal/deleteConfirm.tpl.html',
                        controller: "deleteConfirmDialogCtrl"
                    }
                ).result.then(
                    function () {
                        $scope.selected = undefined;
                        return ticketTypeGroupHttpClient.delete({sid: group.sid}).$promise;
                    }
                ).then(
                    function () {
                        notificationService.success("Pomyślnie usunięto");
                        return ticketTypeGroupHttpClient.findAll().$promise;
                    }
                ).then(
                    function (result) {
                        $scope.groups = result;
                    }
                );
            }
        };
    })
;