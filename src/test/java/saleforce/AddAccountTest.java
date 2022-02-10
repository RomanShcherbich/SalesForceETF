package saleforce;

import builders.AccountBuilder;
import model.AccountModel;
import org.testng.annotations.Test;
import utils.AccountModelUtils;

public class AddAccountTest extends BaseTest {

    AccountModel testAccount = AccountModelUtils.getDefaultAccountModel();
    AccountModel testAccount2 = AccountBuilder
                                    .defaultAccount()
                                    .setPhone("232")
                                    .build();

    @Test
    public void addNewAccountTest() {
        mainSteps
                .openSaleforceLoginPage()
                .loginWithValidCreds()
                .openAccountPage()
                .createNewAccount(testAccount)
                .validateAccountCreated(testAccount);
    }


    private AccountModel buildTestAccount() {
        return AccountBuilder.newValues()
                .setAccountName("USERNAME")
                .setPhone("+37529123123")
                .setWebsite("teachmeskills.by")
                .setEmployees(10)
                .setType("Customer")
                .setIndustry("Banking")
                .build();
    }


    private AccountModel getTestAccount() {
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName("USERNAME");
        accountModel.setPhone("+37529123123");
        accountModel.setWebsite("teachmeskills.by");
        accountModel.setEmployees(10);
        accountModel.setType("Customer");
        accountModel.setIndustry("Banking");
        return accountModel;
    }


}
