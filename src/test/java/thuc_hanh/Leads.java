package thuc_hanh;

import com.thaotest.WebUI;
import common.BaseTest;
import bai_tap_locators.LocatorsLeadsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static bai_tap_locators.LocatorsLeadsCRM.*;


public class Leads extends BaseTest {

    public static  void openLeads() throws InterruptedException {
        System.out.println("Open Page Leads");
        WebUI.clickElement(driver, LocatorsLeadsCRM.menuLeads);
//        driver.findElement(By.xpath(LocatorsLeadsCRM.menuLeads)).click();


        WebUI.clickElement(driver, buttonLeadsSummary);
//        driver.findElement(By.xpath(buttonLeadsSummary)).click();
        Thread.sleep(1000);

        Assert.assertTrue(WebUI.checkExistsElement(driver, titleLeadsSummary), "FAIL: Không mở được trang Leads");
        }

        public static void clickButtonNewLeads() throws InterruptedException {
        WebUI.clickElement(driver, buttonNewLeads);
//            driver.findElement(By.xpath(LocatorsLeadsCRM.buttonNewLeads)).click();
            Thread.sleep(2000);
            Assert.assertTrue(WebUI.checkExistsElement(driver,LocatorsLeadsCRM.headerAddNewLead), "FAIL: Không mở được popup Add New Leads");
        }


