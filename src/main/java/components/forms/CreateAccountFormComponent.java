package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccountFormComponent extends AbstractComponent {

    private static final By HEADER = By.xpath("//h2[contains(.,'New Account')]");
    private static final By SAVE_BUTTON = By.xpath("//button[contains(@class,'uiButton')]/span[text()='Save']");

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
        driver.findElement(SAVE_BUTTON).click();
    }

}
