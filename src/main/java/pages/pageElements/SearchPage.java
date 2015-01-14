package pages.pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class SearchPage {
    private SearchArrow searchArrow;
    private AuthorizationForm authorizationForm;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    public void search(String request) {
        searchArrow.search(request);
    }

    public void login(String login, String password) {
        authorizationForm.login(login, password);
    }
}
