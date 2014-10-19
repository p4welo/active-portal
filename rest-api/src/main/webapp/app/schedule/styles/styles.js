define([
    'schedule/module',
    'schedule/styles/modal/addStyle',
    'services/styleService',
    'services/categoryService',
    'services/notificationService'
], function (module) {

    module.controller("stylesController", function ($scope, $modal, styleFactory, styleService, categoryFactory, notificationService) {

        $scope.styles = styleFactory.findAll();
        $scope.categories = categoryFactory.findAll();

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
            $scope.selected.editcategory = false;
        }

        $scope.editCategory = function (style) {
            style.editcategory = true;
            $scope.category = style.category;
        }

        $scope.setCategory = function (style) {
            styleFactory.setCategory({sid: style.sid}, style.category).$promise.then(
                function () {
                    style.editcategory = false;
                    $scope.styles = styleFactory.findAll();
                    notificationService.success("Pomyślnie zapisano");
                });
        }

        $scope.resolveStatusCss = function (style) {
            return {'label-success': style.objectState == 'ACTIVE', 'label-danger': style.objectState == 'INACTIVE'}
        }
    });
});