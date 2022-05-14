package testMetods;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import pageFactory.Calculator;
import example.DataDrivenTest;


@RunWith(DataDrivenTestRunner.class)
public class CSVLoaderExample extends DataDrivenTest {

    @Test
    @DataLoader(filePaths = "calculator.csv", loaderType = LoaderType.CSV)
    public String testAddFromCSV(@Param(name = "a") Double a,
                                 @Param(name = "b") Double b,
                                 @Param(name = "expected") Double expected) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(expected, calculator.add(a, b), 0.1);
        return "success";
    }

    @Test
    @DataLoader(filePaths = "calculator2.csv")
    public void testAdd(@Param(name = "a") Double a, @Param(name = "b")Double b, @Param(name = "expected")Double expected){
        Assert.assertEquals(expected, calculator.add(a,b),0.1);
    }
}
