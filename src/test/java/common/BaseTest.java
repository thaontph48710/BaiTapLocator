package common;

import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class BaseTest {

    public WebDriver driver;
    public SoftAssert softAssert;

    @BeforeMethod
    public void createDriver() throws InterruptedException {
        System.out.println("Khởi tạo trình duyệt Chrome");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            System.out.println("Đóng trình duyệt nhennn");
        }
        softAssert.assertAll();
    }


}
