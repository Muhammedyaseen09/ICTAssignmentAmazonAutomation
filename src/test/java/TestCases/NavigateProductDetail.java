package TestCases;

import Launch_Browser.BrowserLaunch;
import Page_Object.SearchObjects;
import org.testng.annotations.Test;

public class NavigateProductDetail extends BrowserLaunch {

//Testcase 12

    @Test
    public void validateNavigateProductDetail() throws InterruptedException {
        SearchObjects so=new SearchObjects(driver);
        so.threeLine();
        so.selectCategories();
        Thread.sleep(10000);

    }
}
