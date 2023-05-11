package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class TermsAndConditionsScreen extends CommonScreen {

    public TermsAndConditionsScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "accurateInfoCheckBox")
    public WebElement accurateInfoCheckBox;

    @AndroidFindBy(id = "fitToPlayCheckBox")
    public WebElement fitToPlayCheckBox;

    @AndroidFindBy(id = "isNotPoliticianCheckBox")
    public WebElement isNotPoliticianCheckBox;

    @AndroidFindBy(id = "isNotActingOnThirdPartyCheckBox")
    public WebElement isNotActingOnThirdPartyCheckBox;

    @AndroidFindBy(id = "correctAgeBox")
    public WebElement correctAgeBox;

    @AndroidFindBy(id = "subscriptionBox")
    public WebElement subscriptionBox;

    @AndroidFindBy(id = "termsAndConditions")
    public WebElement termsAndConditionsToggle;

    @AndroidFindBy(id = "privacyNotice")
    public WebElement privacyNoticeToggle;
}
