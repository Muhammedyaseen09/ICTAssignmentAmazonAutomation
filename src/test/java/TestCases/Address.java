package TestCases;

import Launch_Browser.BrowserLaunch;
import Page_Object.CredentialsObjects;
import Page_Object.LoginObjects;
import org.testng.annotations.Test;

public class Address extends BrowserLaunch {

//Testcase 9

    @Test
    public void addNewAddress() throws InterruptedException {
        LoginObjects lo=new LoginObjects(driver);
        lo.menubar();
        lo.addUsername();
        lo.addPassword();
        lo.signinSubmit();
        Thread.sleep(30000);
        lo.menubar();
        lo.addressClick();
        lo.fillDetails();

        Thread.sleep(10000);



    }
}
