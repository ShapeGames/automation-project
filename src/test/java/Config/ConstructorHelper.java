package Config;

import SetpDefinitions.TestRunHelper;
import StepImplementations.AccountDetails.AccountDetailsAndroidImplementation;
import StepImplementations.AccountDetails.AccountDetailsIosImplementation;
import StepImplementations.CreateAccount.CreateYourAccountAndroidImplementation;
import StepImplementations.CreateAccount.CreateYourAccountIosImplementation;
import StepImplementations.EmailPassword.EmailPasswordAndroidImplementation;
import StepImplementations.EmailPassword.EmailPasswordIosImplementation;
import StepImplementations.Flow.FlowIosImplementation;
import StepImplementations.Home.HomeAndroidImplementation;
import StepImplementations.Home.HomeIosImplementation;
import StepImplementations.Integrations.IntegrationIosImplementation;
import StepImplementations.Job.JobAndroidImplementation;
import StepImplementations.PersonalInformation.PersonalInformationAndroidImplementation;
import StepImplementations.SignIn.SignInStepsAndroidImplementation;
import StepImplementations.SignIn.SignInStepsiOSImplementation;
import StepImplementations.TermsAndConditions.TermsAndConditionsAndroidImplementation;
import StepImplementations.Welcome.WelcomeStepsAndroidImplementation;
import StepImplementations.Welcome.WelcomeStepsIosImplementation;
import Steps.*;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Level;
import org.openqa.selenium.Platform;
import utils.CustomLogger;

public class ConstructorHelper {

    private final TestRunHelper testRunHelper = new TestRunHelper();
    public WelcomeSteps welcomeSteps;
    public SignInSteps signInSteps;
    public CreateYourAccountSteps createYourAccountSteps;
    public TermsAndConditionsSteps termsAndConditionsSteps;
    public EmailPasswordSteps emailPasswordSteps;
    public PersonalInformationSteps personalInformationSteps;
    public JobSteps jobSteps;
    public HomeSteps homeSteps;
    public AccountDetailSteps accountDetailSteps;
    public IntegrationSteps integrationSteps;
    public FlowSteps flowSteps;

    public void instantiateConstructors() {
        CustomLogger.log.setLevel(Level.INFO);
        AppiumDriver driver = testRunHelper.getDriver();

        if (driver.getCapabilities().getPlatformName().equals(Platform.ANDROID)) {
            CustomLogger.log.info("Test running on Android platform, instantiating constructors for Android...");
            CustomLogger.log.info(ConstantConfig.LOG_SEPARATOR);

            welcomeSteps = new WelcomeStepsAndroidImplementation(driver);
            signInSteps = new SignInStepsAndroidImplementation(driver);
            createYourAccountSteps = new CreateYourAccountAndroidImplementation(driver);
            termsAndConditionsSteps = new TermsAndConditionsAndroidImplementation(driver);
            emailPasswordSteps = new EmailPasswordAndroidImplementation(driver);
            personalInformationSteps = new PersonalInformationAndroidImplementation(driver);
            jobSteps = new JobAndroidImplementation(driver);
            homeSteps = new HomeAndroidImplementation(driver);
            accountDetailSteps = new AccountDetailsAndroidImplementation(driver);
        } else if (driver.getCapabilities().getPlatformName().equals(Platform.IOS)) {
            CustomLogger.log.info("Test running on iOS platform, instantiating constructors for iOS...");
            CustomLogger.log.info(ConstantConfig.LOG_SEPARATOR);

            integrationSteps = new IntegrationIosImplementation(driver);
            flowSteps = new FlowIosImplementation(driver);
            homeSteps = new HomeIosImplementation(driver);

            welcomeSteps = new WelcomeStepsIosImplementation(driver);
            signInSteps = new SignInStepsiOSImplementation(driver);
            createYourAccountSteps = new CreateYourAccountIosImplementation(driver);
            accountDetailSteps = new AccountDetailsIosImplementation(driver);
            emailPasswordSteps = new EmailPasswordIosImplementation(driver);
        }
    }
}