package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageElements.Button;
import pageElements.Checkbox;
import pageElements.InputField;
import pageElements.Label;

public class ElementsPage extends PageBase {
    private final By SEARCH_INPUT_LOCATOR = By.id("text");
    private final By FIND_BUTTON_LOCATOR = By.cssSelector(".b-line_search " +
            "button");
    private final By OUTER_COMPUTER_CHECKBOX_LOCATOR = By
            .cssSelector(".domik2__dropdown-form input[type=checkbox]");
    private final By OUTER_COMPUTER_LABEL_LOCATOR = By
            .cssSelector(".checkbox2__box label");

    public InputField searchField;
    public Button findButton;
    public Label outerComputerLabel;
    public Checkbox outerCompuerChekbox;

    public ElementsPage(WebDriver driver) {
        super(driver);
        searchField = new InputField(driver, SEARCH_INPUT_LOCATOR);
        findButton = new Button(driver, FIND_BUTTON_LOCATOR);
    }

    public void find(String value) throws InterruptedException {
        searchField.sendKeys(value);
        findButton.click();
    }
}
