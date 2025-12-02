package bai_tap_locators;

import org.openqa.selenium.By;

public class LocatorsLeadsCRM {

    //Menu Leads
    public static By menuLeads = By.xpath(" //span[@class='menu-text' and normalize-space()='Leads']");



    // Xpath Button of Leads

    public static By buttonNewLeads = By.xpath(" //a[normalize-space()='New Lead']");
   public static  By buttonLeadsSummary = By.xpath(" //a[@data-title='Leads Summary']");
   public static  By buttonKanban = By.xpath(" //a[@data-title='Switch to Kanban']");
   public static   By buttonFilterBy = By.xpath(" //button[normalize-space()='Filter by']");
   public static  By buttoExport = By.xpath(" //button[normalize-space()='Export']");
   public static  By buttonBulkActions = By.xpath( "//button[normalize-space()='Bulk Actions']");
   public static  By buttonReload = By.xpath(" //button[@data-original-title='Reload']");
   public static  By dropdownLength = By.xpath(" //select[@name='leads_length']");

    public static   By inputSearch =  By.xpath("//div[@id='leads_filter']//input[@type='search']");

    public static By headerAddNewLead = By.xpath(" //h4[normalize-space()='Add new lead']");
    //Header
    public static By labelCheckboxPublic = By.xpath("//label[@for='lead_public']");
    public static By labelCheckboxContactedToday = By.xpath("//label[normalize-space()='Contacted Today']");

    public static By titleLeadsSummary = By.xpath(" //h4[normalize-space()='Leads Summary']");
    public static By titleActive = By.xpath(" //div[contains(@class,'leads-overview')]//span[normalize-space()='Active']");
    public static By numberValueActive = By.xpath(" //div[contains(@class,'leads-overview')]//span[normalize-space() = 'Active']/preceding-sibling::span");
    public static By titleCutomes = By.xpath(" //div[contains(@class,'leads-overview')]//span[normalize-space() = 'Customer']");
    public static By numberValueCustomer = By.xpath(" //div[contains(@class,'leads-overview')]//span[normalize-space() = 'Customer']/preceding-sibling::span");

    //Xpath table
    public static By checkboxAll = By.xpath(" //input[@id='mass_select_all']");
   public static  By labelSTT = By.xpath(" //th[@id='th-number']");
    public static By labelName = By.xpath(" //th[@id='th-name']");
    public static By labelCompany = By.xpath(" //th[@id='th-company']");
   public static  By labelEmailTable = By.xpath(" //th[@id='th-email']");
    public static By labelPhone = By.xpath(" //th[@id='th-phone']");
    public static By labelValue= By.xpath(" //th[@id='th-lead-value']");
   public static  By labelTags = By.xpath(" //th[@id='th-tags']");
    public static By labelAssigned= By.xpath(" //th[@id='th-assigned']");
   public static  By labelStatus = By.xpath(" //th[@id='th-status']");
    public static By labelSource = By.xpath(" //th[@id='th-source']");
   public static  By labelLastContact= By.xpath(" //th[@id='th-last-contact']");
   public static  By labelCreated = By.xpath(" //th[@id='th-date-created']");

    public static By buttonView(String leadName){
        By buttonView = By.xpath(" //td[./a[normalize-space()='" + leadName +"']]//a[normalize-space()='View']");
        return buttonView;
    }

    public static By buttonEdit(String leadName){
        By buttonEdit = By.xpath(" //td[./a[normalize-space()='" + leadName +"']]//a[normalize-space()='Edit']");
        return buttonEdit;
    }

    public static By buttonDelete(String leadName){
        By buttonDelete = By.xpath(" //td[./a[normalize-space()='" + leadName +"']]//a[normalize-space()='Delete']");
        return buttonDelete;
    }
    public static By checkDelete = By.xpath(" //td[@class='dataTables_empty']");


    // ====== Add New Lead Form ======
    public static By btnAddLead = By.xpath(" //a[normalize-space()='New Lead']");
    public static By titleAddNewLead = By.xpath(" //h4[normalize-space() ='Add new lead']");

   public static  By labelStatusAdd = By.xpath(" //label[@for='status']");
    public static By dropdownStatus = By.xpath(" //button[@data-id='status']");
    public static By inputStatusSearch = By.xpath(" //button[@data-id='status']/following-sibling::div//input");
    public static By listStatus(String value){
        By xpath = By.xpath(" //button[@data-id='status']/following-sibling::div//span[contains(normalize-space(),'" + value + "')]");
        return xpath;
    }


    public static By labelSourceAdd = By.xpath(" //label[@for='source']");
    public static By dropdownSourceButton = By.xpath(" //button[@data-id='source']");
   public static  By inputSourceSearch = By.xpath(" //button[@data-id='source']/following-sibling::div//input");
    public static By listSource(String value){
        By listSource = By.xpath(" //button[@data-id='source']/following-sibling::div//span[normalize-space()='"+value+"']");
        return listSource;
    }


