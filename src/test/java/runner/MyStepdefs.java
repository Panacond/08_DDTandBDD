package runner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MyStepdefs {
    @Given("^run hello world$")
    public void runHelloWorld() {
        System.out.println("Hello World");
    }

    @Then("^print hello$")
    public void printHello() {
        System.out.println("Print Hello");
    }
}
