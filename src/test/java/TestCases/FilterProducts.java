package TestCases;

import Launch_Browser.BrowserLaunch;
import Page_Object.SearchObjects;
import org.testng.annotations.Test;

public class FilterProducts extends BrowserLaunch {

//Testcase 15

    @Test
    public void verifyFilterOptions() throws InterruptedException {
        SearchObjects so=new SearchObjects(driver);
        so.searchItem();
        so.filterOptions();
        Thread.sleep(5000);
    }
}
