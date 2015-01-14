package pages.pageElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Search form")
@FindBy(css = "div.main")
public class SearchArrow extends HtmlElement {
    @Name("Search request input")
    @FindBy(id = "text")
    private TextInput requestInput;

    @Name("Search button")
    @FindBy(tagName = "button")
    private Button searchButton;

    public void search(String request) {
        requestInput.sendKeys(request);
        searchButton.click();
    }
}
