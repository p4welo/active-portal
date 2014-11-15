define([
    'customers/module',
    'services/courseService'
], function (module) {

    module.controller("attendanceController", function ($scope, courseHttpClient) {
        $scope.day = 'PN';
        $scope.classes = courseHttpClient.findInProgress();

        $scope.presenceList = {
            lessons: [
                {
                    date: '19.10.2014',
                    presenceLock: true
                },
                {
                    date: '26.10.2014',
                    presenceLock: true
                },
                {
                    date: '05.11.2014',
                    presenceLock: true
                },
                {
                    date: '14.11.2014',
                    presenceLock: true
                },
                {
                    date: '21.11.2014',
                    presenceLock: true
                },
                {
                    date: '28.11.2014',
                    presenceLock: false
                }

            ],
            customerPresence: [
                {
                    customer: {
                        firstName: "Adam",
                        lastName: "Bednorz"
                    },
                    presence: {
                        '19.10.2014': true,
                        '26.10.2014': true,
                        '05.11.2014': true,
                        '14.11.2014': true,
                        '21.11.2014': true,
                        '28.11.2014': true
                    }
                },
                {
                    customer: {
                        firstName: "Radosław",
                        lastName: "Majdan"
                    },
                    presence: {
                        '19.10.2014': true,
                        '26.10.2014': true,
                        '05.11.2014': false,
                        '14.11.2014': false,
                        '21.11.2014': true,
                        '28.11.2014': true
                    }
                }
            ]
        }
    });
});