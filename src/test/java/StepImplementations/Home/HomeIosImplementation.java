package StepImplementations.Home;

import Screens.CommonScreen;
import Screens.HomeScreen;
import Steps.HomeSteps;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeIosImplementation extends CommonScreen implements HomeSteps {

    private final HomeScreen homeScreen;

    public HomeIosImplementation(AppiumDriver driver) {
        super(driver);
        homeScreen = new HomeScreen(driver);
    }

    @Override
    public boolean isLoginButtonNotDisplayed() {
        waitUtils.waitForElementToBeVisible(AppiumBy.iOSNsPredicateString("label == \"Betsafe Ontario\""));
        return !isElementDisplayed(new AppiumBy.ByAccessibilityId("Login"));
    }
}