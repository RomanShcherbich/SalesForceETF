package pages;

import components.AbstractComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends AbstractComponent {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    abstract public void waitPageLoaded();

    abstract public BasePage openPage();

    @Override
    public boolean isComponentDisplayed() {
        try {
            waitPageLoaded();
        } catch (TimeoutException ex) {
            System.out.println("EXCEPTION HAS BEEN CAUGHT");
            return false;
        }
        return true;
    }

    public boolean isPageLoaded() {
        return isComponentDisplayed();
    }

    public boolean waitForPageLoaded() {
        String state = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString();
        System.out.println("JAVA SCRIPT WAITER = ".concat(state));
        return state.equals("complete");
    }

}
