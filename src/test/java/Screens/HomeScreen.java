package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends CommonScreen {

    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "profileMenuButton")
    public WebElement profileButton;

    @AndroidFindBy(id = "profileMenuItemRecyclerView")
    @iOSXCUITFindBy(className = "XCUIElementTypePopover")
    public WebElement profileMenu;

    @AndroidFindBy(id = "playerName")
    public WebElement profileMenuUserName;
}