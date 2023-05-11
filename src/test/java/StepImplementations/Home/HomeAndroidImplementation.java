package StepImplementations.Home;

import Screens.CommonScreen;
import Screens.HomeScreen;
import Steps.HomeSteps;
import io.appium.java_client.AppiumDriver;

public class HomeAndroidImplementation extends CommonScreen implements HomeSteps {

    private final HomeScreen homeScreen;

    public HomeAndroidImplementation(AppiumDriver driver) {
        super(driver);
        homeScreen = new HomeScreen(driver);
    }

    @Override
    public boolean isLoginButtonNotDisplayed() {
        return false;
    }
}