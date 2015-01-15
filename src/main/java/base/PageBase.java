package base;

import org.openqa.selenium.WebDriver;

public class PageBase {
    protected final WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }
}
