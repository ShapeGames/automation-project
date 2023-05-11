package StepImplementations.Flow;

import Screens.CommonScreen;
import Screens.FlowScreen;
import Steps.FlowSteps;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FlowIosImplementation extends CommonScreen implements FlowSteps {

    private final FlowScreen flowScreen;

    public FlowIosImplementation(AppiumDriver driver) {
        super(driver);
        flowScreen = new FlowScreen(driver);
    }

    @Override
    public void tapLoginFlow() {
        waitUtils.waitAndClickElement(flowScreen.logIn);
    }

    @Override
    public void tapOtherActions() {
        waitUtils.waitAndClickElement(flowScreen.otherActions);
    }

    @Override
    public void tapShowAccountDetails() {
        waitUtils.waitAndClickElement(flowScreen.showAccountDetails);
    }

    @Override
    public void tapFlow(String flow) {
        waitUtils.waitAndClickElement(new AppiumBy.ByAccessibilityId(flow));
    }

    @Override
    public void tapFromMenu(String desiredFlow) {
//        waitUtils.waitAndClickElement(flowScreen.showAccountDetails);
//        waitUtils.waitForElementToBeVisible(flowScreen.flowMenuContainer);
//        WebElement element = driver.findElement(new AppiumBy.ByAccessibilityId(desiredFlow));
//        element.click();

        waitUtils.waitForElementToBeVisible(flowScreen.scrollViews.get(0));
        waitUtils.waitAndClickElement(flowScreen.showAccountDetails);

//        List<WebElement> flowElements = flowScreen.scrollViews.findElements(By.className("XCUIElementTypeButton"));
//        for (WebElement e : flowElements) {
//            System.out.println("Scroll view element -> " + e.getText());
//        }
    }

    @Override
    public void tapProfileButton() {
        waitUtils.waitForElementToBeVisible(flowScreen.navigationBar);

    }
}
