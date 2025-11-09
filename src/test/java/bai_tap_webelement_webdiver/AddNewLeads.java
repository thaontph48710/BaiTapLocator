package bai_tap_webelement_webdiver;

import leads.LocatorsLeadsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static leads.LocatorsLeadsCRM.*;

public class AddNewLeads extends LoginCRM {

    public static void addNewLeads(String leadsNameTest) throws InterruptedException {
        System.out.println("Open Page Leads");
        driver.findElement(By.xpath(LocatorsLeadsCRM.menuLeads)).click();
        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonNewLeads)).click();
        Thread.sleep(2000);
        System.out.println("Add New Leads");
        //------------------- Xác định dropdown Status---------------------------
        // Click vào dropdown
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownStatus)).click();
        Thread.sleep(2000);
        //Tìm kiếm giá trị cần chọn và nhấn Enter
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputStatusSearch )).sendKeys("Customer", Keys.ENTER);
        Thread.sleep(2000);

        //-----------------------Cách 2: Chỉ dùng khi giá trị mở dropdown bằng cách gọi hàm-----------------------------
        //------------------- Xác định dropdown Source---------------------------
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownSourceButton)).click();  // Source
        Thread.sleep(2000);
        String xpathSource = listSource("Facebook");
        driver.findElement(By.xpath(xpathSource)).click();
        Thread.sleep(2000);
        //------------------- Xác định dropdown Assigned---------------------------
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownAssignedButton)).click();   // Assigned
        Thread.sleep(2000);
       driver.findElement(By.xpath(LocatorsLeadsCRM.inputAssignedSearch)).sendKeys("Admin Anh Tester",Keys.ENTER);
        Thread.sleep(2000);
        //------------------- Xác định dropdown Tag---------------------------
        // Mở dropdown
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputTag)).click();  // Tag
        Thread.sleep(2000);
        //Lấy danh sách tất cả các phần tử trong dropdown Tags
        List<WebElement> allOptionsTags = driver.findElements(By.xpath(LocatorsLeadsCRM.listdropdownTag));
        Thread.sleep(2000);
        // Duyệt từng WebElement trong danh sách để tìm phần tử có text = "Selenium"
        for (WebElement option : allOptionsTags) {
            if (option.getText().equals("Selenium")) {
                option.click();
                break;
            }
        }
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputName)).sendKeys(leadsNameTest);
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputAddress)).sendKeys("My Dinh");
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPosition)).sendKeys("Tester");
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputCity)).sendKeys("Ha Noi");
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputEmailAddress)).sendKeys("theooonguyenthanh3@gmail.com");
        Thread.sleep(2000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputState)).sendKeys("Nam Từ Liêm");
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputWebsite)).sendKeys("https://crm.anhtester.com/admin/leads");
        Thread.sleep(2000);

        //------------------- Dropdown Country----------------------------

        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownCountry)).click(); // Click mở dropdown Country
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearchCountry)).sendKeys("Vietnam");  // Nhập từ khóa cần tìm vào ô search --> để lọc danh sách=
        String xpathCountry = listCountry("Vietnam"); // Tạo xpath tương ứng với giá trị muốn chọn
        Thread.sleep(2000);
        driver.findElement(By.xpath(xpathCountry)).click(); //Tìm phần tử tương ứng và click
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPhone)).sendKeys("0328765567");
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputZipCode)).sendKeys("221113");
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputLeadValue)).sendKeys("221");
        Thread.sleep(2000);


//    -------------------- Drowpdown Default Language ---------------------------
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownDefaultLanguage)).click(); // Click mở dropdown Default Language
        Thread.sleep(2000);
         String xpathDefaultLanguage = listDefaultLanguage("Vietnamese");
        driver.findElement(By.xpath(xpathDefaultLanguage)).click();
        Thread.sleep(2000);



        driver.findElement(By.xpath(LocatorsLeadsCRM.inputCompany)).sendKeys("HaNgocThao080604");
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputDescription)).sendKeys("HaNgocThaoNe");
        Thread.sleep(2000);


        boolean isPublicSelected = driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxPublic)).isSelected();
        if (isPublicSelected == false) {
            driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxPublic)).click();
        }
        Thread.sleep(2000);

        boolean isContactedTodaySelected = driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxContactedToday)).isSelected();
        if (isContactedTodaySelected == true) {
            driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxContactedToday)).click();
        }
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputDateContacted)).sendKeys("8/11/2025");
        Thread.sleep(2000);




        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonSave)).click();

        Thread.sleep(5000);






    }
    public static void searchLeadsNewAdd(String leadsName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsLeadsCRM.iconCloseProfile)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.menuLeads)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).sendKeys(leadsName);
        Thread.sleep(2000);
        String firstRowOfLeads = driver.findElement(By.xpath(LocatorsLeadsCRM.firstRowLeads)).getText();
        System.out.println("First row leader " + firstRowOfLeads);
        Thread.sleep(6000);
    }


    public static void main(String[] args) throws InterruptedException {
        createChromeDriver();
        loginCRM();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String currentDateTime = now.format(formatter);
        addNewLeads("HangocThao " + currentDateTime);
        searchLeadsNewAdd("HangocThao " + currentDateTime);

        driver.quit();
    }

}
