package final_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{

    @FindBy(xpath = "/html/body/div/main/div/div/div/form/div[3]/button/span")
    private WebElement login_button;
    @FindBy(xpath = "//*[@id='app']/main/nav/a/span")
    private WebElement home_button;
    @FindBy(xpath = "//*[@id='login']/div[1]/label/input")
    private WebElement enter_username;
    @FindBy(xpath = "//*[@id='login']/div[2]/label/input")
    private WebElement enter_password;
    @FindBy(xpath = "//*[@id='app']/main/nav/ul/li[3]/a")
    private WebElement my_profile;
    @FindBy(xpath = "//*[@id='app']/main/nav/ul/li[3]/div/ul/li[3]/span[2]")
    private WebElement logout;
    @FindBy(xpath = "//*[@id='login']/div[1]/label/input")
    private WebElement clear_username;
    @FindBy(xpath = "//*[@id='login']/div[2]/label/input")
    private WebElement clear_password;



    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage clickLoginButton(){
        login_button.click();
        return this;
    }
    public LoginPage clickHomeButton(){
        home_button.click();
        return this;
    }
    public LoginPage sendKeysUsername(){
        enter_username.sendKeys("autotest");
        return this;
    }
    public LoginPage sendKeysWrongUsername(){
        enter_username.sendKeys("autotest1rfg");
        return this;
    }
    public LoginPage sendKeysWrongPassword(){
        enter_password.sendKeys("4967896ytg");
        return this;
    }
    public LoginPage sendKeysShortestPassword(){
        enter_password.sendKeys("495");
        return this;
    }
    public LoginPage sendKeysPassword(){
        enter_password.sendKeys("4956318935");
        return this;
    }
    public LoginPage clickMYProfile(){
        my_profile.click();
        return this;
    }
    public LoginPage clickLogout(){
        logout.click();
        return this;
    }
    public LoginPage clearUsername(){
        clear_username.clear();
        return this;
    }
    public LoginPage clearPassword(){
        clear_password.clear();
        return this;
    }

}