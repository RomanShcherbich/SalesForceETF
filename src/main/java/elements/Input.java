package elements;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input extends AbstractComponent {

    private static final String INPUT_PATTERN = "//label[contains(.,'%s')]/ancestor::div[contains(@class,'uiInput')]/input";
    private String label;

    public Input(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(locator()).isDisplayed();
    }

    private By locator() {
        return By.xpath(String.format(INPUT_PATTERN, label));
    }

    public void write(String text) {
        driver.findElement(locator()).sendKeys(text);
    }

}
