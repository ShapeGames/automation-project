package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class EmailPasswordScreen extends CommonScreen {

    public EmailPasswordScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "inputField1")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\"")
    public WebElement emailField;

    @AndroidFindBy(id = "inputField2")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeSecureTextField\"")
    public WebElement passwordField;

    @AndroidFindBy(id = "inputField3")
    @iOSXCUITFindBy(accessibility = "Repeat password")
    public WebElement repeatPasswordField;
}
