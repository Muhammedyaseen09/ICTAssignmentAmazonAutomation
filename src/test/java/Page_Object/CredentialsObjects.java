package Page_Object;

import Listeners_Page.ReadConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CredentialsObjects {
    public WebDriver driver;
    public WebDriverWait wait;

    public String expurl="https://www.aboutamazon.in/";


    ReadConfig readConfig=new ReadConfig();
    public String validpin=readConfig.getvalidpincode();
    public String invalidpin=readConfig.getinvalidpincode();



    public CredentialsObjects(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"nav-global-location-slot\"]/span/a")
    WebElement address;


    @FindBy(id = "GLUXZipError")
    WebElement pinenter;

    @FindBy(xpath = "//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[1]/a")
    WebElement aboutus;




    public void clickAdress(){
        address.click();
    }


    public void validPinCode (){

        wait = new WebDriverWait(driver, 10);
        pinenter=wait.until(ExpectedConditions.presenceOfElementLocated((By.id("GLUXZipUpdateInput"))));
        pinenter.sendKeys(validpin,Keys.ENTER);
    }

    public void invalidPin(){
        wait = new WebDriverWait(driver, 10);
        pinenter=wait.until(ExpectedConditions.presenceOfElementLocated((By.id("GLUXZipUpdateInput"))));
        pinenter.sendKeys(invalidpin,Keys.ENTER);
    }

    public void scrolltoFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    public void clickAboutUs(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[1]/a"))));
        aboutus.click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.className("PageLogo-image"))));
        String currentUrl=driver.getCurrentUrl();
        if (currentUrl.contains(expurl)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }

    }
}
