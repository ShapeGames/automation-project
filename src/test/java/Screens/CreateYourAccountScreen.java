package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class CreateYourAccountScreen extends CommonScreen {

    public CreateYourAccountScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "registrationButton")
    @iOSXCUITFindBy(accessibility = "Continue")
    public WebElement continueButton;

    @AndroidFindBy(id = "registration_rg_view")
    @iOSXCUITFindBy(accessibility = "Responsible Gaming")
    public WebElement responsibleGamingFooter;

    @iOSXCUITFindBy(accessibility = "Call Connex Ontario")
    public WebElement callConnexButton;
}