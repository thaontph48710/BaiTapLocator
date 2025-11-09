package leads;

public class LocatorsLeadsCRM {
    //Login


    public static String inputEmail = "//input[@id='email']";
    public static String inputPassWord = "//input[@id='password']";
    public static String logoLogin = "//h1[normalize-space()='Login']";

    public static String checkboxRememberMe = "//input[@id='remember']";
    public static  String buttonLogin = "//button[normalize-space()='Login']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public static String alertErrorMessage = "//div[contains(text(), 'Invalid email')]";
    public static String alertErrorMessageEmailRequired = "//div[text()='The Email Address field is required.']";
    public static String alertErrorMessagePasswordRequired = "//div[text()='The Password field is required.']";

    //Menu Leads
    public static String  menuLeads = "//span[@class='menu-text' and normalize-space()='Leads']";



    // Xpath Button of Leads

    public static String buttonNewLeads = "//a[normalize-space()='New Lead']";
    public static  String buttonLeadsSummary = "//a[@data-title='Leads Summary']";
    public static  String buttonKanban = "//a[@data-title='Switch to Kanban']";
    public static   String buttonFilterBy = "//button[normalize-space()='Filter by']";
    public static  String buttoExport = "//button[normalize-space()='Export']";
    public static  String buttonBulkActions =  "//button[normalize-space()='Bulk Actions']";
    public static  String buttonReload = "//button[@data-original-title='Reload']";
    public static  String dropdownLength = "//select[@name='leads_length']";

    public static   String inputSearch =  "//div[@id='leads_filter']//input[@type='search']";


    //Header
    public static String titleLeadsSummary = "//h4[normalize-space()='Leads Summary']";
    public static String titleActive = "//div[contains(@class,'leads-overview')]//span[normalize-space()='Active']";
    public static String numberValueActive = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Active']/preceding-sibling::span";
    public static String titleCutomes = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Customer']";
    public static String numberValueCustomer = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Customer']/preceding-sibling::span";

    //Xpath table
    public static String checkboxAll = "//input[@id='mass_select_all']";
    public static  String labelSTT = "//th[@id='th-number']";
    public static String labelName = "//th[@id='th-name']";
    public static String labelCompany = "//th[@id='th-company']";
    public static  String labelEmailTable = "//th[@id='th-email']";
    public static String labelPhone = "//th[@id='th-phone']";
    public static String labelValue= "//th[@id='th-lead-value']";
    public static  String labelTags = "//th[@id='th-tags']";
    public static String labelAssigned= "//th[@id='th-assigned']";
    public static  String labelStatus = "//th[@id='th-status']";
    public static String labelSource = "//th[@id='th-source']";
    public static  String labelLastContact= "//th[@id='th-last-contact']";
    public static  String labelCreated = "//th[@id='th-date-created']";

    public static String buttonView(String leadName){
        String buttonView = "//td[./a[normalize-space()='" + leadName +"']]//a[normalize-space()='View']";
        return buttonView;
    }

    public static String buttonEdit(String leadName){
        String buttonEdit = "//td[./a[normalize-space()='" + leadName +"']]//a[normalize-space()='Edit']";
        return buttonEdit;
    }

    public static String buttonDelete(String leadName){
        String buttonDelete = "//td[./a[normalize-space()='" + leadName +"']]//a[normalize-space()='Delete']";
        return buttonDelete;
    }


    // ====== Add New Lead Form ======
    public static String btnAddLead = "//a[normalize-space()='New Lead']";
    public static String titleAddNewLead = "//h4[normalize-space() ='Add new lead']";

    public static  String labelStatusAdd = "//label[@for='status']";
    public static String dropdownStatus = "//button[@data-id='status']";
    public static String inputStatusSearch = "//button[@data-id='status']/following-sibling::div//input";
    public static String listStatus(String value){
        String listStatus = "//button[@data-id='status']/following-sibling::div//span[normalize-space()='"+value+"']";
        return listStatus;
    }


