import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class HomePageTest extends AbstractTest {

    @Test
    @DisplayName("HomePage TEST 1")
    @Description("Next page button")
    @Severity(SeverityLevel.NORMAL)
    void home_page_1() {

        HomePage homePage = new HomePage(getWebDriver());
        homePage
                .sendKeysUsername()
                .sendKeysPassword()
                .clickLoginButton()
                .clickNextPageButton()
                .clickMYProfile()
                .clickLogout();

        Assertions.assertEquals("https://test-stand.gb.ru/logout", getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("HomePage TEST 2")
    @Description("Not my posts")
    @Severity(SeverityLevel.NORMAL)
    void home_page_2() {

        HomePage homePage = new HomePage(getWebDriver());
        homePage
                .sendKeysUsername()
                .sendKeysPassword()
                .clickLoginButton()
                .clickNotMyPostsOn()
                .clickMYProfile()
                .clickLogout();
        Assertions.assertEquals("https://test-stand.gb.ru/login", getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("HomePage TEST 3")
    @Description("Click on post")
    @Severity(SeverityLevel.NORMAL)
    void home_page_3() {

        HomePage homePage = new HomePage(getWebDriver());
        homePage
                .sendKeysUsername()
                .sendKeysPassword()
                .clickLoginButton()
                .clickNotMyPostsOn()
                .clickOnImage();
        Assertions.assertEquals("https://test-stand.gb.ru/?owner=notMe&sort=createdAt&order=ASC", getWebDriver().getCurrentUrl());
        String ExpectedTitle = "Most Reliable App & Cross Browser Testing Platform | browserstack";
        String ActualTitle = getWebDriver().getTitle();
        Assertions.assertNotEquals(ActualTitle, ExpectedTitle);

    }
}
