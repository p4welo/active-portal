'use strict';

var LoginPage = function () {
    browser.ignoreSynchronization = true;
    browser.get('');

    this.loginInput = element(by.id('login'));
    this.passwordInput = element(by.id('password'));
    this.loginButton = element(by.css('button[type="submit"]'));

    this.login = function (login, password) {
        this.loginInput.sendKeys(login);
        this.passwordInput.sendKeys(password);
        this.loginButton.click();
        browser.waitForAngular();
    };

    this.logout = function () {
        browser.ignoreSynchronization = true;
        browser.get("logout");

    };

    this.isLoadedCorrectly = function () {
        return this.loginInput.isPresent() &&
                this.passwordInput.isPresent() &&
                this.loginButton.isPresent();
    };
};
module.exports = LoginPage;