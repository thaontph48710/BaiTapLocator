package pages;

import com.thaotest.WebUI;
import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class LeadsPage extends BasePage {
    private WebDriver driver;

    public LeadsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }


    private By labelLeadTotalCustomer = By.xpath("//div[@class='clearfix']/following-sibling::div//span[normalize-space()='Customer']/preceding-sibling::span");
    private By labelLeadTotalActive = By.xpath("//span[normalize-space()='Active']//preceding-sibling::span");


    //Menu LeadsTest
    public By menuLeads = By.xpath("//span[@class='menu-text' and normalize-space()='Leads']");
    // Xpath Button of LeadsTest

    private By buttonNewLeads = By.xpath(" //a[normalize-space()='New Lead']");
    private By buttonLeadsSummary = By.xpath(" //a[@data-title='Leads Summary']");
    private By buttonKanban = By.xpath(" //a[@data-title='Switch to Kanban']");
    private By buttonFilterBy = By.xpath(" //button[normalize-space()='Filter by']");
    private By buttoExport = By.xpath(" //button[normalize-space()='Export']");
    private By buttonBulkActions = By.xpath("//button[normalize-space()='Bulk Actions']");
    private By buttonReload = By.xpath(" //button[@data-original-title='Reload']");
    private By dropdownLength = By.xpath(" //select[@name='leads_length']");

    private By inputSearch = By.xpath("//div[@id='leads_filter']//input[@type='search']");

    private By headerAddNewLead = By.xpath(" //h4[normalize-space()='Add new lead']");
    //Header
    private By labelCheckboxPublic = By.xpath("//label[@for='lead_public']");
    private By labelCheckboxContactedToday = By.xpath("//label[normalize-space()='Contacted Today']");

    private By titleLeadsSummary = By.xpath(" //h4[normalize-space()='LeadsTest Summary']");
    private By titleActive = By.xpath(" //div[contains(@class,'leads-overview')]//span[normalize-space()='Active']");
    private By numberValueActive = By.xpath(" //div[contains(@class,'leads-overview')]//span[normalize-space() = 'Active']/preceding-sibling::span");
    private By titleCutomes = By.xpath(" //div[contains(@class,'leads-overview')]//span[normalize-space() = 'Customer']");
    private By numberValueCustomer = By.xpath(" //div[contains(@class,'leads-overview')]//span[normalize-space() = 'Customer']/preceding-sibling::span");

    //Xpath table
    private By checkboxAll = By.xpath(" //input[@id='mass_select_all']");
    private By labelSTT = By.xpath(" //th[@id='th-number']");
    private By labelName = By.xpath(" //th[@id='th-name']");
    private By labelCompany = By.xpath(" //th[@id='th-company']");
    private By labelEmailTable = By.xpath(" //th[@id='th-email']");
    private By labelPhone = By.xpath(" //th[@id='th-phone']");
    private By labelValue = By.xpath(" //th[@id='th-lead-value']");
    private By labelTags = By.xpath(" //th[@id='th-tags']");
    private By labelAssigned = By.xpath(" //th[@id='th-assigned']");
    private By labelStatus = By.xpath(" //th[@id='th-status']");
    private By labelSource = By.xpath(" //th[@id='th-source']");
    private By labelLastContact = By.xpath(" //th[@id='th-last-contact']");
    private By labelCreated = By.xpath(" //th[@id='th-date-created']");

    private By buttonView(String leadName) {
        By buttonView = By.xpath(" //td[./a[normalize-space()='" + leadName + "']]//a[normalize-space()='View']");
        return buttonView;
    }

    private By buttonEdit(String leadName) {
        By buttonEdit = By.xpath(" //td[./a[normalize-space()='" + leadName + "']]//a[normalize-space()='Edit']");
        return buttonEdit;
    }

    private By buttonDelete(String leadName) {
        By buttonDelete = By.xpath(" //td[./a[normalize-space()='" + leadName + "']]//a[normalize-space()='Delete']");
        return buttonDelete;
    }

    private By checkDelete = By.xpath(" //td[@class='dataTables_empty']");


    // ====== Add New Lead Form ======
    private By btnAddLead = By.xpath(" //a[normalize-space()='New Lead']");
    private By titleAddNewLead = By.xpath(" //h4[normalize-space() ='Add new lead']");

    private By labelStatusAdd = By.xpath(" //label[@for='status']");
    private By dropdownStatus = By.xpath(" //button[@data-id='status']");
    private By inputStatusSearch = By.xpath(" //button[@data-id='status']/following-sibling::div//input");

    private By listStatus(String value) {
        By xpath = By.xpath(" //button[@data-id='status']/following-sibling::div//span[contains(normalize-space(),'" + value + "')]");
        return xpath;
    }


    private By labelSourceAdd = By.xpath(" //label[@for='source']");
    private By dropdownSourceButton = By.xpath(" //button[@data-id='source']");
    private By inputSourceSearch = By.xpath(" //button[@data-id='source']/following-sibling::div//input");

    private By listSource(String value) {
        By listSource = By.xpath(" //button[@data-id='source']/following-sibling::div//span[normalize-space()='" + value + "']");
        return listSource;
    }


    private By labelAssignedAdd = By.xpath(" //label[@for='assigned']");
    private By dropdownAssignedButton = By.xpath(" //button[@data-id='assigned']");
    private By inputAssignedSearch = By.xpath(" //div[@class='dropdown bootstrap-select bs3 open']//input[@aria-label='Search']");

    private By listAssigned(String value) {
        By listAssigned = By.xpath(" //button[@data-id='assigned']/following-sibling::div//span[normalize-space()='" + value + "']");
        return listAssigned;
    }

    private By labelTag = By.xpath(" //label[normalize-space()='Tags']");
    private By closeTag = By.xpath("//div[@class='modal-body']//div[@class='tab-content']/descendant::span[@class = 'text-icon']");
    private By inputTagTrong = By.xpath(" //div[@id='inputTagsWrapper']//ul[@class='tagit ui-widget ui-widget-content ui-corner-all']//input[@type='text']");
    private By inputClearTag = By.xpath(" //div[@id='inputTagsWrapper']//li[1]");
    private By inputTag = By.xpath(" //div[@id='inputTagsWrapper']//input[@placeholder='Tag']");
    private By listdropdownTag = By.xpath(" //div[@id='inputTagsWrapper']//ul[@id='ui-id-2']/li[@class='ui-menu-item']/div");

    private By listTags(String value) {
        By listTags = By.xpath(" //div[@id='inputTagsWrapper']//div[normalize-space()='" + value + "']");
        return listTags;
    }


    private By inputName = By.xpath(" //div[@id ='tab_lead_profile']//input[@id='name']");
    private By inputAddress = By.xpath(" //textarea[@id='address']");
    private By inputPosition = By.xpath(" //input[@id='title']");
    private By labelCity = By.xpath(" //label[normalize-space()='City']");
    private By inputCity = By.xpath(" //input[@id='city']");

    private By labelEmailAddress = By.xpath(" //label[normalize-space()='Email Address']");
    private By inputEmailAddress = By.xpath(" //input[@id='email']");

    private By labelState = By.xpath(" //label[normalize-space()='State']");
    private By inputState = By.xpath(" //input[@id='state']");

    private By labelWebsite = By.xpath(" //label[normalize-space()='Website']");
    private By inputWebsite = By.xpath(" //input[@id='website']");

    private By labelCountry = By.xpath(" //label[normalize-space()='Country']");
    private By dropdownCountry = By.xpath(" //button[@data-id='country']");
    private By inputSearchCountry = By.xpath(" //button[@data-id='country']/following-sibling::div//input[@type='search']");

    private By listCountry(String value) {
        By listCountry = By.xpath(" //button[@data-id='country']/following::span[@class='text' and normalize-space()='" + value + "']");
        return listCountry;
    }

    private By labelPhoneAdd = By.xpath(" //label[normalize-space()='Phone']");
    private By inputPhone = By.xpath(" //input[@id='phonenumber']");

    private By labelZipCode = By.xpath(" //label[normalize-space()='Zip Code']");
    private By inputZipCode = By.xpath(" //input[@id='zip']");


    private By inputLeadValue = By.xpath(" //input[@name='lead_value']");
    private By iconLeadValue = By.xpath(" //div[contains(text(),'$')]");

    private By labelDefaultLanguage = By.xpath(" //label[normalize-space()='Default Language']");
    private By dropdownDefaultLanguage = By.xpath(" //button[@data-id='default_language']");
    private By inputSearchDefaultLanguage = By.xpath("//button[@data-id='default_language']/following-sibling::div//input[@type='search']");

    private By listDefaultLanguage(String value) {
        By listDefaultLanguage = By.xpath(" //button[@data-id='default_language']/following::span[@class='text' and normalize-space()='" + value + "']");
        return listDefaultLanguage;
    }

    private By labelCompanyAdd = By.xpath(" //label[normalize-space()='Company']");
    private By inputCompany = By.xpath(" //div[@app-field-wrapper='company']//input[@id='company']");

    private By labelDescription = By.xpath(" //label[normalize-space()='Description']");
    private By inputDescription = By.xpath(" //div[@app-field-wrapper='description']//textarea[@id='description']");

    private By checkboxPublic = By.xpath(" //input[@id='lead_public']");

    private By checkboxContactedToday = By.xpath(" //input[@id='contacted_today']");


    private By labelDateContacted = By.xpath(" //label[@for='custom_contact_date']");
    private By inputDateContacted = By.xpath(" //input[@id='custom_contact_date']");
    private By inputLastContacted = By.xpath(" //input[@id='lastcontact']");


    private By firstRowLeads = By.xpath(" //table[@id='leads']//tbody/tr[1]/td[3]/a");
    private By iconCloseProfile = By.xpath(" //div[@id='lead-modal']//button[@class='close']");


    private By buttonClose = By.xpath(" //div[@id ='tab_lead_profile']//button[normalize-space()='Close']");           // Close
    private By buttonSave = By.xpath(" //button[@id='lead-form-submit']");              // Save

    private By getFirstRowItemLeadName(String leadName) {
        By xpath = By.xpath(" //table[@id='leads']//a[normalize-space()='" + leadName + "']");
        return xpath;

    }

    public void clickButtonLeadsSummary() throws InterruptedException {
        WebUI.clickElement(buttonLeadsSummary);
        WebUI.sleep(1000);
    }

    public void openLeads() throws InterruptedException {
        System.out.println("Open Page LeadsTest");
        WebUI.clickElement(menuLeads);
        WebUI.clickElement(buttonLeadsSummary);
        WebUI.sleep(1000);

        Assert.assertTrue(WebUI.checkExistsElement(titleLeadsSummary), "FAIL: Không mở được trang LeadsTest");
    }

    public void clickButtonNewLeads() throws InterruptedException {
        WebUI.clickElement(buttonNewLeads);
//            driver.findElement(By.xpath(buttonNewLeads)).click();
        WebUI.sleep(1000);
        Assert.assertTrue(WebUI.checkExistsElement(headerAddNewLead), "FAIL: Không mở được popup Add New LeadsTest");
    }


    public void fillDate(String status, String dropdownSource, String dropdownAssigned, String dropdownTag, String leadsNameTest, String address, String position,
                         String city, String emailAddress, String state, String website, String country, String phone, String zipCode,
                         String leadValue, String language, String company, String description, String dateContacted, int flag, int flagEdit) throws InterruptedException {


        if (flagEdit == 1) {
            System.out.println("Edit LeadsTest");
            WebUI.clickElement(closeTag);
            WebUI.clearElementText(inputState);
            WebUI.clearElementText(inputName);
            WebUI.clearElementText(inputAddress);
            WebUI.clearElementText(inputPosition);
            WebUI.clearElementText(inputCity);
            WebUI.clearElementText(inputEmailAddress);
            WebUI.clearElementText(inputWebsite);
            WebUI.clearElementText(inputPhone);
            WebUI.clearElementText(inputZipCode);
            WebUI.clearElementText(inputLeadValue);
            WebUI.clearElementText(inputCompany);
            WebUI.clearElementText(inputDescription);
            WebUI.clearElementText(inputLastContacted);
            WebUI.setTextElement(inputLastContacted, dateContacted);

        } else {
            System.out.println("Add New LeadsTest");
        }


        //------------------- Xác định dropdown Status---------------------------
        // Click vào dropdown
        WebUI.clickElement(dropdownStatus);
        //Tìm kiếm giá trị cần chọn và nhấn Enter
        WebUI.setTextElement(inputStatusSearch, status);
        WebUI.clickElement(listStatus(status));

        //-----------------------Cách 2: Chỉ dùng khi giá trị mở dropdown bằng cách gọi hàm-----------------------------
        //------------------- Xác định dropdown Source---------------------------
        WebUI.clickElement(dropdownSourceButton);
        WebUI.setTextElement(inputSourceSearch, dropdownSource);
        WebUI.clickElement(listSource(dropdownSource));// Source

        //------------------- Xác định dropdown Assigned---------------------------

        WebUI.clickElement(dropdownAssignedButton);
        WebUI.setTextElement(inputAssignedSearch, dropdownAssigned);
        WebUI.clickElement(listAssigned(dropdownAssigned));

        //------------------- Xác định dropdown Tag---------------------------
        // Mở dropdown

        WebUI.clickElement(inputTag);
        List<WebElement> allOptionsTags = WebUI.getWebElements(listdropdownTag);

        for (WebElement option : allOptionsTags) {
            if (option.getText().equals(dropdownTag)) {
                option.click();
                break;
            }
        }
        WebUI.setTextElement(inputName, leadsNameTest);
        WebUI.setTextElement(inputAddress, address);
        WebUI.setTextElement(inputPosition, position);
        WebUI.setTextElement(inputCity, city);
        WebUI.setTextElement(inputEmailAddress, emailAddress);
        WebUI.setTextElement(inputState, state);
        WebUI.setTextElement(inputWebsite, website);


        //------------------- Dropdown Country----------------------------
        WebUI.clickElement(dropdownCountry);
        WebUI.setTextElement(inputSearchCountry, country);
        WebUI.clickElement(listCountry(country));

        WebUI.setTextElement(inputPhone, phone);
        WebUI.setTextElement(inputZipCode, zipCode);
        WebUI.setTextElement(inputLeadValue, leadValue);


//    -------------------- Drowpdown Default Language ---------------------------
        WebUI.clickElement(dropdownDefaultLanguage);
        WebUI.setTextElement(inputSearchDefaultLanguage, language);
        WebUI.clickElement(listDefaultLanguage(language));
//         String xpathDefaultLanguage = listDefaultLanguage(language); // Tạo xpath tương ứng với giá trị muốn chọn
//        driver.findElement(By.xpath(xpathDefaultLanguage)).click();
//        WebUI.sleep(1000);

        WebUI.setTextElement(inputCompany, company);
        WebUI.setTextElement(inputDescription, description);
        if (flag == 0) {
            WebUI.clickElement(labelCheckboxPublic);
        } else if (flag == 1) {
            WebUI.clickElement(labelCheckboxContactedToday);
            WebUI.sleep(1000);
            WebUI.setTextElement(inputDateContacted, dateContacted);

        }

        WebUI.clickElement(buttonSave);
        WebUI.sleep(1000);

    }

    public void clickCloseProfile() throws InterruptedException {

        WebUI.clickElement(iconCloseProfile);
        WebUI.sleep(1000);
    }

    public void searchLeads(String leadsname) throws InterruptedException {
        driver.navigate().refresh();
        WebUI.sleep(1000);
        WebUI.setTextElement(inputSearch, leadsname);
        WebUI.waitForElementVisible(getFirstRowItemLeadName(leadsname));

    }
    public void verifyNewLeadsFirstRowItemLeadName(String leadsname) throws InterruptedException {
        Assert.assertTrue(WebUI.checkExistsElement(getFirstRowItemLeadName(leadsname)), "Không đúng giá trị Lead vừa thêm mới");
        WebUI.sleep(1000);
    }


    public void verifyNewLeadInEdit(String status, String source, String assigned, String tag, String leadName, String address, String position,
                                    String city, String emailAddress, String state, String website, String country, String phone, String zipCode,
                                    String leadValue, String language, String company, String description, String dateContacted, int flag) throws InterruptedException {


        // Status ]

        String actualStatus = WebUI.getText(dropdownStatus).trim();
        Assert.assertTrue(actualStatus.contains(status), "FAIL: Status không chứa giá trị mong muốn. Expected fragment: " + status + " Actual: " + actualStatus);


        // Source
        String actualSource = WebUI.getText(dropdownSourceButton).trim();
        Assert.assertEquals(actualSource, source, "FAIL: Source không khớp.");


        String actualAssigned = WebUI.getText(dropdownAssignedButton).trim();
        Assert.assertEquals(actualAssigned, assigned, "FAIL: Assigned không chứa giá trị mong muốn.");


//        String actualTag = driver.findElement(By.xpath(inputTag)).getText().trim();
//        Assert.assertEquals(actualTag, tag, "FAIL: Tag không khớp.");


        String actualName = WebUI.getElementAttribute(inputName, "value").trim();
        Assert.assertEquals(actualName, leadName, "FAIL: Tên Lead không khớp.");

        String actualAddress = WebUI.getElementAttribute(inputAddress, "value").trim();
        Assert.assertEquals(actualAddress, address, "FAIL: Dia chi không khớp.");

        String actualPosition = WebUI.getElementAttribute(inputPosition, "value").trim();
        Assert.assertEquals(actualPosition, position, "FAIL: không khớp.");

        String actualCity = WebUI.getElementAttribute(inputCity, "value").trim();
        Assert.assertEquals(actualCity, city, "FAIL: không khớp.");

        String actualEmail = WebUI.getElementAttribute(inputEmailAddress, "value").trim();
        Assert.assertEquals(actualEmail, emailAddress, "FAIL: không khớp.");

        String actualState = WebUI.getElementAttribute(inputState, "value").trim();
        Assert.assertEquals(actualState, state, "FAIL: không khớp.");

        String actualWebsite = WebUI.getElementAttribute(inputWebsite, "value").trim();
        Assert.assertEquals(actualWebsite, website, "FAIL: không khớp.");

        String actualCountry = WebUI.getText(dropdownCountry).trim();
        Assert.assertTrue(actualCountry.contains(country), "FAIL: country không khớp.");

        String actualphone = WebUI.getElementAttribute(inputPhone, "value").trim();
        Assert.assertEquals(actualphone, phone, "FAIL: không khớp.");

        String actualZipCode = WebUI.getElementAttribute(inputZipCode, "value").trim();
        Assert.assertEquals(actualZipCode, zipCode, "FAIL: không khớp.");


        String actualLeadValue = WebUI.getElementAttribute(inputLeadValue, "value").trim();
        Assert.assertTrue(actualLeadValue.contains(leadValue), "FAIL: không khớp.");

        String actualLanluage = WebUI.getText(dropdownDefaultLanguage).trim();
        Assert.assertEquals(actualLanluage, language, "FAIL: không khớp.");

        String actualCompany = WebUI.getElementAttribute(inputCompany, "value").trim();
        Assert.assertEquals(actualCompany, company, "FAIL: không khớp.");
        String actualDescription = WebUI.getElementAttribute(inputDescription, "value").trim();
        Assert.assertEquals(actualDescription, description, "FAIL: không khớp.");


        // Checkbox Public
        if (flag == 1) {
            Assert.assertFalse(WebUI.checkSeletedElement(labelCheckboxPublic), "Đang không tích chọn checkbox public");
            // Last Contacted (Phải xử lý substring như bạn đã làm, nhưng dùng Assert)
            String actualDateContacted = WebUI.getElementAttribute(inputLastContacted, "value").trim().substring(0, 10);
            Assert.assertEquals(actualDateContacted, dateContacted, "FAIL: Last Contacted Date không khớp.");
        } else if (flag == 0) {
            Assert.assertTrue(WebUI.checkSeletedElement(labelCheckboxPublic), "Đang tích chọn checkbox public");
            {
            }

        }

        System.out.println("Tất cả các trường dữ liệu Lead đã được Verify thành công trong Edit Popup.");
    }


    public void clickEditButton(String leadName) throws InterruptedException {
//        Actions action = new Actions(driver);
//        action.moveToElement(WebUI.getWebElement(getFirstRowItemLeadName(leadName))).perform(); //ham chung
        WebUI.moveToElement(getFirstRowItemLeadName(leadName));
        WebUI.clickElement(buttonEdit(leadName));


    }

    public void clickbuttonDelete(String leadName) throws InterruptedException {
        WebUI.moveToElement(getFirstRowItemLeadName(leadName));
        WebUI.clickElement(buttonDelete(leadName));
        WebUI.sleep(1000);
        driver.switchTo().alert().accept();
    }


    public void verifyAfterDeleteLead(String name) throws InterruptedException {
        WebUI.sleep(1000);
        WebUI.setTextElement(inputSearch, name);
        WebUI.sleep(1000);
        Assert.assertFalse(WebUI.checkExistsElement(getFirstRowItemLeadName(name)), "Xóa Lead không thành công");
        WebUI.sleep(1000);
    }

    public String getTotalStatusCustomer() {
        String totalCustomer = WebUI.getText(labelLeadTotalCustomer).trim();
        System.out.println("Total Customer Lead: " + totalCustomer);
        return totalCustomer;
    }

    public String getTotalStatusActive() {
        String totalActive = WebUI.getText(labelLeadTotalActive).trim();
        System.out.println("Total Active Lead: " + totalActive);
        return totalActive;
    }

    public String getTotalStatusLeads() {
        String totalActive = getTotalStatusActive();
        String totalCustomer = getTotalStatusCustomer();
        int toltalStatusLeads = Integer.parseInt(totalActive) + Integer.parseInt(totalCustomer);
        return String.valueOf(toltalStatusLeads);
    }


}
