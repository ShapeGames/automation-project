package StepImplementations.TermsAndConditions;

import Screens.CommonScreen;
import Screens.TermsAndConditionsScreen;
import Steps.TermsAndConditionsSteps;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static org.testng.AssertJUnit.assertEquals;

public class TermsAndConditionsAndroidImplementation extends CommonScreen implements TermsAndConditionsSteps {

    private final TermsAndConditionsScreen termsAndConditionsScreen;

    public TermsAndConditionsAndroidImplementation(AppiumDriver driver) {
        super(driver);
        termsAndConditionsScreen = new TermsAndConditionsScreen(driver);
    }

    @Override
    public void checkAccurateInformationCheckBox() {
        waitUtils.waitAndClickElement(termsAndConditionsScreen.accurateInfoCheckBox);
        assertEquals("true", termsAndConditionsScreen.accurateInfoCheckBox.getAttribute("checked"));
    }

    @Override
    public void checkFitToPlayCheckBox() {
        waitUtils.waitAndClickElement(termsAndConditionsScreen.fitToPlayCheckBox);
        assertEquals("true", termsAndConditionsScreen.fitToPlayCheckBox.getAttribute("checked"));
    }

    @Override
    public void checkIsNotPoliticianCheckBox() {
        waitUtils.waitAndClickElement(termsAndConditionsScreen.isNotPoliticianCheckBox);
        assertEquals("true", termsAndConditionsScreen.isNotPoliticianCheckBox.getAttribute("checked"));
    }

    @Override
    public void checkThirdPartyCheckBox() {
        waitUtils.waitAndClickElement(termsAndConditionsScreen.isNotActingOnThirdPartyCheckBox);
        assertEquals("true", termsAndConditionsScreen.isNotActingOnThirdPartyCheckBox.getAttribute("checked"));
    }

    @Override
    public void checkCorrectAgeCheckBox() {
        waitUtils.waitAndClickElement(termsAndConditionsScreen.correctAgeBox);
        assertEquals("true", termsAndConditionsScreen.correctAgeBox.getAttribute("checked"));
    }

    @Override
    public void checkSubscriptionCheckBox() {
        waitUtils.waitAndClickElement(termsAndConditionsScreen.subscriptionBox);
        assertEquals("true", termsAndConditionsScreen.subscriptionBox.getAttribute("checked"));
    }

    @Override
    public void checkTermsAndConditionsToggle() {
        termsAndConditionsScreen.termsAndConditionsToggle.findElement(By.className("android.widget.Switch")).click();
    }

    @Override
    public void checkPrivacyNoticeToggle() {
        termsAndConditionsScreen.privacyNoticeToggle.findElement(By.className("android.widget.Switch")).click();
    }
}