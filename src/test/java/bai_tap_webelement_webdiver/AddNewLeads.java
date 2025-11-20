package bai_tap_webelement_webdiver;

import leads.LocatorsLeadsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.Alert;

import static leads.LocatorsLeadsCRM.*;

public class AddNewLeads extends LoginCRM {

    public static void addNewLeads(String status, String dropdownSource, String dropdownAssigned, String dropdownTag, String leadsNameTest, String address, String position,
                                   String city, String emailAddress, String state, String website, String country, String phone, String zipCode,
                                   String leadValue, String language, String company, String description, String dateContacted, int flag) throws InterruptedException {
        System.out.println("Open Page Leads");
        driver.findElement(By.xpath(LocatorsLeadsCRM.menuLeads)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonNewLeads)).click();
        Thread.sleep(2000);
        System.out.println("Add New Leads");
        //------------------- Xác định dropdown Status---------------------------
        // Click vào dropdown
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownStatus)).click();
        Thread.sleep(1000);
        //Tìm kiếm giá trị cần chọn và nhấn Enter
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputStatusSearch )).sendKeys(status);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeadsCRM.listStatus(status))).click();
        Thread.sleep(2000);

        //-----------------------Cách 2: Chỉ dùng khi giá trị mở dropdown bằng cách gọi hàm-----------------------------
        //------------------- Xác định dropdown Source---------------------------
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownSourceButton)).click();  // Source
        Thread.sleep(1000);
        String xpathSource = listSource(dropdownSource);
        driver.findElement(By.xpath(xpathSource)).click();
        Thread.sleep(1000);
        //------------------- Xác định dropdown Assigned---------------------------
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownAssignedButton)).click();   // Assigned
        Thread.sleep(1000);
       driver.findElement(By.xpath(LocatorsLeadsCRM.inputAssignedSearch)).sendKeys(dropdownAssigned,Keys.ENTER);
        Thread.sleep(1000);
        //------------------- Xác định dropdown Tag---------------------------
        // Mở dropdown
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputTag)).click();  // Tag
        Thread.sleep(1000);
        //Lấy danh sách tất cả các phần tử trong dropdown Tags
        List<WebElement> allOptionsTags = driver.findElements(By.xpath(LocatorsLeadsCRM.listdropdownTag));
        Thread.sleep(1000);
        // Duyệt từng WebElement trong danh sách để tìm phần tử có text = "Selenium"
        for (WebElement option : allOptionsTags) {
            if (option.getText().equals(dropdownTag)) {
                option.click();
                break;
            }
        }
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputName)).sendKeys(leadsNameTest);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputAddress)).sendKeys(address);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPosition)).sendKeys(position);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputCity)).sendKeys(city);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputEmailAddress)).sendKeys(emailAddress);
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputState)).sendKeys(state);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputWebsite)).sendKeys(website);
        Thread.sleep(1000);

        //------------------- Dropdown Country----------------------------

        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownCountry)).click(); // Click mở dropdown Country
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearchCountry)).sendKeys(country);  // Nhập từ khóa cần tìm vào ô search --> để lọc danh sách=
        String xpathCountry = listCountry(country); // Tạo xpath tương ứng với giá trị muốn chọn
        Thread.sleep(1000);
        driver.findElement(By.xpath(xpathCountry)).click(); //Tìm phần tử tương ứng và click
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPhone)).sendKeys(phone);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputZipCode)).sendKeys(zipCode);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputLeadValue)).sendKeys(leadValue);
        Thread.sleep(1000);


