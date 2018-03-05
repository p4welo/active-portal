'use strict';

describe('Login Page', function () {

    var LoginPage = require('./pages/login-page');
    var _ = require('lodash');

    var loginPage;
    beforeEach(function () {
        loginPage = new LoginPage();
    });

    it('should load login form', function () {
        expect(loginPage.isLoadedCorrectly()).toBeTruthy();
    });

    it('should perform correct login action', function () {
        loginPage.login("test", "test");
        browser.getCurrentUrl().then(function(url) {
            expect(_.contains(url, '#')).toBeTruthy();
        });
    });
});