    public static void fillDate(String status, String dropdownSource, String dropdownAssigned, String dropdownTag, String leadsNameTest, String address, String position,
                                   String city, String emailAddress, String state, String website, String country, String phone, String zipCode,
                                   String leadValue, String language, String company, String description, String dateContacted, int flag, int flagEdit) throws InterruptedException {


        if (flagEdit == 1){
            System.out.println("Edit Leads");
            WebUI.clearElementText(driver, LocatorsLeadsCRM.inputTagTrong);
            WebUI.clearElementText(driver, LocatorsLeadsCRM.inputName);
            WebUI.clearElementText(driver, LocatorsLeadsCRM.inputAddress);
            WebUI.clearElementText(driver, LocatorsLeadsCRM.inputPosition);
            WebUI.clearElementText(driver, LocatorsLeadsCRM.inputCity);
            WebUI.clearElementText(driver, LocatorsLeadsCRM.inputEmailAddress);
            WebUI.clearElementText(driver, LocatorsLeadsCRM.inputWebsite);
            WebUI.clearElementText(driver, LocatorsLeadsCRM.inputPhone);
            WebUI.clearElementText(driver, LocatorsLeadsCRM.inputZipCode);
            WebUI.clearElementText(driver, LocatorsLeadsCRM.inputLeadValue);
            WebUI.clearElementText(driver, LocatorsLeadsCRM.inputCompany);
            WebUI.clearElementText(driver, LocatorsLeadsCRM.inputDescription);
            WebUI.clearElementText(driver, LocatorsLeadsCRM.inputLastContacted);




//    driver.findElement(By.xpath(inputTagTrong)).click(); // Click vào input Tag để focus
//    driver.findElement(By.xpath(LocatorsLeadsCRM.inputTagTrong)).sendKeys(Keys.BACK_SPACE);  // Clear Tag hiện tại
//    driver.findElement(By.xpath(LocatorsLeadsCRM.inputName)).clear();
//    driver.findElement(By.xpath(LocatorsLeadsCRM.inputAddress)).clear();
//    driver.findElement(By.xpath(LocatorsLeadsCRM.inputPosition)).clear();
//    driver.findElement(By.xpath(LocatorsLeadsCRM.inputCity)).clear();
//    driver.findElement(By.xpath(LocatorsLeadsCRM.inputEmailAddress)).clear();
//    driver.findElement(By.xpath(LocatorsLeadsCRM.inputState)).clear();
//    driver.findElement(By.xpath(LocatorsLeadsCRM.inputWebsite)).clear();
//    driver.findElement(By.xpath(LocatorsLeadsCRM.inputPhone)).clear();
//    driver.findElement(By.xpath(LocatorsLeadsCRM.inputZipCode)).clear();
//    driver.findElement(By.xpath(LocatorsLeadsCRM.inputLeadValue)).clear();
//    driver.findElement(By.xpath(LocatorsLeadsCRM.inputCompany)).clear();
//    driver.findElement(By.xpath(LocatorsLeadsCRM.inputDescription)).clear();
//    driver.findElement(By.xpath(inputLastContacted)).clear();
}else {
            System.out.println("Add New Leads");
        }



        //------------------- Xác định dropdown Status---------------------------
        // Click vào dropdown
        WebUI.clickElement(driver, LocatorsLeadsCRM.dropdownStatus);
        //Tìm kiếm giá trị cần chọn và nhấn Enter
        WebUI.setTextElement(driver, LocatorsLeadsCRM.inputStatusSearch, status);
        WebUI.clickElement(driver, LocatorsLeadsCRM.listStatus(status));

        //-----------------------Cách 2: Chỉ dùng khi giá trị mở dropdown bằng cách gọi hàm-----------------------------
        //------------------- Xác định dropdown Source---------------------------
        WebUI.clickElement(driver, LocatorsLeadsCRM.dropdownSourceButton);
        WebUI.setTextElement(driver, LocatorsLeadsCRM.inputSourceSearch, dropdownSource);
        WebUI.clickElement(driver, LocatorsLeadsCRM.listSource(dropdownSource));// Source

        //------------------- Xác định dropdown Assigned---------------------------

        WebUI.clickElement(driver, dropdownAssignedButton);
        WebUI.setTextElement(driver, inputAssignedSearch, dropdownAssigned);
        WebUI.clickElement(driver, LocatorsLeadsCRM.listAssigned(dropdownAssigned));

        //------------------- Xác định dropdown Tag---------------------------
        // Mở dropdown

        WebUI.clickElement(driver, LocatorsLeadsCRM.inputTag);
        List<WebElement> allOptionsTags = WebUI.getWebElements(driver, listdropdownTag);

        //Lấy danh sách tất cả các phần tử trong dropdown Tags
//        List<WebElement> allOptionsTags = driver.findElements(By.xpath(LocatorsLeadsCRM.listdropdownTag));
//        Thread.sleep(1000);
        // Duyệt từng WebElement trong danh sách để tìm phần tử có text = "Selenium"
        for (WebElement option : allOptionsTags) {
            if (option.getText().equals(dropdownTag)) {
                option.click();
                break;
            }
        }
    WebUI.setTextElement(driver, inputName,leadsNameTest  );
    WebUI.setTextElement(driver, inputAddress,address  );
    WebUI.setTextElement(driver, inputPosition,position  );
    WebUI.setTextElement(driver, inputCity,city  );
    WebUI.setTextElement(driver, inputEmailAddress,emailAddress  );
    WebUI.setTextElement(driver, inputState,state  );
    WebUI.setTextElement(driver, inputWebsite,website  );


        //------------------- Dropdown Country----------------------------
    WebUI.clickElement(driver, dropdownCountry);
    WebUI.setTextElement(driver, inputSearchCountry,country  );
    WebUI.clickElement(driver, listCountry(country));

        WebUI.setTextElement(driver, inputPhone,phone  );
        WebUI.setTextElement(driver, inputZipCode,zipCode  );
        WebUI.setTextElement(driver, inputLeadValue,leadValue  );



//    -------------------- Drowpdown Default Language ---------------------------
        WebUI.clickElement(driver, dropdownDefaultLanguage);
        WebUI.setTextElement(driver, inputSearchDefaultLanguage,language  );
        WebUI.clickElement(driver, listDefaultLanguage(language));
//         String xpathDefaultLanguage = listDefaultLanguage(language); // Tạo xpath tương ứng với giá trị muốn chọn
//        driver.findElement(By.xpath(xpathDefaultLanguage)).click();
//        Thread.sleep(1000);

        WebUI.setTextElement(driver, inputCompany,company  );

        WebUI.setTextElement(driver, inputDescription,description  );



        WebUI.clickElement(driver, LocatorsLeadsCRM.labelCheckboxPublic);


        if (flag == 1) {
            WebUI.clickElement(driver, LocatorsLeadsCRM.labelCheckboxContactedToday);
            Thread.sleep(1000);
          WebUI.setTextElement(driver, LocatorsLeadsCRM.inputDateContacted,dateContacted  );

        }

        WebUI.clickElement(driver, LocatorsLeadsCRM.buttonSave);

        Thread.sleep(3000);

    }

