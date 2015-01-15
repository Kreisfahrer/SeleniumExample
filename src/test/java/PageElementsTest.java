import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage;

public class PageElementsTest extends TestBase {
    private ElementsPage page;

    @BeforeMethod
    @Override
    public void setup() throws InterruptedException {
        super.setup();
        page = new ElementsPage(driver);
    }

    @Test
    public void searchTest() throws InterruptedException {
        page.find("yandex");
        Thread.sleep(3000);
    }
}
