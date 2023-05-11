package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Level;
import org.openqa.selenium.WebElement;
import utils.CustomLogger;

public class ProfileScreen extends CommonScreen {

    public ProfileScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "buttonDone")
    public WebElement saveButton;

    @AndroidFindBy(id = "emailEditText")
    public WebElement email;

    @AndroidFindBy(id = "phoneNumberEditText")
    public WebElement phone;

    public boolean isUserEmailDisplayed(String expectedEmail) {
        waitUtils.waitForElementToBeVisible(email);
        return email.getText().equals(expectedEmail);
    }

    public boolean isUserPhoneDisplayed(String expectedPhone) {
        waitUtils.waitForElementToBeVisible(phone);
        CustomLogger.log.setLevel(Level.DEBUG);
        CustomLogger.log.debug("Expected phone number -> " + expectedPhone);
        CustomLogger.log.debug("Actual phone number -> " + phone.getText());
        return phone.getText().equals(expectedPhone);
    }
}