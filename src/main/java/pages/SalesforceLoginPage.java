package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SalesforceLoginPage extends BasePage {


    private static final String BASE_URN = "https://login.salesforce.com/";

    public static final By USERNAME = By.id("username");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("Login");

    public SalesforceLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    public void authentication(String username, String password) {
        driver.findElement(USERNAME).sendKeys(username);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URN);
        return this;
    }

}
