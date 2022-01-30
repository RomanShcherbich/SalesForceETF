package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public abstract class AbstractComponent {

    protected WebDriver driver;
    protected WebDriverWait explicitlyWait;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        this.explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void setExplicitlyWaitTimeout(int timeOutInSeconds) {
        this.explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
    }

    abstract public boolean isComponentDisplayed();

}
