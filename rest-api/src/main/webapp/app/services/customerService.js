define([
    'services/module'
], function (module) {

    module.factory('customerFactory', function ($resource) {

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
            join: {
                url: "rest/customer/:sid/join",
                method: 'PUT'
            },
            subscribe: {
                url: "rest/customer/:sid/subscribe",
                method: 'PUT'
            }
        })
    });

    module.service('customerService', function () {
        this.copyProperties = function (customer) {
            if (customer == null) {
                return;
            }
            return {
                sid: customer.sid,
                objectState: customer.objectState,
                firstName: customer.firstName,
                lastName: customer.lastName,
                mobile: customer.mobile,
                gender: customer.gender
            }
        }
    })
});