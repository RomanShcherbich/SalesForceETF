package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccountFormComponent extends AbstractComponent {

    private static final By HEADER = By.xpath("//h2[contains(.,'New Account')]");
    private static final By SAVE_BUTTON =
            By.xpath("//div[contains(@class,'forceRecordEditActions')]//button[contains(@class,'uiButton')]/span[text()='Save']");

    public CreateAccountFormComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public void save() {
        WebElement button = driver.findElement(SAVE_BUTTON);
        System.out.printf("button is displayed: %s\n", button.isDisplayed());
        System.out.printf("button is enabled: %s\n", button.isEnabled());
        button.click();
//        Actions()
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(SAVE_BUTTON));
//        var buttonFooter = driver.findElement(By.cssSelector("div.forceRecordEditActions"));
//        System.out.printf("button is displayed: %s\n", buttonFooter.isDisplayed());
//        System.out.printf("button is enabled: %s\n", buttonFooter.isEnabled());
    }

}
