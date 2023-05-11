package Steps;

public interface CreateYourAccountSteps {

    boolean isContinueButtonClickable();

    boolean isResponsibleGamingFooterDisplayed();

    void tapContinueButton();

    void tapCallConnexButton();

    boolean isNumberDialed(String number);
}