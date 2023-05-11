package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FlowScreen extends CommonScreen {
    public FlowScreen(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "Log In")
    public WebElement logIn;

    @iOSXCUITFindBy(accessibility = "Log Out")
    public WebElement logOut;

    @iOSXCUITFindBy(accessibility = "Other Actions")
    public WebElement otherActions;

    @iOSXCUITFindBy(accessibility = "Show Account Details")
    public WebElement showAccountDetails;

    @iOSXCUITFindBy(className = "XCUIElementTypeNavigationBar")
    public WebElement navigationBar;

    @iOSXCUITFindBy(className = "XCUIElementTypeScrollView")
    public List<WebElement> scrollViews;
}