package StepImplementations.EmailPassword;

import Screens.CommonScreen;
import Screens.EmailPasswordScreen;
import Steps.EmailPasswordSteps;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class EmailPasswordAndroidImplementation extends CommonScreen implements EmailPasswordSteps {

    private final EmailPasswordScreen emailPasswordScreen;

    public EmailPasswordAndroidImplementation(AppiumDriver driver) {
        super(driver);
        emailPasswordScreen = new EmailPasswordScreen(driver);
    }

    @Override
    public void fillEmail(String email) {
        waitUtils.waitForElementToBeVisible(emailPasswordScreen.emailField);
        emailPasswordScreen.emailField.findElement(By.id("textInputEditText")).sendKeys(email);
    }

    @Override
    public void fillPassword(String password) {
        emailPasswordScreen.passwordField.findElement(By.id("textInputEditText")).sendKeys(password);
    }

    @Override
    public void fillRepeatPassword(String password) {
        emailPasswordScreen.repeatPasswordField.findElement(By.id("textInputEditText")).sendKeys(password);
    }
}
