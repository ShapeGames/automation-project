package StepImplementations.CreateAccount;

import Config.ConstantConfig;
import Screens.CommonScreen;
import Screens.CreateYourAccountScreen;
import Steps.CreateYourAccountSteps;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreateYourAccountAndroidImplementation extends CommonScreen implements CreateYourAccountSteps {

    private final CreateYourAccountScreen createYourAccountScreen;

    public CreateYourAccountAndroidImplementation(AppiumDriver driver) {
        super(driver);
        createYourAccountScreen = new CreateYourAccountScreen(driver);
    }

    @Override
    public boolean isContinueButtonClickable() {
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
        waitUtils.waitForElementToBeVisible(createYourAccountScreen.responsibleGamingFooter);
        List<WebElement> footerElements = createYourAccountScreen.responsibleGamingFooter.findElements(By.className("android.widget.TextView"));

        WebElement desiredElement = footerElements.stream()
                .filter(element -> element.getText().equals("Call Connex Ontario"))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Couldn't find element with text: " + ConstantConfig.CALL_CONNEX_BUTTON));
        desiredElement.click();
    }

    @Override
    public boolean isNumberDialed(String number) {
        waitUtils.waitForElementToBeVisible(nativePhoneNumber);
        return nativePhoneNumber.getText().equals(ConstantConfig.CONNEX_PHONE_NUMBER);
    }
}