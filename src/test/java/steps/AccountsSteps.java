package steps;

import components.forms.CreateAccountFormComponent;
import components.forms.Dropdown;
import components.forms.Input;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;

public class AccountsSteps extends AbstractStep {

    private AccountPage accountPage;

    public AccountsSteps(WebDriver driver) {
        super(driver);
    }

    public void createNewAccount() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.openNewAccountForm();
        CreateAccountFormComponent form = new CreateAccountFormComponent(driver);
        Assert.assertTrue(
            form.isComponentDisplayed(),
            form.getClass().getSimpleName().concat(" not displayed")
        );
        Input accountNameInput = new Input(driver, "Account Name");
        accountNameInput.insert("USERNAME");
        Input phoneInput = new Input(driver, "Phone");
        phoneInput.insert("+37529123123");
        new Input(driver, "Website").insert("teachmeskills.by");
        new Input(driver, "Employees").insert("10");
        new Dropdown(driver, "Type").selectOption("Customer");
        new Dropdown(driver, "Industry").selectOption("Banking");
        form.save();
        validatePageIsLoaded(accountPage);
    }

}
