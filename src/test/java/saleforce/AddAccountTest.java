package saleforce;

import model.Account;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddAccountTest extends BaseTest {

    Account account;

    @BeforeMethod
    public void initTestData() {
        initAccount();
    }

    @Test
    public void addNewAccountTest() {
        mainSteps.openSaleforceLoginPage();
        mainSteps.validLogin();
        mainSteps.openAccountPage();
        accountsSteps.createNewAccount(account);
    }

    private void initAccount() {
        account = new Account();
        account.setEmployees("20");
        account.setPhone("++375 29 233");
        account.setFax("++375 29 233");
        account.setWebsite("www.acc.com");
    }

}
