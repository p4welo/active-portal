define([
    'services/module'
], function (module) {

    module.factory('customerHttpClient', function ($resource) {

        return $resource(null, null, {

            findAll: {
                url: "rest/customer/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/customer/create",
                method: 'POST'
            },
            get: {
                url: "rest/customer/:sid",
                method: 'GET'
            },
            update: {
                url: "rest/customer/:sid",
                method: 'PUT'
            },
            delete: {
                url: "rest/customer/:sid",
                method: 'DELETE'
            },
            presence: {
                url: "rest/customer/:sid/presence",
                method: 'GET',
                isArray: true
            },
            courses: {
                url: "rest/customer/:sid/courses",
                method: 'GET',
                isArray: true
            },
            coursesToJoin: {
                url: "rest/customer/:sid/courses/canJoin",
                method: 'GET',
                isArray: true
            },
            coursesToRegister: {
                url: "rest/customer/:sid/courses/canRegister",
                method: 'GET',
                isArray: true
            },
            join: {
                url: "rest/customer/:sid/join",
                method: 'PUT'
            },
            subscribe: {
                url: "rest/customer/:sid/subscribe",
                method: 'PUT'
            },
            findSimilar: {
                url: "rest/customer/similar",
                method: 'POST'
            }
        })
    });

    module.factory('customerFactory', function () {
        var customers = {};

        return {
            setCustomer: function (customer) {
                customers[customer.sid] = customer;
            },
            getCustomer: function (sid) {
                return customers[sid];
            }
        }
    });
});