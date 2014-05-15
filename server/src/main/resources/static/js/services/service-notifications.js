angular.module('PortalApp.services')

    .service('notificationService', function () {
        this.success = function (content) {
            $.pnotify({text: content, title: 'Sukces!', type: 'success', addclass: 'stack-bottomright'});
        };

        this.info = function (content) {
            $.pnotify({text: content, title: 'Info!', type: 'info', addclass: 'stack-bottomright'});
        };

        this.error = function (content) {
            $.pnotify({text: content, title: 'Błąd', type: 'error', addclass: 'stack-bottomright'});
        }
    });