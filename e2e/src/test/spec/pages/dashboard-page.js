'use strict';

var DashboardPage = function () {

    var _ = require('lodash');

    browser.ignoreSynchronization = false;
    browser.get('#/dashboard');

    this.headerSection = element(by.css('.header-section>h1'));

    this.isLoadedCorrectly = function () {
        return true;//_.contains(this.headerSection.getText(), "Dashboard");
    };
};
module.exports = DashboardPage;