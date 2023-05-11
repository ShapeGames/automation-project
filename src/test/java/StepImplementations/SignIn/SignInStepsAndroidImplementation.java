package StepImplementations.SignIn;

import Config.ConstantConfig;
import Screens.CommonScreen;
import Screens.SignInScreen;
import Steps.SignInSteps;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SignInStepsAndroidImplementation extends CommonScreen implements SignInSteps {

    private final SignInScreen signInScreen;

    public SignInStepsAndroidImplementation(AppiumDriver driver) {
        super(driver);
        signInScreen = new SignInScreen(driver);
    }

    @Override
    public void inputEmail(String email) {
        globals.setUserEmail(email);
        waitUtils.waitForElementToBeVisible(signInScreen.emailField);
        signInScreen.emailField.findElement(By.className("android.widget.EditText")).sendKeys(email);
    }

    @Override
    public void inputPassword(String password) {
        waitUtils.waitForElementToBeVisible(signInScreen.passwordField);
        signInScreen.passwordField.findElement(By.className("android.widget.EditText")).sendKeys(password);
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
        waitUtils.waitForElementToBeVisible(signInScreen.errorMessage);
        return signInScreen.errorMessage.getText().equals(ConstantConfig.INVALID_LOGIN_ERROR_MESSAGE_ANDROID);
    }
}
