package StepImplementations.SignIn;

import Config.ConstantConfig;
import Screens.CommonScreen;
import Screens.SignInScreen;
import Steps.SignInSteps;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import utils.Globals;
import utils.UserUtils;

public class SignInStepsiOSImplementation extends CommonScreen implements SignInSteps {

    private final SignInScreen signInScreen;
    private final UserUtils userUtils;
    public Globals globals;

    public SignInStepsiOSImplementation(AppiumDriver driver) {
        super(driver);
        signInScreen = new SignInScreen(driver);
        userUtils = new UserUtils();
        globals = new Globals();
    }

    @Override
    public void inputEmail(String email) {
        globals.setUserEmail(email);
        waitUtils.waitForElementToBeVisible(signInScreen.emailField);
        signInScreen.emailField.sendKeys(email);
    }

    @Override
    public void inputPassword(String password) {
        signInScreen.passwordField.sendKeys(password);
    }

    @Override
    public void tapLoginButton() {
        waitUtils.waitAndClickElement(signInScreen.hereWeGoButton);
    }

    @Override
    public void tapFitToPlay() {
        waitUtils.waitAndClickElement(signInScreen.fitToPlayButton);
    }

    @Override
    public boolean isCredentialsErrorDisplayed() {
        waitUtils.waitForElementToBeVisible(signInScreen.alertIcon);
        return driver.findElement(new AppiumBy.ByAccessibilityId(ConstantConfig.IOS_INVALID_LOGIN_ERROR_MESSAGE)).isDisplayed();
    }
}