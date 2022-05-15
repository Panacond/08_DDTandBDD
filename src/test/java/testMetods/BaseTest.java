package testMetods;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageFactory.BucketPage;
import pageFactory.SearchPage;
import pageFactory.StartPage;
import support.PropertiesReader;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    private WebDriver driver;
    PropertiesReader properties = new PropertiesReader();

    @Before
    public void testSetUp(){
//        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(properties.getUrl());
    }

    @After
    public void tearDown(){driver.quit();}

    public WebDriver getDriver(){return driver;}

    public StartPage getStartPage(){return new StartPage(getDriver());}

    public SearchPage getSearchPage(){return new SearchPage(getDriver());}

    public BucketPage getBucketPage(){return new BucketPage(getDriver());}
}
