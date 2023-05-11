package StepImplementations.Job;

import Config.ConstantConfig;
import Screens.CommonScreen;
import Screens.JobScreen;
import Steps.JobSteps;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class JobAndroidImplementation extends CommonScreen implements JobSteps {

    private JobScreen jobScreen;

    public JobAndroidImplementation(AppiumDriver driver) {
        super(driver);
        jobScreen = new JobScreen(driver);
    }

    @Override
    public void fillJobCategory(String jobCategory) {
        waitUtils.waitForElementToBeVisible(By.id("registrationContainer"));
        jobScreen.clickDropDownWithTitle(ConstantConfig.JOB_CATEGORY_BUTTON_TITLE);
        jobScreen.clickFromDropDown(jobCategory);
    }

    @Override
    public void fillJobDescription(String jobDescription) {
        jobScreen.clickDropDownWithTitle(ConstantConfig.JOB_DESCRIPTION_BUTTON_TITLE);
        jobScreen.clickFromDropDown(jobDescription);
    }
}