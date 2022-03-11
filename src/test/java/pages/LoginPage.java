package pages;

import utils.StrongerDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends StrongerDriver {

    String USERNAME_TEXT_BOX = "#txtUsername";
    String PASSWORD_TEXT_BOX = "#txtPassword";
    String LOGIN_BUTTON = "#btnLogin";
    String MESSAGE_SPAN_TAG = "#spanMessage";

    String USERNAME_EMPTY_MSG = "Username cannot be empty";
    String PASSWORD_EMPTY_MSG = "Password cannot be empty";
    String INVALID_CREDENTIALS_MSG = "Invalid credentials";

    public LoginPage logIn(String username, String password) {
        typeElement(USERNAME_TEXT_BOX, username);
        typeElement(PASSWORD_TEXT_BOX, password);
        clickElement(LOGIN_BUTTON);
        return this;
    }

    public void checkEmptyUsernameMessage() {
        assertEquals(getPage().innerText(MESSAGE_SPAN_TAG), USERNAME_EMPTY_MSG);
    }

    public void checkEmptyPasswordMessage() {
        assertEquals(getPage().innerText(MESSAGE_SPAN_TAG), PASSWORD_EMPTY_MSG);
    }

    public void checkInvalidCredentialsMessage() {
        assertEquals(getPage().innerText(MESSAGE_SPAN_TAG), INVALID_CREDENTIALS_MSG);
    }
}
