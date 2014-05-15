angular.module('PortalApp.services')

    .factory('newsFactory', function ($resource) {

        var NEWS_LIST_KEY = getRestUrl("/news/list");
        var CREATE_NEWS_KEY = getRestUrl("/news");
        var GET_NEWS_KEY = getRestUrl("/news/:sid");

        return $resource(null, null, {
            find: {
                url: NEWS_LIST_KEY,
                method: 'GET',
                isArray: true
            },
            create: {
                url: CREATE_NEWS_KEY,
                method: 'POST'
            },
            get: {
                url: GET_NEWS_KEY,
                method: 'GET'
            },
            update: {
                url: GET_NEWS_KEY,
                method: 'PUT'
            },
            delete: {
                url: GET_NEWS_KEY,
                method: 'DELETE'
            }
        })
    })

    .service('newsService', function () {
        this.copyProperties = function (source, destination) {
            destination.sid = source.sid;
            destination.createdAt = source.createdAt;
            destination.title = source.title;
            destination.content = source.content;
            destination.imageSrc = source.imageSrc;
            destination.imageAlt = source.imageAlt;
        }
    });