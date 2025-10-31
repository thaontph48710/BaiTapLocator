package leads;

public class LocatorsCRM {
    //Login


    String inputEmail = "//input[@id='email']";
    String inputPassWord = "//input[@id='password']";
    String logoLogin = "//h1[normalize-space()='Login']";

    String checkboxRememberMe = "//input[@id='remember']";
    String buttonLogin = "//button[normalize-space()='Login']";
    String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    String alertErrorMessage = "//div[contains(text(), 'Invalid email')]";
    String alertErrorMessageEmailRequired = "//div[text()='The Email Address field is required.']";
    String alertErrorMessagePasswordRequired = "//div[text()='The Password field is required.']";

    //Menu Leads
    String  menuLeads = "//span[@class='menu-text' and normalize-space()='Leads']";



    // Xpath Button of Leads

    String buttonNewLeads = "//a[normalize-space()='New Lead']";
    String buttonLeadsSummary = "//a[normalize-space()='Leads Summary']";
    String buttonKanban = "//a[@data-title='Switch to Kanban']";
    String buttonFilterBy = "//button[normalize-space()='Filter by']";
    String buttoExport = "//button[normalize-space()='Export']";
    String buttonBulkActions =  "//button[normalize-space()='Bulk Actions']";
    String buttonReload = "//button[@data-original-title='Reload']";
    String dropdownLength = "//select[@name='leads_length']";

    String inputSearch =  "//div[@id='leads_filter']//input[@type='search']";


    //Header
    String titleLeadsSummary = "//h4[normalize-space()='Leads Summary']";
    String titleActive = "//div[contains(@class,'leads-overview')]//span[normalize-space()='Active']";
    String numberValueActive = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Active']/preceding-sibling::span";
    String titleCutomes = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Customer']";
    String numberValueCustomer = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Customer']/preceding-sibling::span";

    //Xpath table
     String checkboxAll = "//input[@id='mass_select_all']";
     String labelSTT = "//th[@id='th-number']";
     String labelName = "//th[@id='th-name']";
     String labelCompany = "//th[@id='th-company']";
     String labelEmailTable = "//th[@id='th-email']";
     String labelPhone = "//th[@id='th-phone']";
     String labelValue= "//th[@id='th-lead-value']";
     String labelTags = "//th[@id='th-tags']";
     String labelAssigned= "//th[@id='th-assigned']";
     String labelStatus = "//th[@id='th-status']";
     String labelSource = "//th[@id='th-source']";
     String labelLastContact= "//th[@id='th-last-contact']";
     String labelCreated = "//th[@id='th-date-created']";

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
    String btnAddLead = "//a[normalize-space()='New Lead']";
    String titleAddNewLead = "//h4[normalize-space() ='Add new lead']";

     String labelStatusAdd = "//label[@for='status']";
     String inputStatusSearch = "//button[@data-id='status']/following-sibling::div//input";
    public static String ListStatus(String value){
        String ListStatus = "//button[@data-id='status']/following-sibling::div//span[normalize-space()='"+value+"']";
        return ListStatus;
    }


     String labelSourceAdd = "//label[@for='source']";
     String dropdownSourceButton = "//button[@data-id='source']";
     String inputSourceSearch = "//button[@data-id='source']/following-sibling::div//input";
    public static String ListSource(String value){
        String ListSource = "//button[@data-id='source']/following-sibling::div//span[normalize-space()='"+value+"']";
        return ListSource;
    }


     String labelAssignedAdd = "//label[@for='assigned']";
     String dropdownAssignedButton = "//button[@title='Admin Example']";
     String inputAssignedSearch = "//div[@class='dropdown bootstrap-select bs3 open']//input[@aria-label='Search']";
    public static String ListAssigned(String value){
        String ListAssignes = "//button[@data-id='assigned']/following-sibling::div//span[normalize-space()='" + value + "']";
        return ListAssignes;
    }

     String labelTag = "//label[normalize-space()='Tags']";
     String inputTag = "//div[@id='inputTagsWrapper']//input[@placeholder='Tag']";
    public static String ListTags(String value){
        String ListTags = "//div[@id='inputTagsWrapper']//div[normalize-space()='" + value + "']";
        return ListTags;
    }


     String inputName = "//div[@id ='tab_lead_profile']//input[@id='name']";
     String inputAddress = "//textarea[@id='address']";
     String inputPosition = "//input[@id='title']";
     String labelCity = "//label[normalize-space()='City']";
     String inputCity = "//input[@id='city']";

     String labelEmailAddress = "//label[normalize-space()='Email Address']";
     String inputEmailAddress = "//input[@id='email']";

     String labelState = "//label[normalize-space()='State']";
     String inputState = "//input[@id='state']";

     String labelWebsite = "//label[normalize-space()='Website']";
     String inputWebsite = "//input[@id='website']";

     String labelCountry = "//label[normalize-space()='Country']";
    public static String ListCountry(String value) {
        String ListCountry = "//button[@data-id='country']/following::span[@class='text' and normalize-space()='"+value+"']";
        return ListCountry;
    }

     String labelPhoneAdd = "//label[normalize-space()='Phone']";
     String inputPhone = "//input[@id='phonenumber']";

     String labelZipCode = "//label[normalize-space()='Zip Code']";
     String inputZipCode = "//input[@id='zip']";


     String inputLeadValue = "//input[@name='lead_value']";
     String iconLeadValue = "//div[contains(text(),'$')]";

     String labelDefaultLanguage = "//label[normalize-space()='Default Language']";
     String dropdownDefaultLanguage = "//button[@data-id='default_language']";
    public static String ListDefaultLanguage(String value){
        String ListDefaultLanguage = "//button[@data-id='default_language']/following::span[@class='text' and normalize-space()='"+value+"']";
        return ListDefaultLanguage;
    }

     String labelCompanyAdd = "//label[normalize-space()='Company']";
     String inputCompany = "//textarea[@id='company']";

     String labelDescription = "//label[normalize-space()='Description']";
     String inputDescription = "//input[@id='description']";

     String checkboxPublic = "//input[@id='lead_public']";

     String checkboxContactedToday = "//input[@id='contacted_today']";
     String inputDateContacted = "//input[@id='custom_contact_date']";


     String buttonClose = "//div[@id ='tab_lead_profile']//button[normalize-space()='Close']";           // Close
     String buttonSave = "//button[@id='lead-form-submit']";              // Save




}
