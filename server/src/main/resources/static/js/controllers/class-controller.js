angular.module('PortalApp.controllers')

    .controller('classController', function ($scope, styleFactory, instructorFactory, roomFactory, classService, classFactory, notificationService) {

        $scope.day = '';
        $scope.classes = classFactory.find();
        $scope.styles = styleFactory.find();
        $scope.instructors = instructorFactory.find();
        $scope.rooms = roomFactory.find();
        $scope.days = [
            {
                code: "PN",
                name: "Poniedziałek"
            },
            {
                code: "WT",
                name: "Wtorek"
            },
            {
                code: "SR",
                name: "Sroda"
            },
            {
                code: "CZ",
                name: "Czwartek"
            },
            {
                code: "PT",
                name: "Piątek"
            },
            {
                code: "SB",
                name: "Sobota"
            },
            {
                code: "ND",
                name: "Niedziela"
            }
        ];
        $scope.levels = [
            {
                code: "OPEN",
                name: "Otwarty"
            },
            {
                code: "BEGINNER",
                name: "Początkujący"
            },
            {
                code: "INTERMEDIATE",
                name: "Sredniozaawansowany"
            },
            {
                code: "ADVANCED",
                name: "Zaawansowany"
            }
        ];
        $scope.types = [
            {
                code: "registration",
                name: "Grupa na zapisy"
            },
            {
                code: "open",
                name: "Można dołączyć"
            },
            {
                code: "closed",
                name: "Nie można dołączyć"
            }
        ];

        $scope.add = function () {
            $scope.new = {};
            showModal("#add-class-modal")
        };

        $scope.edit = function (danceClass) {
            $scope.selected = {};
            classService.copyProperties(danceClass, $scope.selected);

            if (!danceClass.canJoin && danceClass.canRegister && !danceClass.inProgress) {
                $scope.selected.type = 'registration';
            }
            else if (danceClass.canJoin && !danceClass.canRegister && danceClass.inProgress) {
                $scope.selected.type = 'open';
            }
            else if (!danceClass.canJoin && !danceClass.canRegister && danceClass.inProgress) {
                $scope.selected.type = 'closed';
            }
            showModal("#edit-class-modal");
        };

        $scope.update = function (danceClass) {

            delete danceClass.type;
            classFactory.update({sid: danceClass.sid}, danceClass, function () {

                $scope.classes = classFactory.find();
                hideModal("#edit-class-modal");
                notificationService.success("Pomyślnie zapisano");

            });
        };

        $scope.create = function (danceClass) {

            if (danceClass.type == 'registration') {
                danceClass.canJoin = false;
                danceClass.canRegister = true;
                danceClass.inProgress = false;

            } else if (danceClass.type == 'open') {
                danceClass.canJoin = true;
                danceClass.canRegister = false;
                danceClass.inProgress = true;

            } else if (danceClass.type == 'closed') {
                danceClass.canJoin = false;
                danceClass.canRegister = false;
                danceClass.inProgress = true;
            }
            delete danceClass['type'];
            classFactory.create(danceClass, function () {
                $scope.classes = classFactory.find();
                hideModal("#add-class-modal");
                notificationService.success("Pomyślnie zapisano");
            });
        };
    });