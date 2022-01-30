package pages;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountModalPage extends AbstractComponent {

    private static final By HEADER = By.xpath("//h2[contains(.,'New Account')]");

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(HEADER).isDisplayed();
    }

}
