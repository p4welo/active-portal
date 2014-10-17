define([
    'news/module',
    'services/newsService',
    'services/notificationService'
], function (module) {

    module.controller("newsListController", function ($scope, newsFactory, newsService, notificationService) {
        $scope.newsList = newsFactory.findAll();

        $scope.add = function () {

        }

        $scope.update = function (news) {
            delete news['edit'];
            newsFactory.update({ sid: news.sid }, news).$promise.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    $scope.newsList = newsFactory.findAll();
                });
        }

        $scope.publish = function (news) {
            newsFactory.publish({ sid: news.sid }).$promise.then(
                function (value) {
                    news.objectState = value.objectState;
                    $scope.newsList = newsFactory.findAll();
                    notificationService.success("Pomyślnie zapisano");
                });
        }

        $scope.deactivate = function (news) {
            newsFactory.deactivate({ sid: news.sid }).$promise.then(
                function (value) {
                    news.objectState = value.objectState;
                    $scope.newsList = newsFactory.findAll();
                    notificationService.success("Pomyślnie zapisano");
                });
        }

        $scope.select = function (news) {
            if ($scope.selected != null && $scope.selected.sid == news.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selected = newsService.copyProperties(news);;
            $scope.selected.edit = false;
        }

        $scope.resolveStatusCss = function (news) {
            return {'label-success': news.objectState == 'ACTIVE', 'label-danger': news.objectState == 'INACTIVE'}
        }
    });
});