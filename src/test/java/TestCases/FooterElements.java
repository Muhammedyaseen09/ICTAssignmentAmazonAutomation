package TestCases;

import Launch_Browser.BrowserLaunch;
import Page_Object.CredentialsObjects;
import org.testng.annotations.Test;

public class FooterElements extends BrowserLaunch {

//Testcase 14

    @Test
    public void verifyFooterElements() throws InterruptedException {
        CredentialsObjects co=new CredentialsObjects(driver);
        co.scrolltoFooter();
        co.clickAboutUs();
        Thread.sleep(10000);
    }
}
