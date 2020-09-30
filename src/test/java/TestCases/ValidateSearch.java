package TestCases;

import Launch_Browser.BrowserLaunch;
import Page_Object.SearchObjects;
import org.testng.annotations.Test;

public class ValidateSearch extends BrowserLaunch {

//Testcases 3,4,5,6 & 13

    @Test(priority = 0)
    public void testValidSearch() throws InterruptedException {
        SearchObjects ss=new SearchObjects(driver);
        ss.verifyCartCount();
        ss.searchItem();

        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void verifyProductDetail() throws InterruptedException {
        SearchObjects se=new SearchObjects(driver);
        se.verifyCartCount();
        se.searchItem();

        se.selectItem();
        Thread.sleep(5000);

    }

    @Test(priority = 2)
    public void validateAddItemToCart() throws InterruptedException {
        SearchObjects so=new SearchObjects(driver);
        so.verifyCartCount();
        so.searchItem();
        so.selectItem();
        so.checkCartCount();
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void validateRemoveItemToCart() throws InterruptedException {
        SearchObjects sob=new SearchObjects(driver);
        sob.verifyCartCount();
        sob.searchItem();

        sob.selectItem();
        sob.checkCartCount();
        sob.removeCartItem();
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void validateSaveForLater() throws InterruptedException {
        SearchObjects sobjects=new SearchObjects(driver);
        sobjects.verifyCartCount();
        sobjects.searchItem();
        sobjects.selectItem();
        sobjects.checkCartCount();
        sobjects.saveForLater();
        Thread.sleep(5000);
    }

}