    public void clickCloseProfile() throws InterruptedException {

        WebUI.clickElement(driver, LocatorsLeadsCRM.iconCloseProfile);
        Thread.sleep(1000);
    }
    public void searchLeads(String leadsName) throws InterruptedException {

        Thread.sleep(2000);
        WebUI.clickElement(driver, LocatorsLeadsCRM.menuLeads);
        WebUI.clearElementText(driver, LocatorsLeadsCRM.inputSearch);
        WebUI.setTextElement(driver, LocatorsLeadsCRM.inputSearch,leadsName);

        String firstRowOfLeads = WebUI.getText(driver, LocatorsLeadsCRM.firstRowLeads);
        System.out.println("First row leader " + firstRowOfLeads);
        Thread.sleep(6000);
    }





    public void verifyNewLeadInEdit( String status, String source, String assigned, String tag, String leadName, String address, String position,
                                         String city, String emailAddress, String state, String website, String country, String phone, String zipCode,
                                         String leadValue, String language, String company, String description, String dateContacted, int flag) throws InterruptedException {




        // Status ]

        String actualStatus =WebUI.getText(driver,LocatorsLeadsCRM.dropdownStatus).trim();

        Assert.assertTrue(actualStatus.contains(status), "FAIL: Status không chứa giá trị mong muốn. Expected fragment: " + status + " Actual: " + actualStatus);


        // Source
        String actualSource = WebUI.getText(driver, dropdownSourceButton).trim();
        Assert.assertEquals(actualSource, source, "FAIL: Source không khớp.");


        String actualAssigned = WebUI.getText(driver, dropdownAssignedButton).trim();
        Assert.assertEquals(actualAssigned, assigned, "FAIL: Assigned không chứa giá trị mong muốn.");


//        String actualTag = driver.findElement(By.xpath(inputTag)).getText().trim();
//        Assert.assertEquals(actualTag, tag, "FAIL: Tag không khớp.");


        String actualName = WebUI.getElementAttribute(driver,LocatorsLeadsCRM.inputName, "value").trim();
        Assert.assertEquals(actualName, leadName, "FAIL: Tên Lead không khớp.");

        String actualAddress = WebUI.getElementAttribute(driver,inputAddress,"value").trim();
        Assert.assertEquals(actualAddress, address, "FAIL: Dia chi không khớp.");

        String actualPosition = WebUI.getElementAttribute(driver,inputPosition,"value").trim();
        Assert.assertEquals(actualPosition, position, "FAIL: không khớp.");

        String actualCity = WebUI.getElementAttribute(driver,inputCity,"value").trim();
        Assert.assertEquals(actualCity, city, "FAIL: không khớp.");

        String actualEmail = WebUI.getElementAttribute(driver,inputEmailAddress,"value").trim();
        Assert.assertEquals(actualEmail, emailAddress, "FAIL: không khớp.");

        String actualState = WebUI.getElementAttribute(driver,inputState,"value").trim();
        Assert.assertEquals(actualState, state, "FAIL: không khớp.");

        String actualWebsite = WebUI.getElementAttribute(driver,inputWebsite,"value").trim();
        Assert.assertEquals(actualWebsite, website, "FAIL: không khớp.");

        String actualCountry = WebUI.getText(driver,dropdownCountry).trim();
        Assert.assertTrue(actualCountry.contains(country), "FAIL: country không khớp.");

        String actualphone = WebUI.getElementAttribute(driver,inputPhone,"value").trim();
        Assert.assertEquals(actualphone, phone, "FAIL: không khớp.");

        String actualZipCode = WebUI.getElementAttribute(driver,inputZipCode,"value").trim();
        Assert.assertEquals(actualZipCode, zipCode, "FAIL: không khớp.");


        String actualLeadValue = WebUI.getElementAttribute(driver,inputLeadValue,"value").trim();
        Assert.assertTrue(actualLeadValue.contains(leadValue), "FAIL: không khớp.");

        String actualLanluage =  WebUI.getText(driver,dropdownDefaultLanguage).trim();
        Assert.assertEquals(actualLanluage, language, "FAIL: không khớp.");

        String actualCompany = WebUI.getElementAttribute(driver,inputCompany,"value").trim();
        Assert.assertEquals(actualCompany, company, "FAIL: không khớp.");
        String actualDescription = WebUI.getElementAttribute(driver,inputDescription,"value").trim();
        Assert.assertEquals(actualDescription, description, "FAIL: không khớp.");


        // Checkbox Public
        if (flag==1){
            Assert.assertTrue(WebUI.checkSeletedElement(driver, LocatorsLeadsCRM.checkboxPublic), "Đang không tích chọn checkbox");

        }

        // Last Contacted (Phải xử lý substring như bạn đã làm, nhưng dùng Assert)
        String actualDateContacted = WebUI.getElementAttribute(driver,inputLastContacted,"value").trim().substring(0, 10);
        Assert.assertEquals(actualDateContacted, dateContacted, "FAIL: Last Contacted Date không khớp.");

        System.out.println("Tất cả các trường dữ liệu Lead đã được Verify thành công trong Edit Popup.");
    }


