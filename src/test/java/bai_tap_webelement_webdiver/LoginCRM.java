package bai_tap_webelement_webdiver;

import leads.LocatorsLeadsCRM;
import leads.LocatorsLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginCRM {
    static WebDriver driver;

public static void createChromeDriver() {
    System.out.println("Create Chrome Driver");
   driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://crm.anhtester.com/admin/authentication");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


}

public static void loginCRM() {
    System.out.println("Login CRM");
    driver.findElement(By.xpath(LocatorsLogin.inputEmail)).clear();
    driver.findElement(By.xpath(LocatorsLogin.inputEmail)).sendKeys("admin@example.com");
    driver.findElement(By.xpath(LocatorsLogin.inputPassWord)).clear();
    driver.findElement(By.xpath(LocatorsLogin.inputPassWord)).sendKeys("123456");
    driver.findElement(By.xpath(LocatorsLogin   .buttonLogin)).click();
}

}
