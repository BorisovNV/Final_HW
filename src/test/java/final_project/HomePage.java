package final_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "/html/body/div/main/div/div/div/form/div[3]/button/span")
    private WebElement login_button;
    @FindBy(xpath = "//*[@id='app']/main/nav/a/span")
    private WebElement home_button;
    @FindBy(xpath = "//*[@id='login']/div[1]/label/input")
    private WebElement enter_username;
    @FindBy(xpath = "//*[@id='login']/div[2]/label/input")
    private WebElement enter_password;
    @FindBy(xpath = "//*[@id='app']/main/div/div[3]/div[2]/div/a[2]")
    private WebElement next_page;
    @FindBy(xpath = "/html/body/div[1]/main/div/div[2]/div[2]/div[2]/button/div[2]/div/div[3]")
    private WebElement not_my_posts_on;
    @FindBy(xpath = "//*[@id='app']/main/div/div[3]/div[1]/a[2]/img")
    private WebElement click_on_image;
    @FindBy(xpath = "//*[@id='app']/main/nav/ul/li[3]/a")
    private WebElement my_profile;
    @FindBy(xpath = "//*[@id='app']/main/nav/ul/li[3]/div/ul/li[3]/span[2]")
    private WebElement logout;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickLoginButton() {
        login_button.click();
        return this;
    }

    public HomePage clickHomeButton() {
        home_button.click();
        return this;
    }

    public HomePage sendKeysUsername() {
        enter_username.sendKeys("autotest");
        return this;
    }

    public HomePage sendKeysWrongUsername() {
        enter_username.sendKeys("autotest1rfg");
        return this;
    }

    public HomePage sendKeysWrongPassword() {
        enter_password.sendKeys("4967896ytg");
        return this;
    }

    public HomePage sendKeysShortestPassword() {
        enter_password.sendKeys("495");
        return this;
    }

    public HomePage sendKeysPassword() {
        enter_password.sendKeys("4956318935");
        return this;
    }

    public HomePage clickNextPageButton() {
        next_page.click();
        return this;
    }
    public HomePage clickNotMyPostsOn() {
        not_my_posts_on.click();
        return this;
    }
    public HomePage clickOnImage() {
        click_on_image.click();
        return this;
    }
    public HomePage clickMYProfile(){
        my_profile.click();
        return this;
    }
    public HomePage clickLogout(){
        logout.click();
        return this;
    }
}