package steps;

import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.SalesforceLoginPage;

public class MainSteps extends AbstractStep {

    private SalesforceLoginPage loginPage;
    private HomePage homePage;
    private AccountPage accountPage;
    private static final String VALID_LOGIN = System.getProperty("login");
    private static final String VALID_PASSWORD = System.getProperty("password");

    public MainSteps(WebDriver driver) {
        super(driver);
    }

    public void openSaleforceLoginPage() {
        loginPage = new SalesforceLoginPage(driver);
        loginPage.setExplicitlyWaitTimeout(5);
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
    }

    public void validLogin() {
        loginPage.authentication(VALID_LOGIN, VALID_PASSWORD);
        homePage = new HomePage(driver);
        validatePageIsLoaded(homePage);
    }

    public void openAccountPage() {
        homePage.menu.openAccountPage();
        accountPage = new AccountPage(driver);
        validatePageIsLoaded(accountPage);
    }

}