//    -------------------- Drowpdown Default Language ---------------------------
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownDefaultLanguage)).click(); // Click mở dropdown Default Language
        Thread.sleep(1000);
         String xpathDefaultLanguage = listDefaultLanguage(language); // Tạo xpath tương ứng với giá trị muốn chọn
        driver.findElement(By.xpath(xpathDefaultLanguage)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputCompany)).sendKeys(company);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputDescription)).sendKeys(description);
        Thread.sleep(1000);


            driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxPublic)).click();
        Thread.sleep(1000);

        if (flag == 1) {
            driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxContactedToday)).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath(LocatorsLeadsCRM.inputDateContacted)).sendKeys(dateContacted);
            Thread.sleep(1000);
        }
        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonSave)).click();

        Thread.sleep(3000);

    }
    public void searchLeadsNewAdd(String leadsName) throws InterruptedException {
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


    public void searchLeadsEdit(String leadsName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsLeadsCRM.menuLeads)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).sendKeys(leadsName);
        Thread.sleep(2000);
        String firstRowOfLeads = driver.findElement(By.xpath(LocatorsLeadsCRM.firstRowLeads)).getText();
        System.out.println("First row leader " + firstRowOfLeads);
        Thread.sleep(6000);
    }



    public void verifyNewLeadInEdit( String status, String source, String assigned, String tag, String leadName, String address, String position,
                                         String city, String emailAddress, String state, String website, String country, String phone, String zipCode,
                                         String leadValue, String language, String company, String description, String dateContacted, int flag) throws InterruptedException {

//         1. Mở popup Edit
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(LocatorsLeadsCRM.getFirstRowItemLeadName(leadName)))).perform();
        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonEdit(leadName))).click();
        Thread.sleep(2000);


        // Status ]
        String actualStatus = driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownStatus)).getText().trim();
        Assert.assertTrue(actualStatus.contains(status), "FAIL: Status không chứa giá trị mong muốn. Expected fragment: " + status + " Actual: " + actualStatus);

        // Source
        String actualSource = driver.findElement(By.xpath(dropdownSourceButton)).getText().trim();
        Assert.assertEquals(actualSource, source, "FAIL: Source không khớp.");


        String actualAssigned = driver.findElement(By.xpath(dropdownAssignedButton)).getText().trim();
        Assert.assertEquals(actualAssigned, assigned, "FAIL: Assigned không chứa giá trị mong muốn.");


