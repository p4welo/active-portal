define([
    'news/module',
    'services/newsService',
    'services/notificationService'
], function (module) {

    module.controller("newsListController", ['$scope', 'newsHttpClient', 'notificationService', function ($scope, newsHttpClient, notificationService) {

        var EDIT_NEWS_KEY = 'edit';

        $scope.newsList = newsHttpClient.findAll();
        $scope.add = function () {

        }

        $scope.update = function (news) {
            delete news[EDIT_NEWS_KEY];
            newsHttpClient.update({ sid: news.sid }, news).$promise.then(function () {
                notificationService.success("Pomyślnie zapisano");
                newsHttpClient.findAll().$promise.then(function (result) {
                    $scope.newsList = result;
                });
            });
        }

        $scope.publish = function (news) {
            newsHttpClient.publish({ sid: news.sid }).$promise.then(function (value) {
                news.objectState = value.objectState;
                newsHttpClient.findAll().$promise.then(function (result) {
                    $scope.newsList = result;
                });
                notificationService.success("Pomyślnie zapisano");
            });
        }

        $scope.deactivate = function (news) {
            newsHttpClient.deactivate({ sid: news.sid }).$promise.then(function (value) {
                news.objectState = value.objectState;
                newsHttpClient.findAll().$promise.then(function (result) {
                    $scope.newsList = result;
                });
                notificationService.success("Pomyślnie zapisano");
            });
        }

        $scope.select = function (news) {
            if ($scope.selected != null && $scope.selected.sid == news.sid) {
                $scope.selected = null;
                return;
            }
            $scope.selected = angular.copy(news);
            $scope.selected[EDIT_NEWS_KEY] = false;
        }

        $scope.resolveStatusCss = function (news) {
            return {'label-success': news.objectState == 'ACTIVE', 'label-danger': news.objectState == 'INACTIVE'}
        }
    }]);
});