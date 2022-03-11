package pages;

import utils.StrongerDriver;

import static org.junit.jupiter.api.Assertions.*;

public class HomePage extends StrongerDriver {

    String MY_ACCOUNT_MENU = "#welcome";

    public void checkLoginUser() {
        assertTrue(getPage().isVisible(MY_ACCOUNT_MENU));
    }
}
