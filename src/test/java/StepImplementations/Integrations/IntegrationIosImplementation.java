package StepImplementations.Integrations;

import Screens.CommonScreen;
import Screens.IntegrationsScreen;
import Steps.IntegrationSteps;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class IntegrationIosImplementation extends CommonScreen implements IntegrationSteps {

    private final IntegrationsScreen integrationsScreen;

    public IntegrationIosImplementation(AppiumDriver driver) {
        super(driver);
        integrationsScreen = new IntegrationsScreen(driver);
    }

    @Override
    public void tapBetSafeOntario() {
        waitUtils.waitAndClickElement(integrationsScreen.betSafeOntario);
    }

    @Override
    public void openApp(String desiredApp) {
        waitUtils.waitForElementToBeVisible(By.className("XCUIElementTypeNavigationBar"));
        driver.findElement(new AppiumBy.ByAccessibilityId(desiredApp)).click();
    }
}