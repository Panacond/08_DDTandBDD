package testMetods;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import pageFactory.BucketPage;
import pageFactory.BusinessLogic;
import pageFactory.SearchPage;
import pageFactory.StartPage;
import support.TestData;


@RunWith(DataDrivenTestRunner.class)
public class CsvDataTest extends BaseTest{
    @Test
    @DataLoader(filePaths = "testData.csv", loaderType = LoaderType.CSV)
    public void testAdd(@Param(name = "product") String product
                        , @Param(name = "brand") String brand
                        , @Param(name = "price") int price){
        TestData testData = new TestData(product, brand, price);
        StartPage startPage = getStartPage();
        startPage.searchByKeyword(product);
        SearchPage searchPage = getSearchPage();
        new BusinessLogic().addToBucketExpensiveElementNoThreadSleep(searchPage, brand);
        BucketPage bucketPage = getBucketPage();
        new BusinessLogic().CheckProduct(bucketPage, testData);
    }
}