    public static By labelAssignedAdd = By.xpath(" //label[@for='assigned']");
   public static  By dropdownAssignedButton = By.xpath(" //button[@data-id='assigned']");
    public static By inputAssignedSearch = By.xpath(" //div[@class='dropdown bootstrap-select bs3 open']//input[@aria-label='Search']");
    public static By listAssigned(String value){
        By listAssigned = By.xpath(" //button[@data-id='assigned']/following-sibling::div//span[normalize-space()='" + value + "']");
        return listAssigned;
    }

   public static  By labelTag = By.xpath(" //label[normalize-space()='Tags']");
   public static  By inputTagTrong = By.xpath(" //div[@id='inputTagsWrapper']//ul[@class='tagit ui-widget ui-widget-content ui-corner-all']//input[@type='text']");
   public static  By inputClearTag = By.xpath(" //div[@id='inputTagsWrapper']//li[1]");
    public static By inputTag = By.xpath(" //div[@id='inputTagsWrapper']//input[@placeholder='Tag']");
    public static By listdropdownTag = By.xpath(" //div[@id='inputTagsWrapper']//ul[@id='ui-id-2']/li[@class='ui-menu-item']/div");
    public static By listTags(String value){
        By listTags = By.xpath(" //div[@id='inputTagsWrapper']//div[normalize-space()='" + value + "']");
        return listTags;
    }


   public static  By inputName = By.xpath(" //div[@id ='tab_lead_profile']//input[@id='name']");
    public static By inputAddress = By.xpath(" //textarea[@id='address']");
    public static   By inputPosition = By.xpath(" //input[@id='title']");
    public static By labelCity = By.xpath(" //label[normalize-space()='City']");
    public static By inputCity = By.xpath(" //input[@id='city']");

   public static  By labelEmailAddress = By.xpath(" //label[normalize-space()='Email Address']");
    public static By inputEmailAddress = By.xpath(" //input[@id='email']");

    public static By labelState = By.xpath(" //label[normalize-space()='State']");
   public static  By inputState = By.xpath(" //input[@id='state']");

   public static  By labelWebsite = By.xpath(" //label[normalize-space()='Website']");
    public static By inputWebsite = By.xpath(" //input[@id='website']");

    public static By labelCountry = By.xpath(" //label[normalize-space()='Country']");
    public static By dropdownCountry = By.xpath(" //button[@data-id='country']");
    public static By inputSearchCountry = By.xpath(" //button[@data-id='country']/following-sibling::div//input[@type='search']");
    public static By listCountry(String value) {
        By listCountry = By.xpath(" //button[@data-id='country']/following::span[@class='text' and normalize-space()='"+value+"']");
        return listCountry;
    }

    public static By labelPhoneAdd = By.xpath(" //label[normalize-space()='Phone']");
   public static  By inputPhone = By.xpath(" //input[@id='phonenumber']");

    public static By labelZipCode = By.xpath(" //label[normalize-space()='Zip Code']");
    public static By inputZipCode = By.xpath(" //input[@id='zip']");


    public static By inputLeadValue = By.xpath(" //input[@name='lead_value']");
    public static By iconLeadValue = By.xpath(" //div[contains(text(),'$')]");

    public static By labelDefaultLanguage = By.xpath(" //label[normalize-space()='Default Language']");
    public static By dropdownDefaultLanguage = By.xpath(" //button[@data-id='default_language']");
    public static By inputSearchDefaultLanguage = By.xpath("//button[@data-id='default_language']/following-sibling::div//input[@type='search']");
    public static By listDefaultLanguage(String value){
        By listDefaultLanguage = By.xpath(" //button[@data-id='default_language']/following::span[@class='text' and normalize-space()='"+value+"']");
        return listDefaultLanguage;
    }

    public static By labelCompanyAdd = By.xpath(" //label[normalize-space()='Company']");
    public static By inputCompany= By.xpath(" //div[@app-field-wrapper='company']//input[@id='company']");

    public static By labelDescription = By.xpath(" //label[normalize-space()='Description']");
    public static By inputDescription = By.xpath(" //div[@app-field-wrapper='description']//textarea[@id='description']");

    public static By checkboxPublic = By.xpath(" //input[@id='lead_public']");

    public static By checkboxContactedToday = By.xpath(" //input[@id='contacted_today']");


    public static By labelDateContacted = By.xpath(" //label[@for='custom_contact_date']");
    public static By inputDateContacted = By.xpath(" //input[@id='custom_contact_date']");
    public static By inputLastContacted = By.xpath(" //input[@id='lastcontact']");


    public static By firstRowLeads = By.xpath(" //table[@id='leads']//tbody/tr[1]/td[3]/a");
    public static By iconCloseProfile = By.xpath(" //div[@id='lead-modal']//button[@class='close']");


    public static By buttonClose = By.xpath(" //div[@id ='tab_lead_profile']//button[normalize-space()='Close']");           // Close
    public static By buttonSave = By.xpath(" //button[@id='lead-form-submit']");              // Save

    public static By getFirstRowItemLeadName(String leadName) {
        By xpath = By.xpath(" //table[@id='leads']//a[normalize-space()='" + leadName + "']");
        return xpath;

    }




}
