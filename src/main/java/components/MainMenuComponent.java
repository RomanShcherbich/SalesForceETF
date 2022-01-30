package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenuComponent extends AbstractComponent {

    public static final By ACCOUNT_BUTTON = By.xpath("//one-app-nav-bar-item-root[@data-id='Account']");

    public MainMenuComponent(WebDriver driver) {
        super(driver);
    }

    public void openAccountPage() {
        driver.findElement(ACCOUNT_BUTTON).click();
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(ACCOUNT_BUTTON).isDisplayed();
    }

}
