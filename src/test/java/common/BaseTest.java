package common;

import com.drivers.DriverManager;
import com.helpers.PropertiesHelper;
import com.keywors.WebUI;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class BaseTest {


    public SoftAssert softAssert;
    @BeforeSuite
    public  void setupBeforeSuite() {
//        System.out.println("-----Bắt đầu suite test-----");
//        PropertiesHelper.loadAllFiles();
    }

    @BeforeMethod
    @Parameters({"browersName"})
    public void createDriver(@Optional("chrome") String browersName) {
        System.out.println("Khởi tạo trình duyệt Chrome");
        WebDriver driver;

        if (PropertiesHelper.getValue("browser").isEmpty()|| PropertiesHelper.getValue("browser")== null){
            browersName = browersName;
        } else {
            browersName = PropertiesHelper.getValue("browser");
        }

        switch (browersName.trim().toLowerCase()) {
            case "chrome":
                System.out.println("Launching Chrome browser...");
                ChromeOptions option = new ChromeOptions();
                if(PropertiesHelper.getValue("headless").equalsIgnoreCase("true")) {
                    option.addArguments("--headless=new"); // chay headless
                    option.addArguments("--window-size=1920,1080"); // set kich thuoc cua trinh duyet
                }
                driver = new ChromeDriver(option);

                break;
            case "edge":
                System.out.println("Launching Edge browser...");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Launching " + browersName + " browser...");
                driver = new ChromeDriver();
                break;
        }
        DriverManager.setDriver(driver);
        if(PropertiesHelper.getValue("headless").equalsIgnoreCase("false")) {
            DriverManager.getDriver().manage().window().maximize();
        }
//        DriverManager.getDriver().manage().window().maximize(); // Tự đông truy xuat gtri driver theo luồng
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        softAssert = new SoftAssert();
    }


    @AfterMethod (alwaysRun = true)
    public void closeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
            System.out.println("Đóng trình duyệt nhennn");
        }
        softAssert.assertAll();
    }


    //    @BeforeMethod
//    public void createDriver() throws InterruptedException {
//        System.out.println("Khởi tạo trình duyệt Chrome");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        softAssert = new SoftAssert();
//    }
//
//    @AfterMethod
//    public void closeDriver(WebDriver driver) {
//        if (driver != null) {
//            driver.quit();
//            System.out.println("Đóng trình duyệt nhennn");
//        }
//        softAssert.assertAll();
//    }


}
