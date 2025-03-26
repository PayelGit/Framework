package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {



    WebDriver driver;


    By userName = By.id("textfield-login-user-username");
    By passWord = By.id("textfield-login-view-password");
    By loginBtn = By.id("btn_login_user_signin");
    By selectOrganization = By.id("buttons-select-user-organization-0");
    By selectOrganizationBtn = By.id("btn-get-started-organization");
    By appLogo = By.id("dashboard-header-text-name");
    By errorMsgForInvalCred = By.id("login-user-error-message");

    public LoginPageObjects(WebDriver driver)
    {
        this.driver = driver;
    }
    public void loginToTheApplication(String str, String str2)
    {
        driver.findElement(userName).sendKeys(str);
        driver.findElement(passWord).sendKeys(str2);
        driver.findElement(loginBtn).click();

    }

    public void selectOrganization()
    {
        driver.findElement(selectOrganization).click();
        driver.findElement(selectOrganizationBtn).click();
    }

    public WebElement verifyAppLogo()
    {
        return driver.findElement(appLogo);
    }

    public String verifyErrorMessage()
    {
        String str = driver.findElement(errorMsgForInvalCred).getText();
        return str;
    }
    public String getCurrentURL()
    {
        return driver.getCurrentUrl();
    }
}
