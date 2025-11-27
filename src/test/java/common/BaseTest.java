package common;

import bai_tap_locators.LocatorsLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class BaseTest {

    public boolean checkExistsElement(String xpathElement) {
        List<WebElement> element = driver.findElements(By.xpath(xpathElement));
        if (element.size() > 0) {
            System.out.println("Phần tử tồn tại: " + xpathElement);
            return true;
        } else {
            System.out.println("Phần tử không tồn tại: " + xpathElement);
            return false;
        }
    }

     public static WebDriver driver;
@BeforeMethod
    public static void createChromeDriver() {
        System.out.println("Create Chrome Driver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginCRM();

    }

    public static void loginCRM() {
        System.out.println("Login CRM");
        driver.findElement(By.xpath(LocatorsLogin.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsLogin.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsLogin.inputPassWord)).clear();
        driver.findElement(By.xpath(LocatorsLogin.inputPassWord)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsLogin.buttonLogin)).click();
    }

@AfterMethod
    public static void closeDriver() {
        System.out.println("Close Driver");
        driver.quit();

    }
}
