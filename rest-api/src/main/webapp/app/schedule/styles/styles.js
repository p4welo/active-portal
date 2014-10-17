define([
    'schedule/module',
    'schedule/styles/modal/addStyle',
    'services/styleService',
    'services/notificationService'
], function (module) {

    module.controller("stylesController", function ($scope, $modal, styleFactory, styleService, notificationService) {

        $scope.styles = styleFactory.findAll();

        $scope.add = function () {
            var modalInstance = $modal.open(
                {
                    templateUrl: 'app/schedule/styles/modal/addStyle.html',
                    controller: "addStyleController"
                });

            modalInstance.result.then(function () {
                $scope.styles = styleFactory.findAll();
                notificationService.success("Pomyślnie zapisano");
            });
        };

        $scope.select = function (style) {
            if ($scope.selected != null && $scope.selected.sid == style.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selected = styleService.copyProperties(style);
            $scope.selected.edit = false;
        }

        $scope.resolveStatusCss = function (style) {
            return {'label-success': style.objectState == 'ACTIVE', 'label-danger': style.objectState == 'INACTIVE'}
        }
    });
});