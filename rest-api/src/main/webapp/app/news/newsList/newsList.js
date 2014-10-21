define([
    'news/module',
    'services/newsService',
    'services/notificationService'
], function (module) {

    module.controller("newsListController", function ($scope, newsHttpClient, newsService, notificationService) {

        var EDIT_NEWS_KEY = 'edit';

        $scope.newsList = newsHttpClient.findAll();

        $scope.add = function () {

        }

        $scope.update = function (news) {
            delete news[EDIT_NEWS_KEY];
            newsHttpClient.update({ sid: news.sid }, news).$promise.then(
                function () {
                    notificationService.success("Pomyślnie zapisano");
                    $scope.newsList = newsHttpClient.findAll();
                });
        }

        $scope.publish = function (news) {
            newsHttpClient.publish({ sid: news.sid }).$promise.then(
                function (value) {
                    news.objectState = value.objectState;
                    $scope.newsList = newsHttpClient.findAll();
                    notificationService.success("Pomyślnie zapisano");
                });
        }

        $scope.deactivate = function (news) {
            newsHttpClient.deactivate({ sid: news.sid }).$promise.then(
                function (value) {
                    news.objectState = value.objectState;
                    $scope.newsList = newsHttpClient.findAll();
                    notificationService.success("Pomyślnie zapisano");
                });
        }

        $scope.select = function (news) {
            if ($scope.selected != null && $scope.selected.sid == news.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selected = newsService.copyProperties(news);;
            $scope.selected[EDIT_NEWS_KEY] = false;
        }

        $scope.resolveStatusCss = function (news) {
            return {'label-success': news.objectState == 'ACTIVE', 'label-danger': news.objectState == 'INACTIVE'}
        }
    });
});