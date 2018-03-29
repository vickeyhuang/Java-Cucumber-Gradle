package resources.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BasicStepDefs {

    WebDriver driver = null;

    public void initializeDriver()
    {
        driver = new ChromeDriver();
    }


 /*
 Basic feature steps
  */

    @Given("^\"([^\"]*)\" use Cucumber Main class to run tests$")
    public void I_use_Cucumber_Main_class_to_run_tests(String testString) throws Throwable {
        System.out.println("Hello cucumber jvm " + testString);
    }


    @Then("^Gradle should report \"([^\"]*)\"$")

    public void Gradle_should_report(String testString) throws Throwable {
        System.out.println(testString);
    }


 /*
 Google feature steps
  */

    @Given("^the page is open \"([^\"]*)\"$")
    public void the_page_is_open(String page) throws Throwable {
        initializeDriver();
        driver.get(page);
        System.out.println("The testing page title is: " + driver.getTitle());
    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String search) throws Throwable {
        WebElement element = driver.findElement(By.name("wd"));
        element.sendKeys(search);
        element.submit();
    }

    @Then("^a browser title should contains \"([^\"]*)\"$")
    public void a_browser_title_should_contains(String text) throws Throwable {
        Thread.sleep(1000);
        driver.getTitle().contains(text);
        System.out.println("The page title is: " + driver.getTitle());
    }

    public void closeDriver() {
        driver.quit();
    }

}
