package steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class DashboardSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement PimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
       // PimOption.click();
        click(PimOption);
    }
    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {
        WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
      //  empListOption.click();
        click(empListOption);
    }

    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
       // addEmployeeOption.click();
        click(addEmployeeOption);
    }

}
