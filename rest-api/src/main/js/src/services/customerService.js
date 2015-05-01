/* jshint -W024 */
angular.module('activePortal.services')

    .factory('customerHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.URL;

        return $resource(null, null, {

            findAll: {
                url: url + "rest/customer/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "rest/customer/create",
                method: 'POST'
            },
            get: {
                url: url + "rest/customer/:sid",
                method: 'GET'
            },
            update: {
                url: url + "rest/customer/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "rest/customer/:sid",
                method: 'DELETE'
            },
            presence: {
                url: url + "rest/customer/:sid/presence",
                method: 'GET',
                isArray: true
            },
            courses: {
                url: url + "rest/customer/:sid/courses",
                method: 'GET',
                isArray: true
            },
            coursesToJoin: {
                url: url + "rest/customer/:sid/courses/canJoin",
                method: 'GET',
                isArray: true
            },
            coursesToRegister: {
                url: url + "rest/customer/:sid/courses/canRegister",
                method: 'GET',
                isArray: true
            },
            join: {
                url: url + "rest/customer/:sid/join",
                method: 'PUT'
            },
            subscribe: {
                url: url + "rest/customer/:sid/subscribe",
                method: 'PUT'
            },
            buyTicket: {
                url: url + "rest/customer/:sid/ticket",
                method: 'PUT'
            },
            findSimilar: {
                url: url + "rest/customer/similar",
                method: 'POST'
            }
        });
    })

    .factory('customerFactory', function () {
        var customers = {};

        return {
            setCustomer: function (customer) {
                customers[customer.sid] = customer;
            },
            getCustomer: function (sid) {
                return customers[sid];
            }
        };
    })
;