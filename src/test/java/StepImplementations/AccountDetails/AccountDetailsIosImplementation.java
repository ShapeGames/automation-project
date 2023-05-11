package StepImplementations.AccountDetails;

import Screens.AccountDetailsScreen;
import Screens.CommonScreen;
import Steps.AccountDetailSteps;
import io.appium.java_client.AppiumDriver;

public class AccountDetailsIosImplementation extends CommonScreen implements AccountDetailSteps {

    private final AccountDetailsScreen accountDetailsScreen;

    public AccountDetailsIosImplementation(AppiumDriver driver) {
        super(driver);
        accountDetailsScreen = new AccountDetailsScreen(driver);
    }

    @Override
    public boolean isValidFirstNameDisplayed(String firstName) {
        waitUtils.waitForElementToBeVisible(accountDetailsScreen.personalDetailsTitle);
        return getFirstName().equals(firstName);
    }

    @Override
    public boolean isValidMiddleNameDisplayed(String middleName) {
        return getMiddleName().equals(middleName);
    }

    @Override
    public boolean isValidLastNameDisplayed(String lastName) {
        return getLastName().equals(lastName);
    }

    @Override
    public boolean isValidGenderDisplayed(String gender) {
        return getGender().equals(gender);
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

    private String getGender() {
        return getValueForIndex(4);
    }

    private String getValueForIndex(int index) {
        return accountDetailsScreen.personalDetailList.get(index).getText();
    }
}
