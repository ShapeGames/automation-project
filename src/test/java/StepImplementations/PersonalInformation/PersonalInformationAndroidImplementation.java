package StepImplementations.PersonalInformation;

import Config.ConstantConfig;
import Screens.CommonScreen;
import Screens.PersonalInformationScreen;
import Steps.PersonalInformationSteps;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PersonalInformationAndroidImplementation extends CommonScreen implements PersonalInformationSteps {

    private PersonalInformationScreen personalInformationScreen;

    public PersonalInformationAndroidImplementation(AppiumDriver driver) {
        super(driver);
        personalInformationScreen = new PersonalInformationScreen(driver);
    }

    @Override
    public void fillFirstName(String firstName) {
        WebElement firstNameField = personalInformationScreen.getInputElementWithText("First name");
        firstNameField.sendKeys(firstName);
    }

    @Override
    public void fillMiddleName(String middleName) {
        WebElement middleNameField = personalInformationScreen.getInputElementWithText("Middle name");
        middleNameField.sendKeys(middleName);
    }

    @Override
    public void fillLastName(String lastName) {
        WebElement lastNameField = personalInformationScreen.getInputElementWithText("Last name");
        lastNameField.sendKeys(lastName);
    }

    @Override
    public void fillBirthDay() {
        WebElement birthDate = personalInformationScreen.getInputElementWithText("Birthdate");
        birthDate.click();
        List<WebElement> yearList = personalInformationScreen.datePicker.findElements(By.id("android:id/text1"));

        WebElement desiredYear = yearList.stream()
                .filter(element -> element.getText().equals("2017"))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Couldn't find year: 2017"));
        desiredYear.click();

        driver.findElement(By.id("android:id/button1")).click();
    }

    @Override
    public void fillGender(String gender) {
        personalInformationScreen.clickDropDownWithTitle(ConstantConfig.GENDER_BUTTON_TITLE);
        personalInformationScreen.clickFromDropDown(gender);
    }

    @Override
    public void fillProvince(String province) {
        personalInformationScreen.clickDropDownWithTitle(ConstantConfig.PROVINCE_BUTTON_TITLE);
        personalInformationScreen.clickFromDropDown(province);
    }

    @Override
    public void fillAddress(String address) {
        WebElement addressField = personalInformationScreen.getInputElementWithText("Address");
        addressField.sendKeys(address);
    }

    @Override
    public void fillZipCode(String zipCode) {
        WebElement zipCodeField = personalInformationScreen.getInputElementWithText("Zip Code");
        zipCodeField.sendKeys(zipCode);
    }

    @Override
    public void fillCity(String city) {
        WebElement cityField = personalInformationScreen.getInputElementWithText("City");
        cityField.sendKeys(city);
    }

    @Override
    public void fillPhoneNumber(String phoneNumber) {
        WebElement phoneNumberField = personalInformationScreen.getInputElementWithText("Phone number");
        phoneNumberField.sendKeys(phoneNumber);
    }
}
