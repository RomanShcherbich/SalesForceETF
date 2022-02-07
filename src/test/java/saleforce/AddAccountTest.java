package saleforce;

import org.testng.annotations.Test;

public class AddAccountTest extends BaseTest {

    @Test
    public void addNewAccountTest() {
        mainSteps
            .openSaleforceLoginPage()
            .loginWithValidCreds()
            .openAccountPage()
            .createNewAccount();
    }


}
