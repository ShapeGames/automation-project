package StepImplementations.Welcome;

import Screens.CommonScreen;
import Screens.WelcomeScreen;
import Steps.WelcomeSteps;
import io.appium.java_client.AppiumDriver;

public class WelcomeStepsIosImplementation extends CommonScreen implements WelcomeSteps {

    private final WelcomeScreen welcomeScreen;

    public WelcomeStepsIosImplementation(AppiumDriver driver) {
        super(driver);
        welcomeScreen = new WelcomeScreen(driver);
    }

    @Override
    public void tapCreateAccountButton() {
        handleIosLocationPopUp();
        waitUtils.waitAndClickElement(welcomeScreen.createAccountButton);
    }

    @Override
    public void tapLoginButton() {
        waitUtils.waitAndClickElement(welcomeScreen.loginButton);
    }
}