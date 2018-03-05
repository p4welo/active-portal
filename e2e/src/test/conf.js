exports.config = {
    seleniumAddress: 'http://localhost:4444/wd/hub',
    specs: ['spec/**/*spec.js'],
    //baseUrl: 'http://localhost:8080/ap/app/',
    baseUrl: 'http://91.218.78.136/ap/app/',
    jasmineNodeOpts: {
        print: function () {
        },
        showColors: true,
        defaultTimeoutInterval: 30000,
        realtimeFailure: true
    },
    onPrepare: function () {
        var SpecReporter = require('jasmine-spec-reporter');
        jasmine.getEnv().addReporter(new SpecReporter({displayStacktrace: true}));
    }
};