package runner;

import cucumber.api.java.en.Given;

public class MyStepdefs {
    @Given("^run hello world$")
    public void runHelloWorld() {
        System.out.println("MyStepdefs.runHelloWorld");
    }
}
