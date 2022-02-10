package components.account;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountDetailsComponent extends AbstractComponent {

    public static final String ACCOUNTS_TEXT_DATA_FIELD =
            "//div[@class='slds-tabs_card']//span[text()='%s']/ancestor::" +
                    "div[@force-recordlayoutitem_recordlayoutitem and contains(@class,'label-inline')]" +
                    "//slot[@slot='outputField']";
    String label;
    By textFieldLocator;

    public AccountDetailsComponent(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.textFieldLocator = By.xpath(String.format(ACCOUNTS_TEXT_DATA_FIELD, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(textFieldLocator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public String getValue() {
        return driver.findElement(textFieldLocator).getText();
    }

}
