package elements;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DropDown extends AbstractComponent {

    private String DROPDOWN_PATTERN = "//span[contains(text(),'%s')]/ancestor::div[contains(@class,'uiInputSelect')]";
    private By DROPDOWN_TRIGGER = By.xpath(".//div[@class='uiPopupTrigger']");
    private String DROPDOWN_OPTION_LIST_PATTERN = "//div[@aria-labelledby='%s']";
    private String DROPDOWN_OPTION_PATTERN = "//a[contains(text(),'%s')]";
    private String label;

    public DropDown(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(dropDownlocator()).isDisplayed();
    }

    private By dropDownlocator() {
        return By.xpath(String.format(DROPDOWN_PATTERN, label));
    }

    private WebElement optionElement(String option) {
        WebElement dropDownClass = driver.findElement(dropDownlocator());
        WebElement dropDownClassTrigger = dropDownClass.findElement(DROPDOWN_TRIGGER);
        String dropDownId = dropDownClassTrigger.getAttribute("id");
        WebElement dropDownOptionList = dropDownClass.findElement(By.xpath(String.format(
                DROPDOWN_OPTION_LIST_PATTERN, dropDownId
        )));
        WebElement dropDownOption = dropDownOptionList.findElement(By.xpath(String.format(
                DROPDOWN_OPTION_PATTERN, option
        )));
        return dropDownOption;
    }

    public void select(String option) {
        driver.findElement(dropDownlocator()).click();
        WebElement byOption = optionElement(option);
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(byOption));
        byOption.click();
    }

}
