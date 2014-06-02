angular.module('PortalApp.controllers')

    .controller('NewsCtrl', function ($scope, newsFactory, newsService, notificationService) {
        /*
         =================================================================
         NEWS LOADING
         =================================================================
         */
        $scope.loading = true;
        $scope.news = newsFactory.find(function () {
            $scope.loading = false;
        });

        /*
         =================================================================
         NEWS UPDATE
         =================================================================
         */
        $scope.isExpanded = function (news) {
            return news.state == 'editing';
        }
        $scope.edit = function (news) {
            news.editing = true;
            news.edit = {};
            newsService.copyProperties(news, news.edit);
        }
        $scope.collapse = function (news) {
            news.editing = false;
        }
        $scope.update = function (news) {

            var newNews = newsFactory.update({sid: news.edit.sid}, news.edit, function () {
                notificationService.success("Pomyślnie zapisano");
                news.editing = false;
                newsService.copyProperties(newNews, news);
            });
        }

        $scope.isExpanded = function (news) {
            return news.editing;
        }

        /*
         =================================================================
         NEWS CREATION
         =================================================================
         */
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
    });