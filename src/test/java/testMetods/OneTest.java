package testMetods;

import org.junit.Test;
import pageFactory.BucketPage;
import pageFactory.BusinessLogic;
import pageFactory.SearchPage;
import pageFactory.StartPage;
import support.TestData;


public class OneTest extends BaseTest {
    String[] listData =  {"ноутбук", "MSI", "5000"};


    @Test
    public void checkExpensiveGoods() {

        TestData testData = new TestData(listData[0], listData[1], Integer.parseInt(listData[2]));
        StartPage startPage = getStartPage();
        startPage.searchByKeyword(listData[0]);
        SearchPage searchPage = getSearchPage();
        new BusinessLogic().addToBucketExpensiveElementNoThreadSleep(searchPage, listData[1]);
        BucketPage bucketPage = getBucketPage();
        new BusinessLogic().CheckProduct(bucketPage, testData);
    }
}