//        String actualTag = driver.findElement(By.xpath(inputTag)).getText().trim();
//        Assert.assertEquals(actualTag, tag, "FAIL: Tag không khớp.");


        String actualName = driver.findElement(By.xpath(LocatorsLeadsCRM.inputName)).getAttribute("value").trim();
        Assert.assertEquals(actualName, leadName, "FAIL: Tên Lead không khớp.");

        String actualAddress = driver.findElement(By.xpath(inputAddress)).getAttribute("value").trim();
        Assert.assertEquals(actualAddress, address, "FAIL: Dia chi không khớp.");

        String actualPosition = driver.findElement(By.xpath(inputPosition)).getAttribute("value").trim();
        Assert.assertEquals(actualPosition, position, "FAIL: không khớp.");

        String actualCity = driver.findElement(By.xpath(inputCity)).getAttribute("value").trim();
        Assert.assertEquals(actualCity, city, "FAIL: không khớp.");

        String actualEmail = driver.findElement(By.xpath(inputEmailAddress)).getAttribute("value").trim();
        Assert.assertEquals(actualEmail, emailAddress, "FAIL: không khớp.");

        String actualState = driver.findElement(By.xpath(inputState)).getAttribute("value").trim();
        Assert.assertEquals(actualState, state, "FAIL: không khớp.");

        String actualWebsite = driver.findElement(By.xpath(inputWebsite)).getAttribute("value").trim();
        Assert.assertEquals(actualWebsite, website, "FAIL: không khớp.");

        String actualCountry = driver.findElement(By.xpath(dropdownCountry)).getText().trim();
        Assert.assertTrue(actualCountry.contains(country), "FAIL: country không khớp.");

        String actualphone = driver.findElement(By.xpath(inputPhone)).getAttribute("value").trim();
        Assert.assertEquals(actualphone, phone, "FAIL: không khớp.");

        String actualZipCode = driver.findElement(By.xpath(inputZipCode)).getAttribute("value").trim();
        Assert.assertEquals(actualZipCode, zipCode, "FAIL: không khớp.");


        String actualLeadValue = driver.findElement(By.xpath(inputLeadValue)).getAttribute("value").trim();
        Assert.assertTrue(actualLeadValue.contains(leadValue), "FAIL: không khớp.");

        String actualLanluage = driver.findElement(By.xpath(dropdownDefaultLanguage)).getText().trim();
        Assert.assertEquals(actualLanluage, language, "FAIL: không khớp.");

        String actualCompany = driver.findElement(By.xpath(inputCompany)).getAttribute("value").trim();
        Assert.assertEquals(actualCompany, company, "FAIL: không khớp.");
        String actualDescription = driver.findElement(By.xpath(inputDescription)).getAttribute("value").trim();
        Assert.assertEquals(actualDescription, description, "FAIL: không khớp.");

        // Checkbox Public
        if (flag==1){
        boolean isPublicChecked = driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxPublic)).isSelected();
        Assert.assertTrue(isPublicChecked, "FAIL: Checkbox Public không được chọn.");
        }

        // Last Contacted (Phải xử lý substring như bạn đã làm, nhưng dùng Assert)
        String actualDateContacted = driver.findElement(By.xpath(inputLastContacted)).getAttribute("value").trim().substring(0, 10);
        Assert.assertEquals(actualDateContacted, dateContacted, "FAIL: Last Contacted Date không khớp.");

        System.out.println("Tất cả các trường dữ liệu Lead đã được Verify thành công trong Edit Popup.");
    }


    public void clickEditButton(String leadName) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(LocatorsLeadsCRM.getFirstRowItemLeadName(leadName)))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonEdit(leadName))).click();
        Thread.sleep(2000);
    }

    public static void editLeads(String status, String dropdownSource, String dropdownAssigned, String dropdownTag, String leadsNameTest, String address, String position,
                                   String city, String emailAddress, String state, String website, String country, String phone, String zipCode,
                                   String leadValue, String language, String company, String description, String lastContacted) throws InterruptedException {



        System.out.println("Chinh sua du lieu Leads");
        //------------------- Xác định dropdown Status---------------------------
        // Click vào dropdown
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownStatus)).click();
        Thread.sleep(2000);
        //Tìm kiếm giá trị cần chọn và nhấn Enter
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputStatusSearch )).sendKeys(status);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeadsCRM.listStatus(status))).click();
        Thread.sleep(2000);

        //-----------------------Cách 2: Chỉ dùng khi giá trị mở dropdown bằng cách gọi hàm-----------------------------
        //------------------- Xác định dropdown Source---------------------------
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownSourceButton)).click();  // Source
        Thread.sleep(2000);
        String xpathSource = listSource(dropdownSource);
        driver.findElement(By.xpath(xpathSource)).click();
        Thread.sleep(2000);
        //------------------- Xác định dropdown Assigned---------------------------
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownAssignedButton)).click();   // Assigned
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputAssignedSearch)).sendKeys(dropdownAssigned,Keys.ENTER);
        Thread.sleep(2000);
        //------------------- Xác định dropdown Tag---------------------------
        // Mở dropdown
        driver.findElement(By.xpath(inputTagTrong)).click(); // Click vào input Tag để focus
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputTagTrong)).sendKeys(Keys.BACK_SPACE);  // Clear Tag hiện tại
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputTag)).click();  // Tag
        Thread.sleep(2000);
        //Lấy danh sách tất cả các phần tử trong dropdown Tags
        List<WebElement> allOptionsTags = driver.findElements(By.xpath(LocatorsLeadsCRM.listdropdownTag));
        Thread.sleep(2000);
        // Duyệt từng WebElement trong danh sách để tìm phần tử có text = "Selenium"
        for (WebElement option : allOptionsTags) {
            if (option.getText().equals(dropdownTag)) {
                option.click();
                break;
            }
        }
        Thread.sleep(2000);



        driver.findElement(By.xpath(LocatorsLeadsCRM.inputName)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputName)).sendKeys(leadsNameTest);
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputAddress)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputAddress)).sendKeys(address);
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPosition)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPosition)).sendKeys(position);
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputCity)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputCity)).sendKeys(city);
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputEmailAddress)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputEmailAddress)).sendKeys(emailAddress);
        Thread.sleep(2000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputState)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputState)).sendKeys(state);
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputWebsite)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputWebsite)).sendKeys(website);
        Thread.sleep(2000);

        //------------------- Dropdown Country----------------------------

        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownCountry)).click(); // Click mở dropdown Country
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearchCountry)).sendKeys(country);  // Nhập từ khóa cần tìm vào ô search --> để lọc danh sách=
        String xpathCountry = listCountry(country); // Tạo xpath tương ứng với giá trị muốn chọn
        Thread.sleep(2000);
        driver.findElement(By.xpath(xpathCountry)).click(); //Tìm phần tử tương ứng và click
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPhone)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPhone)).sendKeys(phone);
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputZipCode)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputZipCode)).sendKeys(zipCode);
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputLeadValue)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputLeadValue)).sendKeys(leadValue);
        Thread.sleep(2000);


