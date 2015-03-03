define([
    'schedule/module',
    'services/customerService',
    'services/courseService'
], function (module) {

    module.controller('addCustomerController', ['$scope', 'customerHttpClient', 'courseHttpClient', '$modalInstance', function ($scope, customerHttpClient, courseHttpClient, $modalInstance) {
        $scope.page = 0;
        $scope.customer = {};
        $scope.courses = null;
        $scope.availableCourses = null;
        $scope.day = 'PN';

//        CUSTOMER CREATION - PAGE 0
        $scope.isValidCustomer = function (customer) {
            return customer !== undefined &&
                customer.firstName !== undefined &&
                customer.lastName !== undefined &&
                customer.gender !== undefined &&
                customer.mobile !== undefined;
        };

        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
        $scope.nextPage = function () {
            customerHttpClient.findSimilar($scope.customer).$promise.then(
                function (result) {
                    console.table(result);

                    $scope.page = 1;
                    $scope.courses = [];
                    $scope.availableCourses = courseHttpClient.findAll();
                }
            );
        };

//        COURSE SUBSCRIPTION - PAGE 1
        $scope.selectCourse = function (course) {
            var idx = $scope.courses.indexOf(course);
            if (idx == -1) {
                $scope.courses.push(course);
            }
            else {
                $scope.courses.splice(idx, 1);
            }
        };
        $scope.setDay = function (day) {
            $scope.day = day;
        };
        $scope.isSelected = function (course) {
            return $scope.courses.indexOf(course) > -1;
        };
        $scope.create = function (customer, courses) {
            customerHttpClient.create({customer: customer, courses: courses}).$promise.then(
                function () {
                    $modalInstance.close();
                });
        };
        $scope.previousPage = function () {
            $scope.page = 0;
        };
    }]);
});