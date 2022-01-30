package steps;

import elements.DropDown;
import elements.Input;
import model.Account;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;
import pages.NewAccountModalPage;

public class AccountsSteps extends AbstractStep {


    public AccountsSteps(WebDriver driver) {
        super(driver);
    }

    public void createNewAccount(Account account) {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.createNewAccount();
        NewAccountModalPage newAccount = new NewAccountModalPage(driver);
        Assert.assertTrue(newAccount.isComponentDisplayed(),
                newAccount.getClass().getSimpleName().concat(" is not displayed: "));
        fillAccount(account);
        accountPage.validateSelectedAccount(account);
    }

    private void fillAccount(Account account) {
        new Input(driver, "Phone").write(account.getPhone());
//        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebsite());
        new Input(driver, "Employees").write(account.getEmployees());
        new DropDown(driver, "Type").select("Customer");
    }

}
