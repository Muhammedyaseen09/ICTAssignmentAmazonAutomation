package TestCases;

import Launch_Browser.BrowserLaunch;
import Page_Object.SearchObjects;
import org.testng.annotations.Test;

public class Sorting extends BrowserLaunch {

//Test case 11

    @Test
    public void productSort() throws InterruptedException {
        SearchObjects searchObjects=new SearchObjects(driver);
        searchObjects.searchItem();
        searchObjects.sortItem();


        Thread.sleep(10000);
    }


}
