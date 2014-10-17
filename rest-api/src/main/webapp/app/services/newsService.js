define([
    'services/module'
], function (module) {

    module.factory('newsFactory', function ($resource) {

        return $resource(null, null, {

            findAll: {
                url: "rest/news/list",
                method: 'GET',
                isArray: true
            },
            findPublic: {
                url: "rest/news/public/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/news/create",
                method: 'POST'
            },
            get: {
                url: "rest/news/:sid",
                method: 'GET'
            },
            update: {
                url: "rest/news/:sid",
                method: 'PUT'
            },
            publish: {
                url: "rest/news/:sid/publish",
                method: 'GET'
            },
            deactivate: {
                url: "rest/news/:sid/deactivate",
                method: 'GET'
            },
            delete: {
                url: "rest/news/:sid",
                method: 'DELETE'
            }
        })
    });

    module.service("newsService", function () {
        this.copyProperties = function (news) {
            if (news == null) {
                return;
            }
            return {
                sid: news.sid,
                objectState: news.objectState,
                title: news.title,
                createdAt: news.createdAt,
                content: news.content,
                imageSrc: news.imageSrc,
                imageAlt: news.imageAlt
            }
        }
    })
});