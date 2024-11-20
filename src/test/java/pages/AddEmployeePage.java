package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id="firstName")
    public WebElement firstNameLocator;

    @FindBy(id="middleName")
    public WebElement middleNameLocator;

    @FindBy(id="lastName")
    public WebElement lastNameLocator;

    @FindBy(id="btnSave")
    public WebElement saveButton;


    @FindBy(id = "employeeId")
    public WebElement employeeIDField;

   // @FindBy(xpath = "//input[@name='employeeId']")
    //public WebElement employeeId;


    // @FindBy(xpath=''//table[@id='resultTable']/tbody/tr/td[3]")
    //public WebElement employeelidNextButton;


    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }


}
//(xpath=''//table[@id='resultTable']/tbody/tr/td[3]")