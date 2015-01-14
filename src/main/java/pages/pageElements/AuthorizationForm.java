package pages.pageElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(css = "form.auth")
public class AuthorizationForm extends HtmlElement {
    @FindBy(css = ".auth__username input")
    private TextInput loginField;

    @FindBy(css = "auth__password input")
    private TextInput passwordField;

    @FindBy(css = "button.auth__login-button")
    private Button submitButton;

    public void login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
    }
}
