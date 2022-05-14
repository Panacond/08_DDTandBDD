package example;

import org.junit.Before;
import pageFactory.Calculator;

/**
 * Created by shantonu on 7/15/16.
 * this is default test template (parent class)
 */

public abstract class DataDrivenTest {
    protected Calculator calculator;

    @Before
    public void init(){
        calculator = new Calculator();
    }
}