    public static String labelSourceAdd = "//label[@for='source']";
    public static String dropdownSourceButton = "//button[@data-id='source']";
    public static  String inputSourceSearch = "//button[@data-id='source']/following-sibling::div//input";
    public static String listSource(String value){
        String listSource = "//button[@data-id='source']/following-sibling::div//span[normalize-space()='"+value+"']";
        return listSource;
    }


    public static String labelAssignedAdd = "//label[@for='assigned']";
    public static  String dropdownAssignedButton = "//button[@title='Admin Example']";
    public static String inputAssignedSearch = "//div[@class='dropdown bootstrap-select bs3 open']//input[@aria-label='Search']";
    public static String listAssigned(String value){
        String listAssigned = "//button[@data-id='assigned']/following-sibling::div//span[normalize-space()='" + value + "']";
        return listAssigned;
    }

    public static  String labelTag = "//label[normalize-space()='Tags']";
    public static String inputTag = "//div[@id='inputTagsWrapper']//input[@placeholder='Tag']";
    public static String listdropdownTag = "//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']/li[@class='ui-menu-item']/div";
    public static String listTags(String value){
        String listTags = "//div[@id='inputTagsWrapper']//div[normalize-space()='" + value + "']";
        return listTags;
    }


    public static  String inputName = "//div[@id ='tab_lead_profile']//input[@id='name']";
    public static String inputAddress = "//textarea[@id='address']";
    public static   String inputPosition = "//input[@id='title']";
    public static String labelCity = "//label[normalize-space()='City']";
    public static String inputCity = "//input[@id='city']";

    public static  String labelEmailAddress = "//label[normalize-space()='Email Address']";
    public static String inputEmailAddress = "//input[@id='email']";

    public static String labelState = "//label[normalize-space()='State']";
    public static  String inputState = "//input[@id='state']";

    public static  String labelWebsite = "//label[normalize-space()='Website']";
    public static String inputWebsite = "//input[@id='website']";

    public static String labelCountry = "//label[normalize-space()='Country']";
    public static String dropdownCountry = "//button[@data-id='country']";
    public static String inputSearchCountry = "//button[@data-id='country']/following-sibling::div//input[@type='search']";
    public static String listCountry(String value) {
        String listCountry = "//button[@data-id='country']/following::span[@class='text' and normalize-space()='"+value+"']";
        return listCountry;
    }

    public static String labelPhoneAdd = "//label[normalize-space()='Phone']";
    public static  String inputPhone = "//input[@id='phonenumber']";

    public static String labelZipCode = "//label[normalize-space()='Zip Code']";
    public static String inputZipCode = "//input[@id='zip']";


    public static String inputLeadValue = "//input[@name='lead_value']";
    public static String iconLeadValue = "//div[contains(text(),'$')]";

    public static String labelDefaultLanguage = "//label[normalize-space()='Default Language']";
    public static String dropdownDefaultLanguage = "//button[@data-id='default_language']";
    public static String listDefaultLanguage(String value){
        String listDefaultLanguage = "//button[@data-id='default_language']/following::span[@class='text' and normalize-space()='"+value+"']";
        return listDefaultLanguage;
    }

    public static String labelCompanyAdd = "//label[normalize-space()='Company']";
    public static String inputCompany= "//div[@app-field-wrapper='company']//input[@id='company']";

    public static String labelDescription = "//label[normalize-space()='Description']";
    public static String inputDescription = "//div[@app-field-wrapper='description']//textarea[@id='description']";

    public static String checkboxPublic = "//input[@id='lead_public']";

    public static String checkboxContactedToday = "//input[@id='contacted_today']";


    public static String labelDateContacted = "//label[@for='custom_contact_date']";
    public static String inputDateContacted = "//input[@id='custom_contact_date']";

    public static String firstRowLeads = "//table[@id='leads']//tbody/tr[1]/td[3]/a";
    public static String iconCloseProfile = "//div[@id='lead-modal']//button[@class='close']";


    public static String buttonClose = "//div[@id ='tab_lead_profile']//button[normalize-space()='Close']";           // Close
    public static String buttonSave = "//button[@id='lead-form-submit']";              // Save



}
