package components.buttons.menu;

import org.openqa.selenium.WebDriver;

public class AccountsButton extends MenuButton {

    public static final String ACCOUNTS_BUTTON_LABEL = "Accounts";

    public AccountsButton(WebDriver driver) {
        super(driver, ACCOUNTS_BUTTON_LABEL);
    }

}
