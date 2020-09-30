package Page_Object;


import Listeners_Page.ReadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginObjects {

    public WebDriver driver;
    public WebDriverWait wait;

    ReadConfig readConfig=new ReadConfig();
    public String username=readConfig.getUsername();
    public String password=readConfig.getPassword();
    public String invaliduname=readConfig.getInvalidUsrnme();

    public String country=readConfig.getcountry();
    public String fullName=readConfig.getfullName();
    public String MobileNumber=readConfig.getMobileNumber();
    public String validpin=readConfig.getvalidpincode();
    public String HouseNumber=readConfig.getHouseNumber();
    public String Town= readConfig.getTown();
    public String State= readConfig.getState();


    

    public LoginObjects(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]/div/span")
    WebElement header;

    @FindBy(id = "nav-link-accountList")
    WebElement openmenu;

    @FindBy(id = "ap_email")
    WebElement uname;

    @FindBy(id = "continue")
    WebElement nextPage;

    @FindBy(id = "ap_password")
    WebElement pword;

    @FindBy(id = "signInSubmit")
    WebElement clickSubmit;

    @FindBy(xpath = "//*[@id=\"a-page\"]/div[2]/div/div[3]/div[1]/a/div/div/div/div[2]/h2")
    WebElement youraddress;

    @FindBy(xpath = "//*[@id=\"ya-myab-address-add-link\"]/div/div/h2")
    WebElement addaddress;

    @FindBy(id="address-ui-widgets-enterAddressFullName")
    WebElement fname;

    @FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
    WebElement phno;

    @FindBy(id = "address-ui-widgets-enterAddressPostalCode")
    WebElement postalcode;

    @FindBy(id = "address-ui-widgets-enterAddressLine1")
    WebElement addressline;

    @FindBy(id = "address-ui-widgets-enterAddressCity")
    WebElement addressCity;

    @FindBy(className = "a-button-input")
    WebElement addAddressbutton;


    public void verifyHeader(){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[@id=\"nav-link-accountList\"]/div/span"))));
        if (header.getText().contains("Hello, Sign in")){
            Assert.assertTrue(true,"Header verified");
        }else {
            Assert.assertTrue(false);
        }
    }


    public void menubar(){
        wait = new WebDriverWait(driver, 10);
        addAddressbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
        openmenu.click();
    }

    public void addUsername(){
        uname.sendKeys(username);
        nextPage.click();

    }

    public void invalidUnme(){
        uname.sendKeys(invaliduname);
        nextPage.click();
    }


    public void addPassword(){
        pword.sendKeys(password);
    }

    public void signinSubmit(){
        clickSubmit.click();
    }


    public void addressClick(){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[3]/div[1]/a/div/div/div/div[2]/h2"))));
        youraddress.click();

        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[@id=\"ya-myab-address-add-link\"]/div/div/h2"))));
        addaddress.click();
    }

    public void fillDetails(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address-ui-widgets-countryCode-dropdown-nativeId")));
        Select cntry=new Select(driver.findElement(By.id("address-ui-widgets-countryCode-dropdown-nativeId")));
        cntry.selectByVisibleText(country);

        fname.sendKeys(fullName);
        phno.sendKeys(MobileNumber);
        postalcode.sendKeys(validpin);
        addressline.sendKeys(HouseNumber);
        addressCity.sendKeys(Town);

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")));
        Select province=new Select(driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")));
        province.selectByVisibleText(State);


        wait = new WebDriverWait(driver, 10);
        addAddressbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-button-input")));
        addAddressbutton.click();
    }


}
