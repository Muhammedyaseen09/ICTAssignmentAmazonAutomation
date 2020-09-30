package Page_Object;

import Listeners_Page.ReadConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.ArrayList;


public class SearchObjects {

    ReadConfig readConfig=new ReadConfig();
    public String Productname= readConfig.getProductName();

    public WebDriver driver;
    public WebDriverWait wait;


    public SearchObjects(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"nav-cart-count\"]")
    WebElement zerocount;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBar;


    @FindBy(linkText = "Nivia Storm Football - Size 5")
    WebElement product;


    @FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
    WebElement btnaddtocart;

    @FindBy(linkText = "Cart")
    WebElement cartButton;

    @FindBy(xpath= "/html/body/div[1]/div[4]/div/div[5]/div/div[2]/div[2]/form/div[2]/div[3]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[2]/span/input")
    WebElement deleteitem;

    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div[5]/div/div[2]/div[2]/form/div[2]/div[3]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[3]/span/input")
    WebElement savelater;


    @FindBy(xpath = "//*[@id=\"nav-hamburger-menu\"]/i")
    WebElement hamburger;

    @FindBy(linkText = "Men's Fashion")
    WebElement category;

    @FindBy(linkText = "Shirts")
    WebElement subcategory;

    @FindBy(xpath = "//*[@id=\"p_89/Nivia\"]/span/a/div/label/i")
    WebElement brand;

    @FindBy(xpath = "//*[@id=\"p_n_feature_sixteen_browse-bin/3415278031\"]/span/a/div/label/i")
    WebElement size;

    @FindBy(xpath = "//*[@id=\"p_n_pct-off-with-tax/2665400031\"]/span/a/span")
    WebElement discount;


    public void verifyCartCount(){
        wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-cart-count\"]")));
        if (zerocount.getText().contains("0")){
            Assert.assertTrue(true,"Cart count 0");
        }else {
            Assert.assertTrue(false);
        }
    }

    public void searchItem(){
        searchBar.sendKeys(Productname, Keys.ENTER);
    }


    public void selectItem(){
        wait=new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Nivia Storm Football - Size 5")));
        product.click();
    }


    public void checkCartCount() throws InterruptedException {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(6000);
        try
        {
            driver.navigate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        Select quantity=new Select(driver.findElement(By.id("quantity")));
        quantity.selectByVisibleText("3");
        btnaddtocart.click();

        wait=new WebDriverWait(driver, 20);
        cartButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart")));
        cartButton.click();
    }

    public void removeCartItem(){
        wait=new WebDriverWait(driver, 30);
        deleteitem=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div/div[5]/div/div[2]/div[2]/form/div[2]/div[3]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[2]/span/input")));
        deleteitem.click();
    }

    public void saveForLater(){
        wait=new WebDriverWait(driver, 30);
        savelater=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div/div[5]/div/div[2]/div[2]/form/div[2]/div[3]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[3]/span/input")));
        savelater.click();
    }


    public void sortItem(){
        Select htol=new Select(driver.findElement(By.id("s-result-sort-select")));
        htol.selectByVisibleText("Price: High to Low");
    }



    public void threeLine(){
        wait=new WebDriverWait(driver, 20);
        hamburger=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-hamburger-menu\"]/i")));
        hamburger.click();

    }


    public void selectCategories(){
        wait=new WebDriverWait(driver, 20);
        category=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Men's Fashion")));
        category.click();

        wait=new WebDriverWait(driver, 20);
        subcategory=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Shirts")));
        subcategory.click();
    }



    public void filterOptions(){
        wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p_89/Nivia\"]/span/a/div/label/i")));
        brand.click();

        wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p_n_feature_sixteen_browse-bin/3415278031\"]/span/a/div/label/i")));
        size.click();

        wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p_n_pct-off-with-tax/2665400031\"]/span/a/span")));
        discount.click();
    }

}
