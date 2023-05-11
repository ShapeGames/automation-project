package Steps;

public interface SignInSteps {

    void inputEmail(String email);

    void inputPassword(String password);

    void tapLoginButton();

    void tapFitToPlay();

    boolean isCredentialsErrorDisplayed();
}