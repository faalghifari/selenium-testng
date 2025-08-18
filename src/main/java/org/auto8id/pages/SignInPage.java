package org.auto8id.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object encapsulates the Sign-in page.
 */
public class SignInPage extends BasePage {
    protected WebDriver driver;

    // <input id="user_name">
    @FindBy(id = "user-name")
    private WebElement usernameBy;
    // <input id="password">
    @FindBy(id = "user-name")
    private WebElement passwordBy;
    // <input id="login-button"">
    @FindBy(id = "login-button")
    private WebElement signinBy;


    public SignInPage(WebDriver driver){
        super(driver);
    }

    /**
     * Login as valid user
     *
     * @param userName string
     * @param password string
     */
    public void loginValidUser(String userName, String password) {
        type(usernameBy, userName);
        type(passwordBy,password);
        click(signinBy);
    }
}
