package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class SignInScreen extends CommonScreen {

    public SignInScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "username_input")
    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    public WebElement emailField;

    @AndroidFindBy(id = "password_input")
    @iOSXCUITFindBy(className = "XCUIElementTypeSecureTextField")
    public WebElement passwordField;

    @AndroidFindBy(id = "button")
    @iOSXCUITFindBy(accessibility = "Here we go!")
    public WebElement hereWeGoButton;

    @iOSXCUITFindBy(accessibility = "icon_alert")
    public WebElement alertIcon;

    @AndroidFindBy(id = "error_message")
    public WebElement errorMessage;

    @AndroidFindBy(id = "feedback_ui_primary_action")
    @iOSXCUITFindBy(accessibility = "I am fit to play")
    public WebElement fitToPlayButton;
}