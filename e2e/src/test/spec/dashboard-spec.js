'use strict';

describe('Dashboard Page', function () {

    var LoginPage = require('./pages/login-page');
    var DashboardPage = require('./pages/dashboard-page');

    var loginPage, dashboardPage;
    beforeEach(function () {
        loginPage = new LoginPage();
        loginPage.login("test", "test");
        dashboardPage = new DashboardPage();
    });

    it('should load dashboard page', function () {
        expect(dashboardPage.isLoadedCorrectly()).toBeTruthy();
    });


    afterEach(function () {
        loginPage.logout();
    })
});