package steps;

import components.account.AccountDetailsComponent;
import components.forms.CreateAccountFormComponent;
import components.forms.Dropdown;
import components.forms.Input;
import model.AccountModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;

public class AccountsSteps extends AbstractStep {

    private AccountPage accountPage;

    public AccountsSteps(WebDriver driver) {
        super(driver);
    }

    public AccountsSteps createNewAccount_DEL() {
        accountPage = new AccountPage(driver);
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
        return this;
    }

    public void validateAccountCreated_DEL() {
        accountPage.openDetails();
        Assert.assertEquals(
                new AccountDetailsComponent(driver, "Account Name").getValue(),
                "USERNAME"
        );
        Assert.assertEquals(
                new AccountDetailsComponent(driver, "Phone").getValue(),
                "+37529123123"
        );
        Assert.assertEquals(
                new AccountDetailsComponent(driver, "Website").getValue(),
                "teachmeskills.by"
        );
        Assert.assertEquals(
                new AccountDetailsComponent(driver, "Employees").getValue(),
                "10"
        );
        Assert.assertEquals(
                new AccountDetailsComponent(driver, "Type").getValue(),
                "Customer"
        );
        Assert.assertEquals(
                new AccountDetailsComponent(driver, "Industry").getValue(),
                "Banking"
        );
    }

    public AccountsSteps createNewAccount(AccountModel accountModel) {
        accountPage = new AccountPage(driver);
        accountPage.openNewAccountForm();
        CreateAccountFormComponent form = new CreateAccountFormComponent(driver);
        Assert.assertTrue(
            form.isComponentDisplayed(),
            form.getClass().getSimpleName().concat(" not displayed")
        );
        fillAccountForm(accountModel);
        form.save();
        validatePageIsLoaded(accountPage);
        return this;
    }

    private void fillAccountForm(AccountModel accountModel) {
        Input accountNameInput = new Input(driver, "Account Name");
        accountNameInput.insert(accountModel.getAccountName());
        Input phoneInput = new Input(driver, "Phone");
        phoneInput.insert(accountModel.getPhone());
        new Input(driver, "Website").insert(accountModel.getWebsite());
        new Input(driver, "Employees").insert(String.valueOf(accountModel.getEmployees()));
        new Dropdown(driver, "Type").selectOption(accountModel.getType());
        new Dropdown(driver, "Industry").selectOption(accountModel.getIndustry());
    }

    public void validateAccountCreated(AccountModel expectedModel) {
        accountPage.openDetails();
        AccountModel actualModel = getActualAccount();
        Assert.assertEquals(
                actualModel,
                expectedModel,
                String.format("Account is not valid: %s", actualModel)
        );
    }

    private AccountModel getActualAccount( ) {
        AccountModel actualModel = new AccountModel();
        actualModel.setAccountName(new AccountDetailsComponent(driver, "Account Name").getValue());
        actualModel.setPhone(new AccountDetailsComponent(driver, "Phone").getValue());
        actualModel.setWebsite(new AccountDetailsComponent(driver, "Website").getValue());
        actualModel.setEmployees(Integer.parseInt(new AccountDetailsComponent(driver, "Employees").getValue()));
        actualModel.setType(new AccountDetailsComponent(driver, "Type").getValue());
        actualModel.setIndustry(new AccountDetailsComponent(driver, "Industry").getValue());
        return actualModel;
    }

}
