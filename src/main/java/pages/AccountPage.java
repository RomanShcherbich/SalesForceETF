package pages;

import components.MainMenuComponent;
import model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {

    public MainMenuComponent menu;

    private static final String BASE_URN = "https://nonamecomp.lightning.force.com/lightning/o/Account/list?filterName=Recent";

    private static final By HEADER = By.xpath("//h1[contains(.,'Account')]");
    private static final By NEW_BUTTON = By.cssSelector("[title='New']");

    public AccountPage(WebDriver driver) {
        super(driver);
        menu = new MainMenuComponent(driver);
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

    public void createNewAccount() {
        driver.findElement(NEW_BUTTON).click();
    }

    public boolean validateSelectedAccount(Account account) {
        boolean isEqual = account.getPhone().equals(""/* new AccountPageInput(driver,"Phone").getText()*/) &&
        account.getEmployees().equals(""/* new AccountPageInput(driver,"Phone").getText()*/);
        return isEqual;
    }

}
