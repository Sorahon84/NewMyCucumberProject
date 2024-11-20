package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class EmployeeSearchSteps extends CommonMethods {


    @When("user enters employee name")
    public void user_enters_employee_name() {
     //   WebElement empsearchNameField = driver.findElement(By.id("empsearch_employee_name_empName"));
        sendText("ola",employeeSearchPage.empSearchNameField);
        //empsearchNameField.sendKeys("");
    }

    @When("user enters employee ID")
    public void user_enters_employee_id() {
       // WebElement empIdTextBox = driver.findElement(By.id("empsearch_id"));
     //   empIdTextBox.sendKeys("110360A");
        sendText("110360A", employeeSearchPage.empIdTextBox);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
      //  WebElement searchButton = driver.findElement(By.id("searchBtn"));
      //  searchButton.click();
        click(employeeSearchPage.searchButton);
    }

    @Then("user is able to see searched employee on screen")
    public void user_is_able_to_see_searched_employee_on_screen() {
        System.out.println("test passed");
    }
}
