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
                    controller: "addTicketTypeGroupCtrl",
                    backdrop: 'static'
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
            if ($scope.selected && $scope.selected.sid == group.sid) {
                $scope.selected = undefined;
                return;
            }
            $scope.selected = angular.copy(group);
        };
        $scope.save = function (object, property, callback) {
            if (property == NAME_KEY || property == DESCRIPTION_KEY) {
                var obj = _.findWhere($scope.groups, {sid: object.sid});
                if (obj) {
                    obj[property] = object[property];
                    ticketTypeGroupHttpClient.update({sid: object.sid}, obj).$promise.then(
                        function () {

                            notificationService.success("Pomyślnie zapisano");
                            callback();
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
                        controller: "deleteConfirmDialogCtrl",
                        backdrop: 'static'
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