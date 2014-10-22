define([
    'services/module',
    'pnotify'
], function (module) {

    module.service('notificationService', function () {
        this.success = function (content) {
            new PNotify({
                text: content,
                title: 'Sukces!',
                type: 'success'
            });
        };

        this.info = function (content) {
            new PNotify({
                text: content,
                title: 'Info!',
                type: 'info',
                addclass: 'stack-bottomright'
            });
        };

        this.error = function (content) {
            new PNotify({
                text: content,
                title: 'Błąd',
                type: 'error',
                addclass: 'stack-bottomright'
            });
        }
    })

});