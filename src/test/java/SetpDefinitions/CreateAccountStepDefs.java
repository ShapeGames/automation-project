package SetpDefinitions;

import Config.ConstantConfig;
import Config.ConstructorHelper;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import org.apache.log4j.Level;
import utils.CustomLogger;
import utils.UserUtils;

import java.net.MalformedURLException;

public class CreateAccountStepDefs extends ConstructorHelper {

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

    @And("user taps create account button")
    public void userTapsAlreadyAMemberButton() {
        welcomeSteps.tapCreateAccountButton();
    }
}
