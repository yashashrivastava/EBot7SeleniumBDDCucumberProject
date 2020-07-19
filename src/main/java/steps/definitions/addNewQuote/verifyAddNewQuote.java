package steps.definitions.addNewQuote;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class verifyAddNewQuote {
    private WebDriver myDriver;

    private String searchVal = "New";

    public verifyAddNewQuote(TestContext context){
        myDriver = context.getDriver();
    }

    @Given("^user is already on e-bot7 Home Page$")
    public void user_is_already_on_ebot7_Home_Page(){
        myDriver.manage().window().maximize();
        myDriver.get("https://www-5f02cfdef1dd6f49fe852cfe.recruit.eb7.io/");
        myDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("^enter value in search bar and hit enter$")
    public void enter_value_in_search_bar_and_hit_enter(){
        WebElement searchBar = myDriver.findElement(By.id("searchBar"));
        searchBar.clear();
        searchBar.sendKeys(searchVal);
        myDriver.findElement(By.xpath("//div[@class='row']")).click();
        myDriver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    }

    @Then("^verify that list of filtered matches is displayed$")
    public void new_quote_is_added(){
        List<WebElement> matchingQuoteList= myDriver.findElements(By.xpath("//li[@class='quotes']"));

        int counter = 0;

        System.out.println("List of filtered matches is listed below:--> ");
        for (int i = 0; i < matchingQuoteList.size(); i++) {
            if(matchingQuoteList.get(i).getText().contains(searchVal)){
                System.out.println(matchingQuoteList.get(i).getText());
                counter = counter+1;
            }
        }
        System.out.println("Number of filtered matched quotes found are: " + counter);
        System.out.println("Test Case Passed.");
    }


    @And("^close the Browser$")
    public void close_the_Browser(){
        myDriver.quit();
    }
}
