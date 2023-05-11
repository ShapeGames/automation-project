package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class WelcomeScreen extends CommonScreen {

    public WelcomeScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "feedback_ui_primary_action")
    @iOSXCUITFindBy(accessibility = "Create your account")
    public WebElement createAccountButton;

    @AndroidFindBy(id = "secondary_feedback_action_title")
    @iOSXCUITFindBy(accessibility = "Already a member?")
    public WebElement loginButton;
}