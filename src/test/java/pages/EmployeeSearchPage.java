package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeSearchPage extends CommonMethods {

    @FindBy(id="empsearch_id")
    public WebElement empIdTextBox;

    @FindBy(id="searchBtn")
    public WebElement searchButton;

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement empSearchNameField;

    public EmployeeSearchPage(){
        PageFactory.initElements(driver, this);
    }
}
