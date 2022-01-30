package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private static final String BASE_URN = "https://nonamecomp.lightning.force.com/lightning/page/home";

    public static final By HEADER = By.xpath("//h1[contains(.,'Home')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
    }

    @Override
    public HomePage openPage() {
        driver.get(BASE_URN);
        return this;
    }

}
