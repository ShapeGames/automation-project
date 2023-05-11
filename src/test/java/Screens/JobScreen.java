package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JobScreen extends CommonScreen {

    public JobScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(className = "android.widget.Spinner")
    public List<WebElement> dropDownMenus;

    @AndroidFindBy(id = "dropdownTextMultiline")
    public List<WebElement> dropDownMenuOptions;

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
