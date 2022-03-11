package testcases;

import org.junit.jupiter.api.*;
import pages.HomePage;
import pages.LoginPage;
import utils.Driver;

class LoginTest extends Driver {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test
    void login_test_successful() {
        loginPage.logIn("Admin", "admin123");
        homePage.checkLoginUser();
    }

    @Test
    void login_test_empty_username() {
        loginPage.logIn("", "").checkEmptyUsernameMessage();
    }

    @Test
    void login_test_empty_password() {
        loginPage.logIn("Admin", "").checkEmptyPasswordMessage();
    }

    @Test
    void login_test_invalid_credentials() {
        loginPage.logIn("admin", "123").checkInvalidCredentialsMessage();
    }
}
