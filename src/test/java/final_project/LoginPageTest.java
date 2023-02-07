package final_project;

import org.junit.jupiter.api.*;
import io.qameta.allure.*;



public class LoginPageTest extends AbstractTest {


    @Test
    @DisplayName("Login TEST 1")
    @Description("Positive")
    @Severity(SeverityLevel.CRITICAL)
    void user_login_1() {

        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage
                .sendKeysUsername()
                .sendKeysPassword()
                .clickLoginButton()
                .clickHomeButton()
                .clickMYProfile()
                .clickLogout();
        Assertions.assertEquals("https://test-stand.gb.ru/logout", getWebDriver().getCurrentUrl());

    }

    @Test
    @DisplayName("Login TEST 2")
    @Description("Negative")
    @Severity(SeverityLevel.CRITICAL)
    void user_login_2() {

        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage
                .sendKeysWrongUsername()
                .sendKeysWrongPassword()
                .clickLoginButton();
        Assertions.assertEquals("https://test-stand.gb.ru/login", getWebDriver().getCurrentUrl());

    }

    @Test
    @DisplayName("Login TEST 3")
    @Description("Negative")
    @Severity(SeverityLevel.CRITICAL)
    void user_login_3() {

        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage
                .clearUsername()
                .clearPassword()
                .sendKeysWrongUsername()
                .sendKeysShortestPassword()
                .clickLoginButton();
        Assertions.assertEquals("https://test-stand.gb.ru/login", getWebDriver().getCurrentUrl());

    }

}
