package runner;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageFactory.BucketPage;
import pageFactory.SearchPage;
import pageFactory.StartPage;

import support.PropertiesReader;

import java.util.List;

public class StepsWebTests {

    protected WebDriver driver;

    public WebDriver getDriver(){return driver;}

    public StartPage getStartPage(){return new StartPage(getDriver());}

    public SearchPage getSearchPage(){return new SearchPage(getDriver());}

    public BucketPage getBucketPage(){return new BucketPage(getDriver());}

    protected PropertiesReader properties = new PropertiesReader();
    protected StartPage startPage;
    protected SearchPage searchPage;
    protected BucketPage bucketPage;

    @Before
    public void testSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(properties.getUrl());
    }

    @Given("^User input '(.*)' in search field$")
    public void userInputProductInSearchField(String product) {
        startPage = getStartPage();
        startPage.searchByKeyword(product);
    }

    @And("^User check '(.*)'$")
    public void userCheckBrand(String brand) {
        searchPage = getSearchPage();
        searchPage.clickCheckBoxMsi(brand);
    }

    @And("^User select '(.*)'$")
    public void userSelectSelect(String select) {
        searchPage.clickPopUpByText(select);
    }

    @When("^User add first element to bucket$")
    public void userAddFirstElementToBucket() {
        List<WebElement> listAddToBucket =  searchPage.getListAddToBucket();
        searchPage.implicitWait(30);
        searchPage.waitVisibilityOfElement(40, listAddToBucket.get(0));
        searchPage.waitClickOfElement(80,listAddToBucket.get(0));
        listAddToBucket.get(0).click();
        searchPage.clickGoToBucket();
    }

    @Then("^The price in the cart is higher than the '(.*)'$")
    public void thePriceInTheCartIsHigherThanThePrice(int price) {
        bucketPage = getBucketPage();
        Integer realPrice = bucketPage.getStringPrice();
        Assert.assertTrue( "Price in page low data price" + realPrice + ">" + price + "???", realPrice > price);
    }

    @And("^User select '<select>'$")
    public void userSelectSelect() {
    }

    @After
    public void tearDown(){driver.quit();}
}