    public void clickEditButton(String leadName) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(WebUI.getWebElement(driver, LocatorsLeadsCRM.getFirstRowItemLeadName(leadName))).perform();
        WebUI.clickElement(driver,LocatorsLeadsCRM.buttonEdit(leadName));



    }

    public void clickbuttonDelete(String leadName) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(WebUI.getWebElement(driver, LocatorsLeadsCRM.getFirstRowItemLeadName(leadName))).perform();

        WebUI.clickElement(driver,LocatorsLeadsCRM.buttonDelete(leadName));

        driver.switchTo().alert().accept();
    }




    public void verifyAfterDeleteLead(String name) throws InterruptedException {
        Thread.sleep(2000);
        WebUI.setTextElement(driver, LocatorsLeadsCRM.inputSearch,name );
        Thread.sleep(1000);
        Assert.assertFalse(WebUI.checkExistsElement(driver,LocatorsLeadsCRM.getFirstRowItemLeadName(name)), "Xóa Lead không thành công");
        Thread.sleep(1000);
    }

    String  leadsNameTest = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
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

    @Test(priority = 1)
    public void testAddAndCheckNewLead() throws InterruptedException {


        openLeads();
        clickButtonNewLeads();
          leadsNameTest = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
         emailAddress = "thao" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
        fillDate(dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, leadsNameTest, address, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 1,0);

        clickCloseProfile();
        searchLeads(leadsNameTest);
        clickEditButton(leadsNameTest);

        verifyNewLeadInEdit( dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, leadsNameTest, address, position,
                city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted,1);
    }


    @Test(priority = 2)
    public void testEditLeads() throws InterruptedException {



        openLeads();
        clickButtonNewLeads();
          leadsNameTest = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
         emailAddress = "thao" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
        fillDate(dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, leadsNameTest, address, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 1,0);
        clickCloseProfile();
        searchLeads(leadsNameTest);

        String nameLead = leadsNameTest + "_Edit";
         dropdownStatus = "Active";
         dropdownSource = "Google";
        dropdownAssigned = "Admin Anh Tester";
        dropdownTag = "JSC_NEW";
        address = "Lạng Sơn";
        position = "Tester";
        city = "NODO Việt Nam";
        emailAddress = "ngocthao" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
        state = "hangocthao080604";
        website = "thao123.com.vn";
        country = "Vietnam";
        phone = "0966674789";
        zipCode = "123456789";
        leadValue = "1234566789";
        language = "Vietnamese";
        company = "NDJSC";
        description = "Edit leads cho CRM";
        lastContacted = "20-11-2025";

        clickEditButton(leadsNameTest);

    fillDate( dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, nameLead, address, position, city, emailAddress, state, website, country, phone, zipCode,
            leadValue, language, company, description, lastContacted,0,1);

        searchLeads(nameLead);
        verifyNewLeadInEdit( dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, nameLead, address, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 0);

    }

    @Test(priority = 3)
    public void testDeleteLeads() throws InterruptedException {


//        String  leadsNameTest = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
//        String dropdownStatus = "Customer";
//        String dropdownSource = "Facebook";
//        String dropdownAssigned = "Admin Anh Tester";
//        String dropdownTag = "Selenium";
//        String address = "Hà Nội";
//        String position = "Tester";
//        String city = "Việt Nam";
//        String emailAddress = "thao" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
//        String state = "hangocthao";
//        String website = "thao.com.vn";
//        String country = "Vietnam";
//        String phone = "0966674456";
//        String zipCode = "123456";
//        String leadValue = "123456";
//        String language = "Vietnamese";
//        String company = "NDJSC";
//        String description = "Them moi leads cho CRM";
//        String lastContacted = "10-11-2025";

        openLeads();
        clickButtonNewLeads();
        leadsNameTest = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        emailAddress = "thao" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";

        fillDate(dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, leadsNameTest, address, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 1,0);
        clickCloseProfile();
        searchLeads(leadsNameTest);

        clickbuttonDelete(leadsNameTest);
        clickCloseProfile();
        verifyAfterDeleteLead(leadsNameTest);



    }






}
