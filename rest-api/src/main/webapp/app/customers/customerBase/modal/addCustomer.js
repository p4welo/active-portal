define([
    'schedule/module',
    'services/customerService',
    'services/courseService'
], function (module) {

    module.controller('addCustomerController', function ($scope, customerHttpClient, courseHttpClient, $modalInstance) {
        $scope.page = 0;
        $scope.customer = {};
        $scope.courses = null;
        $scope.availableCourses = null;
        $scope.day = 'PN';

//        CUSTOMER CREATION - PAGE 0
        $scope.isValidCustomer = function (customer) {
            return customer != null && customer.firstName != null && customer.lastName != null && customer.gender != null && customer.mobile != null;
        }

        $scope.cancel = function () {
            $modalInstance.dismiss();
        }
        $scope.nextPage = function () {
            $scope.page = 1;
            $scope.courses = [];
            $scope.availableCourses = courseHttpClient.findAll();
        }

//        COURSE SUBSCRIPTION - PAGE 1
        $scope.selectCourse = function (course) {
            var idx = $scope.courses.indexOf(course);
            if (idx == -1) {
                $scope.courses.push(course);
            }
            else {
                $scope.courses.splice(idx, 1);
            }
        }
        $scope.setDay = function (day) {
            $scope.day = day;
        }
        $scope.isSelected = function (course) {
            return $scope.courses.indexOf(course) > -1;
        }
        $scope.create = function (customer, courses) {
            customerHttpClient.create({customer: customer, courses: courses}).$promise.then(
                function () {
                    $modalInstance.close();
                });
        }
        $scope.previousPage = function () {
            $scope.page = 0;
        }
    });
});