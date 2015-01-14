package pages.pageElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;

@FindBy(id = "lang")
public class LanguageSelectionForm extends HtmlElement {
    @FindBy(className = "b-form__select")
    private Select listOfLanguages;

    @FindBy(xpath = "//input[@type='submit']")
    private Button saveButton;

    @FindBy(xpath = "//input[@type='button']")
    private Button returnButton;

    public void selectLanguage(String language) {
        listOfLanguages.selectByValue(language);
        saveButton.click();
    }
}