//    -------------------- Drowpdown Default Language ---------------------------
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownDefaultLanguage)).click(); // Click mở dropdown Default Language
        Thread.sleep(1000);
        String xpathDefaultLanguage = listDefaultLanguage(language); // Tạo xpath tương ứng với giá trị muốn chọn
        driver.findElement(By.xpath(xpathDefaultLanguage)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputCompany)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputCompany)).sendKeys(company);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputDescription)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputDescription)).sendKeys(description);
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxPublic)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(inputLastContacted)).clear();
        driver.findElement(By.xpath(inputLastContacted)).sendKeys(lastContacted);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonSave)).click();

        Thread.sleep(3000);

    }





    static String  leadsNameTest = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
    @Test(priority = 1)
    public void testAddAndCheckNewLead() throws InterruptedException {

        String dropdownStatus = "Customer";
        String dropdownSource = "Facebook";
        String dropdownAssigned = "Admin Anh Tester";
        String dropdownTag = "Selenium";
        String address = "Hà Nội";
        String position = "Tester";
        String city = "Việt Nam";
        String emailAddress = "thao" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
        String state = "hangocthao";
        String website = "thao.com.vn";
        String country = "Vietnam";
        String phone = "0966674456";
        String zipCode = "123456";
        String leadValue = "123456";
        String language = "Vietnamese";
        String company = "NDJSC";
        String description = "Them moi leads cho CRM";
        String lastContacted = "10-11-2025";

        addNewLeads(dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, leadsNameTest, address, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 1);

        searchLeadsNewAdd(leadsNameTest);
//        clickEditButton(leadsNameTest);

        verifyNewLeadInEdit( dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, leadsNameTest, address, position,
                city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted,1);
    }

    @Test(priority = 2)
    public void testEditLeads() throws InterruptedException {
        System.out.println("Open Page Leads");
        driver.findElement(By.xpath(LocatorsLeadsCRM.menuLeads)).click();
        Thread.sleep(1000);

        searchLeadsEdit(leadsNameTest);

        String nameLead = leadsNameTest + "_Edit";
        String dropdownStatus = "Active";
        String dropdownSource = "Google";
        String dropdownAssigned = "Admin Anh Tester";
        String dropdownTag = "JSC_NEW";
        String address = "Lạng Sơn";
        String position = "Tester";
        String city = "NODO Việt Nam";
        String emailAddress = "ngocthao" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
        String state = "hangocthao080604";
        String website = "thao123.com.vn";
        String country = "Vietnam";
        String phone = "0966674789";
        String zipCode = "123456789";
        String leadValue = "1234566789";
        String language = "Vietnamese";
        String company = "NDJSC";
        String description = "Edit leads cho CRM";
        String lastContacted = "20-11-2025";

        clickEditButton(leadsNameTest);

        editLeads( dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, nameLead, address, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted);

        searchLeadsNewAdd(nameLead);
        verifyNewLeadInEdit( dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, nameLead, address, position,
                city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 0);

    }

    @Test(priority = 3)
    public void testDeleteLeads() throws InterruptedException {
        System.out.println("Open Page Leads");
        driver.findElement(By.xpath(LocatorsLeadsCRM.menuLeads)).click();
        Thread.sleep(1000);
        String leadName = leadsNameTest + "_Edit";
        searchLeadsEdit(leadName);

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(LocatorsLeadsCRM.getFirstRowItemLeadName(leadName)))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonDelete(leadName))).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();


        driver.findElement(By.xpath(LocatorsLeadsCRM.menuLeads)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).sendKeys(leadName);
        Thread.sleep(2000);
        String noDataTable = driver.findElement(By.xpath(checkDelete)).getText().trim();
        Assert.assertEquals(noDataTable, "No matching records found", "FAIL: Lead không bị xóa.");


    }






}
