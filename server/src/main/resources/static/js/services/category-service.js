angular.module('PortalApp.services')

    .factory('categoryFactory', function ($resource) {
        var CATEGORY_LIST_KEY = getRestUrl("/category/list");
        var CREATE_CATEGORY_KEY = getRestUrl("/category");
        var GET_CATEGORY_KEY = getRestUrl("/category/:sid");

        return $resource(null, null, {
            find: {
                url: CATEGORY_LIST_KEY,
                method: 'GET',
                isArray: true
            },
            create: {
                url: CREATE_CATEGORY_KEY,
                method: 'POST'
            },
            get: {
                url: GET_CATEGORY_KEY,
                method: 'GET'
            },
            update: {
                url: GET_CATEGORY_KEY,
                method: 'PUT'
            },
            delete: {
                url: GET_CATEGORY_KEY,
                method: 'DELETE'
            }
        })
    })

    .service('categoryService', function () {
        this.copyProperties = function (source, destination) {
            destination.sid = source.sid;
            destination.objectState = source.objectState;
            destination.name = source.name;
            destination.code = source.code;
        }
    })
;