package StepImplementations.AccountDetails;

import Screens.AccountDetailsScreen;
import Screens.CommonScreen;
import Steps.AccountDetailSteps;
import io.appium.java_client.AppiumDriver;

public class AccountDetailsAndroidImplementation extends CommonScreen implements AccountDetailSteps {

    private final AccountDetailsScreen accountDetailsScreen;

    public AccountDetailsAndroidImplementation(AppiumDriver driver) {
        super(driver);
        accountDetailsScreen = new AccountDetailsScreen(driver);
    }

    @Override
    public boolean isValidFirstNameDisplayed(String firstName) {
        waitUtils.waitForElementToBeVisible(accountDetailsScreen.personalDetailsContainer);
        return getFirstName().equals(firstName);
    }

    @Override
    public boolean isValidMiddleNameDisplayed(String middleName) {
        waitUtils.waitForElementToBeVisible(accountDetailsScreen.personalDetailsContainer);
        return getMiddleName().equals(middleName);
    }

    @Override
    public boolean isValidLastNameDisplayed(String lastName) {
        waitUtils.waitForElementToBeVisible(accountDetailsScreen.personalDetailsContainer);
        return getLastName().equals(lastName);
    }

    @Override
    public boolean isValidGenderDisplayed(String gender) {
        return false;
    }

    private String getFirstName() {
        return getValueForIndex(0);
    }

    private String getMiddleName() {
        return getValueForIndex(1);
    }

    private String getLastName() {
        return getValueForIndex(2);
    }

    private String getValueForIndex(int index) {
        return accountDetailsScreen.personalDetailList.get(index).getText();
    }
}
