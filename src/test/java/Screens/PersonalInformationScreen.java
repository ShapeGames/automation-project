package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PersonalInformationScreen extends CommonScreen {

    public PersonalInformationScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "registrationStepsPager")
    public WebElement registrationForm;

    @AndroidFindBy(id = "android:id/date_picker_year_picker")
    public WebElement datePicker;

    @AndroidFindBy(id = "textInputEditText")
    public List<WebElement> inputTextElements;

    @AndroidFindBy(className = "android.widget.Spinner")
    public List<WebElement> dropDownMenus;

    @AndroidFindBy(id = "dropdownTextMultiline")
    public List<WebElement> dropDownMenuOptions;

    public WebElement getInputElementWithText(String text) {
        waitUtils.waitForElementToBeVisible(registrationForm);
        return inputTextElements.stream()
                .filter(element -> element.getText().contains(text))
                .findAny()
                .orElseThrow(() -> new NotFoundException("Could not find element with text: " + text));
    }

    public void clickDropDownWithTitle(String title) {
        WebElement desiredDropDownMenuButton = dropDownMenus.stream()
                .filter(element -> element.getText().equals(title))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Could not find drop-down with title: " + title));
        desiredDropDownMenuButton.click();
    }

    public void clickFromDropDown(String option) {
        waitUtils.waitForElementToBeVisible(By.className("android.widget.ListView"));
        WebElement desiredDropDownOption = dropDownMenuOptions.stream()
                .filter(element -> element.getText().equals(option))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Could not find drop-down option: " + option));
        desiredDropDownOption.click();
    }
}
