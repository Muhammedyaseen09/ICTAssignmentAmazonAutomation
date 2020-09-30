package TestCases;

import Launch_Browser.BrowserLaunch;
import Page_Object.LoginObjects;
import org.testng.annotations.Test;



public class Login extends BrowserLaunch {

//Test cases 1 & 2


    @Test(priority = 0)
    public void validloginTest() throws InterruptedException {

        LoginObjects lo=new LoginObjects(driver);
        lo.verifyHeader();
        lo.menubar();
        lo.addUsername();
        lo.addPassword();
        lo.signinSubmit();

        Thread.sleep(50000);

    }

    @Test(priority = 1)
    public void invalidLoginTest() throws InterruptedException {
        LoginObjects lo=new LoginObjects(driver);
        lo.verifyHeader();
        lo.menubar();
        lo.invalidUnme();
        Thread.sleep(5000);
    }

}
