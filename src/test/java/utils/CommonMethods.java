package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.Constants;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods extends PageIntializer {
    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication() throws IOException {
        // decide the browser
        switch (ConfigReader.read("browser")){
            case "Chrome":
                //ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless");
                driver=new ChromeDriver();
                break;
            case "FireFox":
                driver=new FirefoxDriver();
                break;
            case "Edge":
                driver=new EdgeDriver();
                break;
            case "Safari":
                driver=new SafariDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser Name");
        }
//       maximize the window
        driver.manage().window().maximize();
//        go to the url
        driver.get(ConfigReader.read("url"));
//        implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // this , methods will call all the objects
        initializePageObjects();
    }


    public static void closeBrowser(){
        if(driver!=null){
            driver.quit();
        }
    }

    public void sendText(String text , WebElement element){
        element.clear();
        element.sendKeys(text);
    }

    public  static  void selectFromDropDown(WebElement dropDown,String visibleText){
        Select sel=new Select(dropDown);
        sel.selectByVisibleText(visibleText);
    }

    public  static  void selectFromDropDown(String value, WebElement dropDown){
        Select sel=new Select(dropDown);
        sel.selectByValue(value);
    }

    public  static  void selectFromDropDown(WebElement dropDown,int index){
        Select sel=new Select(dropDown);
        sel.selectByIndex(index);
    }

    public  static WebDriverWait getwait(){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return  wait;
    }

    public static void waitForElementToBeClickable(WebElement element){
        getwait().until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void click(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }

    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click();",element);

    }

    public static byte[] takeScreenshot(String fileName){

        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        //it is not going to take another screenshot, instead it will consider picByte
        //i.e. array of byte as a source file for transfer
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File
                    (Constants.SCREENSHOT_FILEPATH+fileName+
                            " "+ getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern){

        Date date = new Date();
        //yyyy-MM-dd-hh-mm-ss
        //dd-MM-yyyy-mm-hh-ss
        //to get the date in my acceptable format, i need to format it
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return sdf.format(date);

    }

}
