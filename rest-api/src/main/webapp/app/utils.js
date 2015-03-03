define([

], function () {
    return {
        resolveObjectStateCss: function (obj) {
            return {'label-success': obj.objectState == 'ACTIVE', 'label-danger': obj.objectState == 'INACTIVE'};
        }
    };
});