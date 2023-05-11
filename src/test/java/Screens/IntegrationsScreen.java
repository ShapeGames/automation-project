package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class IntegrationsScreen extends CommonScreen {

    public IntegrationsScreen(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "Betsafe Ontario")
    public WebElement betSafeOntario;
}