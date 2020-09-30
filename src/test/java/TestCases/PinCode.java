package TestCases;

import Launch_Browser.BrowserLaunch;
import Page_Object.CredentialsObjects;
import org.testng.annotations.Test;

public class PinCode extends BrowserLaunch {

//Testcases 7 & 8

    @Test(priority = 0)
    public void validPincode() throws InterruptedException {
        CredentialsObjects co=new CredentialsObjects(driver);
        co.clickAdress();
        co.validPinCode();
        Thread.sleep(5000);
    }
    @Test(priority = 1)
    public void invalidPincode() throws InterruptedException {
        CredentialsObjects cobj=new CredentialsObjects(driver);
        cobj.clickAdress();
        cobj.invalidPin();
        Thread.sleep(5000);
    }
}
