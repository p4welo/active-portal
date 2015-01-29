define([
    'services/module',
    'pnotify'
], function (module) {

    module.service('notificationService', function () {
        var opts = {
            addclass: "stack-bottomright",
            stack: {dir1: "up", dir2: "left"},
            styling: "fontawesome"
        }
        this.success = function (content) {
            opts.text = content;
            opts.title = 'Sukces!';
            opts.type = 'success';

            new PNotify(opts);
        };

        this.info = function (content) {
            opts.text = content;
            opts.title = 'Info!';
            opts.type = 'info';

            new PNotify(opts);
        };

        this.error = function (content) {
            opts.text = content;
            opts.title = 'Błąd!';
            opts.type = 'error';

            new PNotify(opts);
        }
    })

});