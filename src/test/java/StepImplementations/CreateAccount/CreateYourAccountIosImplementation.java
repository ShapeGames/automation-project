package StepImplementations.CreateAccount;

import Config.ConstantConfig;
import Screens.CommonScreen;
import Screens.CreateYourAccountScreen;
import Steps.CreateYourAccountSteps;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Level;
import org.openqa.selenium.By;
import utils.CustomLogger;

public class CreateYourAccountIosImplementation extends CommonScreen implements CreateYourAccountSteps {

    private final CreateYourAccountScreen createYourAccountScreen;

    public CreateYourAccountIosImplementation(AppiumDriver driver) {
        super(driver);
        createYourAccountScreen = new CreateYourAccountScreen(driver);
    }

    @Override
    public boolean isContinueButtonClickable() {
        CustomLogger.log.setLevel(Level.INFO);
        CustomLogger.log.info(ConstantConfig.LOG_SEPARATOR);
        return createYourAccountScreen.continueButton.getAttribute("clickable").equals("true");
    }

    @Override
    public void tapContinueButton() {
        waitUtils.waitAndClickElement(createYourAccountScreen.continueButton);
    }

    @Override
    public boolean isResponsibleGamingFooterDisplayed() {
        return createYourAccountScreen.responsibleGamingFooter.isDisplayed();
    }

    @Override
    public void tapCallConnexButton() {
        waitUtils.waitAndClickElement(createYourAccountScreen.callConnexButton);
    }

    @Override
    public boolean isNumberDialed(String number) {
        waitUtils.waitForElementToBeVisible(nativePhoneNumber);
        return nativePhoneNumber.findElement(By.className("XCUIElementTypeStaticText")).getText().contains(ConstantConfig.IOS_CONNEX_PHONE_NUMBER);
    }
}