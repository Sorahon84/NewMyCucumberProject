package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.DbReader;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
     String employeeId;
     String expectedFN;
     String expectedMN;
     String expectedLN;


    //AddEmployeePage addEmployeePage = new AddEmployeePage();
    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
       // WebElement firstNameLocator = driver.findElement(By.id("firstName"));
       // WebElement lastNameLocator = driver.findElement(By.id("lastName"));
        //firstNameLocator.sendKeys("Mark");
        //lastNameLocator.sendKeys("Jacob");
        sendText("Mark",addEmployeePage.firstNameLocator);
        sendText("Jacob",addEmployeePage.lastNameLocator);
    }




    @When("user enters {string} and {string} and {string}  in the application")
    public void user_enters_and_and_in_the_application(String firstName, String middleName, String lastName) {
       // WebElement firstNameLocator = driver.findElement(By.id("firstName"));
       // WebElement lastNameLocator = driver.findElement(By.id("lastName"));
       // WebElement middleNameLocator = driver.findElement(By.id("middleName"));
        //firstNameLocator.sendKeys(firstName);
        //middleNameLocator.sendKeys(middleName);
        //lastNameLocator.sendKeys(lastName);
        sendText(firstName,addEmployeePage.firstNameLocator);
        sendText(middleName,addEmployeePage.middleNameLocator);
        sendText(lastName,addEmployeePage.lastNameLocator);
        expectedFN=firstName;
        expectedMN=middleName;
        expectedLN=lastName;
        // gets the id of employee from add employee page
        employeeId =addEmployeePage.employeeIDField.getAttribute("value");
    }

    // this is what we call data driven testing
    @When("user add {string},{string} and {string}")
    public void user_add_and(String fn, String mn, String ln) {
       // WebElement firstNameLocator = driver.findElement(By.id("firstName"));
        //WebElement lastNameLocator = driver.findElement(By.id("lastName"));
       // WebElement middleNameLocator = driver.findElement(By.id("middleName"));
       // firstNameLocator.sendKeys(fn);
       // middleNameLocator.sendKeys(mn);
       // lastNameLocator.sendKeys(ln);
        sendText(fn,addEmployeePage.firstNameLocator);
        sendText(mn,addEmployeePage.middleNameLocator);
        sendText(ln,addEmployeePage.lastNameLocator);

    }

    @When("user adds multiple employees using data table and save them")
    public void user_adds_multiple_employees_using_data_table_and_save_them(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> employeeNames = dataTable.asMaps();
        for (Map<String, String> employee : employeeNames) {
            //WebElement firstNameLocator = driver.findElement(By.id("firstName"));
            //WebElement lastNameLocator = driver.findElement(By.id("lastName"));
            //WebElement middleNameLocator = driver.findElement(By.id("middleName"));
            addEmployeePage.firstNameLocator.sendKeys(employee.get("firstName"));
            addEmployeePage.middleNameLocator.sendKeys(employee.get("middleName"));
            addEmployeePage.lastNameLocator.sendKeys(employee.get("lastName"));

            //WebElement saveButton = driver.findElement(By.id("btnSave"));
            addEmployeePage.saveButton.click();
            WebElement addEmpOption = driver.findElement(By.id("menu_pim_addEmployee"));
            addEmpOption.click();
        }
    }

    @When("user adds multiple employees from excel file")
    public void user_adds_multiple_employees_from_excel_file() throws IOException {
        List<Map<String, String>> newEmployees = ExcelReader.read();
        for (Map<String, String> employee : newEmployees) {
            //WebElement firstNameLocator = driver.findElement(By.id("firstName"));
            //WebElement middleNameLocator = driver.findElement(By.id("middleName"));
            //WebElement lastNameLocator = driver.findElement(By.id("lastName"));
            addEmployeePage.firstNameLocator.sendKeys(employee.get("firstName"));
            addEmployeePage.middleNameLocator.sendKeys(employee.get("middleName"));
            addEmployeePage.lastNameLocator.sendKeys(employee.get("lastName"));

            //WebElement saveButton = driver.findElement(By.id("btnSave"));
            addEmployeePage.saveButton.click();
            WebElement addEmpOption = driver.findElement(By.id("menu_pim_addEmployee"));
            addEmpOption.click();
        }
    }

    @When("user enters firstname and middleman and lastname")
    public void user_enters_firstname_and_middleman_and_lastname() {
        // WebElement firstNameLocator = driver.findElement(By.id("firstName"));
        //WebElement lastNameLocator = driver.findElement(By.id("lastName"));
        // WebElement middleNameLocator = driver.findElement(By.id("middleName"));
        // firstNameLocator.sendKeys("Mark");
        //lastNameLocator.sendKeys("Jacob");
        //middleNameLocator.sendKeys("Mj");
        sendText("Mark",addEmployeePage.firstNameLocator);
        sendText("MS",addEmployeePage.middleNameLocator);
        sendText("Jacob",addEmployeePage.lastNameLocator);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        //WebElement saveButton = driver.findElement(By.id("btnSave"));
        //saveButton.click();
        click(addEmployeePage.saveButton);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        String query = "select emp_firstname, emp_middle_name, emp_lastname from hs_hr_employees where employee_id = '" + employeeId + "'";

        List<Map<String,String>>dataFromDb = DbReader.fetch( query);
        String actualFN = dataFromDb.get(0).get("emp_firstname");
        String actualMN = dataFromDb.get(0).get("emp_middle_name");
        String actualLN = dataFromDb.get(0).get("emp_lastname");
        Assert.assertEquals(expectedFN,actualFN);
        Assert.assertEquals(expectedMN,actualMN);
        Assert.assertEquals(expectedLN,actualLN);










    }



}
