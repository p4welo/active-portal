define([
    'news/module',
    'services/newsService'
], function (module) {

    module.controller("newsListController", function ($scope, newsFactory) {
        $scope.newsList = newsFactory.findAll();

        $scope.add = function () {

        }

        $scope.select = function (news) {
            if ($scope.selected == news) {
                $scope.selected = null;
                return;
            }
            $scope.selected = news;
            $scope.selected.edit = false;
        }
    });
});