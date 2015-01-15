package pageElements;

import base.ElementBase;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

/**
 * Created by Acer on 14.01.2015.
 */
public class Checkbox extends ElementBase {

    public Checkbox(SearchContext host, By locator) {
        super(host, locator);
    }

    public boolean isSelected() {
        return element.isSelected();
    }

    public void check () {
        setValue(true);
    }

    public void uncheck () {
        setValue(false);
    }

    private void setValue (boolean value) {
        if (isSelected() != value) {
            element.click();
        }
    }
}
