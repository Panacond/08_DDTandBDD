package pageFactory;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import support.PropertiesReader;
import support.TestData;

import java.util.List;


public class BusinessLogic {
    PropertiesReader properties = new PropertiesReader();

    public void addToBucketExpensiveElementNoThreadSleep(SearchPage searchPage, String brand) {
        searchPage.clickCheckBoxMsi(brand);
        searchPage.clickPopUpByText(" От дорогих к дешевым ");
        List<WebElement> listAddToBucket =  searchPage.getListAddToBucket();
        searchPage.implicitWait(30);
        searchPage.waitVisibilityOfElement(40, listAddToBucket.get(0));
        searchPage.waitClickOfElement(80,listAddToBucket.get(0));
        listAddToBucket.get(0).click();
        searchPage.clickGoToBucket();
    }

    public void CheckProduct(BucketPage bucketPage, TestData testData){
        Integer price = bucketPage.getStringPrice();
        testData.setRealPrice(price);
        Assert.assertTrue( "Price in page low data price" + price + ">" + testData.getMinPrice() + "???", price > testData.getMinPrice());
    }
}
