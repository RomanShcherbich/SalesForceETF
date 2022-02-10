package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {

    private static final String BASE_URN = "https://nonamecomp.lightning.force.com/lightning/o/Account/list?filterName=Recent";

    private static final By HEADER = By.xpath("//h1[contains(.,'Account')]");
    private static final By NEW_BUTTON = By.cssSelector("[title='New']");
    private static final By DETAILS_BUTTON = By.xpath("//a[@data-label='Details']");
    private static final By DETAILS_TAB_PANEL = By.xpath("//div[@force-recordlayoutitem_recordlayoutitem and contains(@class,'label-inline')]//slot[@slot='outputField']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URN);
        return this;
    }

    public void openNewAccountForm() {
        driver.findElement(NEW_BUTTON).click();
    }

    public void openDetails() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_BUTTON));
        By by = DETAILS_BUTTON;
        driver.findElement(by).click();
        explicitlyWait.until(ExpectedConditions.attributeContains(DETAILS_BUTTON, "aria-selected", "true"));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_TAB_PANEL));
    }

}