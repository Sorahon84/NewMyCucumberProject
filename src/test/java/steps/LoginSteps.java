package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {
    //public static WebDriver driver;
    LoginPage loginPage = new LoginPage();

    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {
        // driver = new ChromeDriver();
        //driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.manage().window().maximize();
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        // WebElement userName = driver.findElement(By.id("txtUsername"));
        //userName.sendKeys("Admin");
        sendText(ConfigReader.read("userName"),loginPage.userName);

        // WebElement passwordName = driver.findElement(By.id("txtPassword"));
        //passwordName.sendKeys("Hum@nhrm123");
        sendText(ConfigReader.read("password"),loginPage.passwordName);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
       // WebElement loginButton = driver.findElement(By.id("btnLogin"));
        //loginButton.click();
        click(loginPage.loginButton);


    }

    @Then("user is navigated to dashbaord page")
    public void user_is_navigated_to_dashbaord_page() {
        Assert.assertTrue(dashboardPage.welcomeText.isDisplayed());
        System.out.println("test passed");
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        //WebElement userName = driver.findElement(By.id("txtUsername"));
        //userName.sendKeys("admin");
        sendText("admin", loginPage.userName);
        //WebElement passwordName = driver.findElement(By.id("txtPassword"));
        //passwordName.sendKeys("Hum@nhrm12345677");
        sendText("hum@123",loginPage.passwordName);
    }

    @Then("user can see error message")
    public void user_can_see_error_message() {
        String actualMessage = loginPage.errorMessage.getText();
        Assert.assertEquals("Invalid credentials", actualMessage);


    }


}
