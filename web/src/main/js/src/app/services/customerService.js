/* jshint -W024 */
angular.module('activePortal.services')

    .factory('customerHttpClient', function ($resource, serverConf) {
        "use strict";
        var url = serverConf.REST_URL;

        return $resource(null, null, {

            findAll: {
                url: url + "customer/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: url + "customer/create",
                method: 'POST'
            },
            get: {
                url: url + "customer/:sid",
                method: 'GET'
            },
            update: {
                url: url + "customer/:sid",
                method: 'PUT'
            },
            delete: {
                url: url + "customer/:sid",
                method: 'DELETE'
            },
            presence: {
                url: url + "customer/:sid/presence",
                method: 'GET',
                isArray: true
            },
            courses: {
                url: url + "customer/:sid/courses",
                method: 'GET',
                isArray: true
            },
            coursesToJoin: {
                url: url + "customer/:sid/courses/canJoin",
                method: 'GET',
                isArray: true
            },
            coursesToRegister: {
                url: url + "customer/:sid/courses/canRegister",
                method: 'GET',
                isArray: true
            },
            join: {
                url: url + "customer/:sid/join",
                method: 'PUT'
            },
            subscribe: {
                url: url + "customer/:sid/subscribe",
                method: 'PUT'
            },
            buyTicket: {
                url: url + "customer/:sid/ticket",
                method: 'PUT'
            },
            findSimilar: {
                url: url + "customer/similar",
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