package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends CommonScreen {

    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "username_input")
    public WebElement emailField;

    @AndroidFindBy(id = "password_input")
    public WebElement passwordField;

    @AndroidFindBy(id = "button")
    public WebElement loginButton;
}