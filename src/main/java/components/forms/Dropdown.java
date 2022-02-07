package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Dropdown extends AbstractComponent {

    private static final String DROPDOWN_LOCATOR_PATTERN =
            "//span[@id and contains(.,'%s')]/ancestor::div[contains(@class,'uiInput')]//div[@data-aura-class='uiPopupTrigger']";
    private String label;
    private By dropdownLocator;
    private static final String OPTION_LIST_PATTERN =
            "//div[@aria-labelledby='%s']//li[contains(.,'%s')]";


    public Dropdown(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.dropdownLocator = By.xpath(String.format(DROPDOWN_LOCATOR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(dropdownLocator).isDisplayed();
    }

    private void openOptionsPopup() {
        driver.findElement(dropdownLocator).click();
    }

    private String getLabelId() {
        return driver.findElement(dropdownLocator).getAttribute("id");
    }

    public void selectOption(String optionName) {
        openOptionsPopup();
        By optionLocator = By.xpath(String.format(OPTION_LIST_PATTERN, getLabelId(), optionName));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        driver.findElement(optionLocator).click();
        explicitlyWait.until(ExpectedConditions.textToBePresentInElementLocated(dropdownLocator, optionName));
    }

}
