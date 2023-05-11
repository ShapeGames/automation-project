package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountDetailsScreen extends CommonScreen {

    public AccountDetailsScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "textInputEditText")
    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    public List<WebElement> personalDetailList;

    @AndroidFindBy(id = "tabPager")
    public WebElement personalDetailsContainer;

    @iOSXCUITFindBy(accessibility = "Personal details")
    public WebElement personalDetailsTitle;
}