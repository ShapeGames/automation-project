package SetpDefinitions;

import Config.ConstantConfig;
import Config.ConstructorHelper;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Level;
import utils.CustomLogger;
import utils.User;
import utils.UserUtils;

import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class LoginStepDefs extends ConstructorHelper {

    private final TestRunHelper testRunHelper = new TestRunHelper();
    private AppiumDriver driver;
    private UserUtils userUtils;

    @Before
    public void setUp() throws MalformedURLException {
//        driver = testRunHelper.setupDriver("android");
        driver = testRunHelper.setupDriver("ios");
        instantiateConstructors();
        userUtils = new UserUtils();
    }

    @After
    public void tearDown() {
        CustomLogger.log.setLevel(Level.INFO);
        CustomLogger.log.info(ConstantConfig.LOG_SEPARATOR);
        CustomLogger.log.info("Tearing down appium server in 3 seconds...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        testRunHelper.tearDownAppium(driver);
    }

    @And("user fills email field with {string}")
    public void userFillsEmailFieldWith(String email) {
        emailPasswordSteps.fillEmail(email);
    }

    @And("user fills password field with {string}")
    public void userFillsPasswordFieldWith(String password) {
        emailPasswordSteps.fillPassword(password);
    }

    @And("user fills repeat password field with {string}")
    public void userFillsRepeatPasswordFieldWith(String password) {
        emailPasswordSteps.fillRepeatPassword(password);
    }

    @Then("continue button should not be clickable")
    public void continueButtonShouldNotBeClickable() {
        assertFalse("Checking if 'Continue' button is clickable", createYourAccountSteps.isContinueButtonClickable());
    }

    @And("user taps continue button")
    public void userTapsContinueButton() {
        createYourAccountSteps.tapContinueButton();
    }

    @Then("responsible gaming footer is displayed")
    public void responsibleGamingFooterIsDisplayed() {
        assertTrue("Checking if Responsible Gaming footer is displayed", createYourAccountSteps.isResponsibleGamingFooterDisplayed());
    }

    @When("user taps Call Connex Ontario button")
    public void userTapsCallConnexOntarioButton() {
        createYourAccountSteps.tapCallConnexButton();
    }

    @Then("phone number {string} is dialed")
    public void phoneNumberIsDialed(String number) {
        assertTrue("Checking if phone number: " + number + " is dialed", createYourAccountSteps.isNumberDialed(number));
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
    }

    @And("user fills information for user {string}")
    public void userFillsInformationForUser(String user) {
        User desiredUser = userUtils.getUser(user);
        personalInformationSteps.fillFirstName(desiredUser.getFirstName());
        personalInformationSteps.fillMiddleName(desiredUser.getMiddleName());
        personalInformationSteps.fillLastName(desiredUser.getLastName());
        personalInformationSteps.fillBirthDay();
        personalInformationSteps.fillGender(desiredUser.getGender());
        personalInformationSteps.fillAddress(desiredUser.getAddress());
        personalInformationSteps.fillZipCode(desiredUser.getZipCode());
        personalInformationSteps.fillCity(desiredUser.getCity());
        personalInformationSteps.fillProvince(desiredUser.getProvince());
        personalInformationSteps.fillPhoneNumber(desiredUser.getPhoneNumber());
    }

    @Then("continue button should be clickable")
    public void continueButtonShouldBeClickable() {
        assertTrue("Checking if 'Continue' button is clickable", createYourAccountSteps.isContinueButtonClickable());
    }

    @And("user fills job information for user {string}")
    public void userFillsJobInformationForUser(String user) {
        User desiredUser = userUtils.getUser(user);
        jobSteps.fillJobCategory(desiredUser.getJobCategory());
        jobSteps.fillJobDescription(desiredUser.getJobDescription());
    }

    @And("user check every check box")
    public void userCheckEveryCheckBox() {
        termsAndConditionsSteps.checkAccurateInformationCheckBox();
        termsAndConditionsSteps.checkFitToPlayCheckBox();
        termsAndConditionsSteps.checkIsNotPoliticianCheckBox();
        termsAndConditionsSteps.checkThirdPartyCheckBox();
        termsAndConditionsSteps.checkCorrectAgeCheckBox();
        termsAndConditionsSteps.checkSubscriptionCheckBox();
    }

    @And("user checks terms and conditions toggle")
    public void userChecksTermsAndConditionsToggle() {
        termsAndConditionsSteps.checkTermsAndConditionsToggle();
    }

    @And("user checks privacy notice toggle")
    public void userChecksPrivacyNoticeToggle() {
        termsAndConditionsSteps.checkPrivacyNoticeToggle();
    }

    @And("user fills email field with users {string} data")
    public void userFillsEmailFieldWithUsersData(String user) {
        User desiredUser = userUtils.getUser(user);
        emailPasswordSteps.fillEmail(desiredUser.getEmail());
    }

    @And("user fills password field with user {string} data")
    public void userFillsPasswordFieldWithUserData(String user) {
        User desiredUser = userUtils.getUser(user);
        emailPasswordSteps.fillPassword(desiredUser.getPassword());
    }

    @And("user fills repeat password field with user {string} data")
    public void userFillsRepeatPasswordFieldWithUserData(String user) {
        User desiredUser = userUtils.getUser(user);
        emailPasswordSteps.fillRepeatPassword(desiredUser.getPassword());
    }

    @Given("user taps login button")
    public void userTapsLoginButton() {
        welcomeSteps.tapLoginButton();
    }

    @And("user {string} logs in")
    public void userLogsIn(String user) {
        User desiredUser = userUtils.getUser(user);
        signInSteps.inputEmail(desiredUser.getEmail());
        signInSteps.inputPassword(desiredUser.getPassword());
        signInSteps.tapLoginButton();
        signInSteps.tapFitToPlay();
        assertTrue("Checking if Profile button is displayed", homeSteps.isLoginButtonNotDisplayed());
    }

    //    @And("user taps profile button")
//    public void userTapsProfileButton() {
//        homeSteps.tapProfileButton();
//    }
//
//    @And("user taps account details button from profile menu")
//    public void userTapsAccountDetailsButtonFromProfileMenu() {
//        homeSteps.tapAccountDetails();
//    }
//
    @Then("{string} user details are displayed")
    public void userDetailsForUserAreDisplayed(String user) {
        User desiredUser = userUtils.getUser(user);
        assertTrue(accountDetailSteps.isValidFirstNameDisplayed(desiredUser.getFirstName()));
        assertTrue(accountDetailSteps.isValidMiddleNameDisplayed(desiredUser.getMiddleName()));
        assertTrue(accountDetailSteps.isValidLastNameDisplayed(desiredUser.getLastName()));
        assertTrue(accountDetailSteps.isValidGenderDisplayed(desiredUser.getGender()));
    }
//
//    @Then("users {string} email is displayed in profile menu")
//    public void userEmailIsDisplayedInProfileMenu(String user) {
//        User desiredUser = userUtils.getUser(user);
//        assertTrue("Checking if valid user name is displayed in profile menu", homeSteps.isValidUserDisplayedInProfileMenu(desiredUser.getEmail()));
//    }

    @Given("user taps Ontario app")
    public void userTapsOntarioApp() {
        integrationSteps.tapBetSafeOntario();
    }

    @Given("user opens app {string}")
    public void userOpensApp(String desiredApp) {
        integrationSteps.openApp(desiredApp);
    }

    @And("user taps log in flow")
    public void userTapsLogInFlow() {
        flowSteps.tapLoginFlow();
    }

    @And("user taps {string} flow")
    public void userTapsFlow(String flow) {
        flowSteps.tapFlow(flow);
    }

    @And("user taps Other Actions flow")
    public void userTapsOtherActionsFlow() {
        flowSteps.tapOtherActions();
    }

    @And("user taps Show Account Details")
    public void userTapsShowAccountDetails() {
        flowSteps.tapShowAccountDetails();
    }

    @When("user taps {string} from Other actions menu")
    public void userTapsFromOtherActionsMenu(String desiredFlow) {
        flowSteps.tapFromMenu(desiredFlow);
    }

    @And("user taps Profile button")
    public void userTapsProfileButton() {
        flowSteps.tapProfileButton();
    }

    @When("user taps Here we go button")
    public void userTapsHereWeGoButton() {
        signInSteps.tapLoginButton();
        signInSteps.tapFitToPlay();
    }

    @Then("invalid credentials error is displayed")
    public void invalidCredentialsErrorIsDisplayed() {
        assertTrue(signInSteps.isCredentialsErrorDisplayed());
    }
}