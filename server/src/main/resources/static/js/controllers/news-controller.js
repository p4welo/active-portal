angular.module('PortalApp.controllers')

    .controller('news-controller', function ($scope, newsFactory, newsService, notificationService) {
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
        $scope.toggle = function (news) {

            news.editing = !news.editing;
            if (news.editing) {
                news.edit = {};
                newsService.copyProperties(news, news.edit);
            }
        }
        $scope.reset = function (news) {
            if (news.editing) {
                news.edit = {};
                newsService.copyProperties(news, news.edit);
            }
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
    });