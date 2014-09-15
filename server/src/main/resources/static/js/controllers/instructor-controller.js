angular.module('PortalApp.controllers')

    .controller('instructorController', function ($scope, instructorFactory, instructorService, notificationService) {

        $scope.instructors = instructorFactory.find();

        $scope.add = function() {
            $scope.new = {};
            showModal("#add-instructor-modal")
        };

        $scope.create = function (instructor) {

            instructorFactory.create(instructor, function () {
                $scope.instructors = instructorFactory.find();
                hideModal("#add-instructor-modal");
                notificationService.success("Pomyślnie zapisano");
            });
        };
    });