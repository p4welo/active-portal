angular.module('PortalApp.controllers')

    .controller('NewsCtrl', function ($scope, newsFactory, newsService, notificationService) {
        $scope.loading = true;
        $scope.news = newsFactory.find(function () {
            $scope.loading = false;
        });

        $scope.edit = function (news) {
            news.state = 'editing';
            news.edit = {};
            newsService.copyProperties(news, news.edit);
        }

        $scope.newNews = {};
        $scope.save = function (news) {
            var nNews = newsFactory.create(news, function () {
                hideModal("#newsModal");
                $scope.newNews = {};
                $scope.news.push(nNews);
                notificationService.success("Pomyślnie zapisano");
            });
        }
        $scope.saveCancel = function () {
            $scope.newNews = {};
            hideModal("#newsModal");
        }

        $scope.update = function (news) {

            var newNews = newsFactory.update({sid: news.edit.sid}, news.edit, function () {
                notificationService.success("Pomyślnie zapisano");
                news.state = '';
                newsService.copyProperties(newNews, news);
            });
        }
    });