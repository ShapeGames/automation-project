package StepImplementations.EmailPassword;

import Screens.CommonScreen;
import Screens.EmailPasswordScreen;
import Steps.EmailPasswordSteps;
import io.appium.java_client.AppiumDriver;

public class EmailPasswordIosImplementation extends CommonScreen implements EmailPasswordSteps {

    private final EmailPasswordScreen emailPasswordScreen;

    public EmailPasswordIosImplementation(AppiumDriver driver) {
        super(driver);
        emailPasswordScreen = new EmailPasswordScreen(driver);
    }

    @Override
    public void fillEmail(String email) {
        waitUtils.waitForElementToBeVisible(emailPasswordScreen.emailField);
        emailPasswordScreen.emailField.sendKeys(email);
    }

    @Override
    public void fillPassword(String password) {
        waitUtils.waitForElementToBeVisible(emailPasswordScreen.passwordField);
        emailPasswordScreen.passwordField.sendKeys(password);
    }

    @Override
    public void fillRepeatPassword(String password) {

    }
}
