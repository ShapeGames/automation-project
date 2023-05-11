package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CustomLogger;
import utils.Globals;
import utils.PropertyUtils;
import utils.WaitUtils;

import java.time.Duration;

public class CommonScreen {

    public final static int IMPLICIT_WAIT = PropertyUtils.getIntegerProperty("implicitWait", 30);
    public WaitUtils waitUtils;
    protected final AppiumDriver driver;
    public Globals globals;

    protected CommonScreen(AppiumDriver driver) {
        this.driver = driver;
        initElements();
        waitUtils = new WaitUtils();
        globals = new Globals();
    }

    @AndroidFindBy(id = "com.android.dialer:id/digits")
    @iOSXCUITFindBy(className = "XCUIElementTypeCell")
    public WebElement nativePhoneNumber;

    private void initElements() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(IMPLICIT_WAIT)), this);
    }

    public void handleIosLocationPopUp() {
        CustomLogger.log.setLevel(Level.INFO);
        if (isElementDisplayed(By.id("Allow While Using App"))) {
            CustomLogger.log.info("Location Pop Up displayed, accepting alert...");
            driver.findElement(By.id("Allow While Using App")).click();
        } else {
            CustomLogger.log.info("Location Pop Up is not displayed, skipping...");
        }
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}