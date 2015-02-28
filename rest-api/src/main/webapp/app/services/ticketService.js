define([
    'services/module'
], function (module) {

    module.factory('ticketHttpClient', ['$resource', function ($resource) {

        return $resource(null, null, {
            findAll: {
                url: "rest/ticket/list",
                method: 'GET',
                isArray: true
            },
            create: {
                url: "rest/ticket/create",
                method: 'POST'
            },
            activate: {
                url: "rest/ticket/:sid/activate",
                method: 'GET'
            },
            deactivate: {
                url: "rest/ticket/:sid/deactivate",
                method: 'GET'
            },
            get: {
                url: "rest/ticket/:sid",
                method: 'GET'
            },
            update: {
                url: "rest/ticket/:sid",
                method: 'PUT'
            },
            delete: {
                url: "rest/ticket/:sid",
                method: 'DELETE'
            },
            findCustomerByCode: {
                url: "rest/ticket/:code/customer",
                method: 'GET'
            }
        });
    }])

    module.factory('ticketService', [function () {

        return {
            getTickets: function () {
                return [
                    {
                        type: "ADULT_1_ENTRANCE",
                        group: "PASS_ADULT",
                        price: "20"
                    },
                    {
                        type: "ADULT_4_ENTRANCES_MONTH",
                        group: "PASS_ADULT",
                        price: "70"
                    },
                    {
                        type: "ADULT_8_ENTRANCES_MONTH",
                        group: "PASS_ADULT",
                        price: "110"
                    },
                    {
                        type: "ADULT_OPEN_MONTH",
                        group: "PASS_ADULT",
                        price: "180"
                    },
                    {
                        type: "CHILD_1_ENTRANCE",
                        group: "PASS_CHILD",
                        price: "18"
                    },
                    {
                        type: "CHILD_4_ENTRANCES_MONTH",
                        group: "PASS_CHILD",
                        price: "65"
                    },
                    {
                        type: "CHILD_8_ENTRANCES_MONTH",
                        group: "PASS_CHILD",
                        price: "110"
                    },
                    {
                        type: "CHILD_OPEN_MONTH",
                        group: "PASS_CHILD",
                        price: "150"
                    },
                    {
                        type: "CHILD_FORMATION_MONTH",
                        group: "PASS_CHILD",
                        price: "100"
                    }
                ];
            }
        }
    }]);
});