package leads;

public class LocatorsCRM {
    //Login

    String logoAnTester = "//img[@alt='Perfex CRM | Anh Tester Demo']";
    String inputEmail = "//input[@id='email']";
    String inputPassWord = "//input[@id='password']";
    String logoLogin = "//h1[normalize-space()='Login']";
    String labelEmail = "//label[normalize-space()='Email Address']";
    String labelPassword = "//label[normalize-space()='Password']";
    String labelRememberMe = "//label[normalize-space()='Remember me']";
    String checkboxRememberMe = "//input[@id='remember']";
    String buttonLogin = "//button[normalize-space()='Login']";
    String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";

    //Menu Leads
    String  menuLeads = "//span[@class='menu-text' and normalize-space()='Leads']";



    // Xpath Button of Leads

    String buttonNewLeads = "//a[normalize-space()='New Lead']";
    String buttonLeadsSummary = "//a[@class='btn btn-default btn-with-tooltip']";
    String buttonKanban = "//a[@class='btn btn-default mleft5 hidden-xs']";
    String buttonFilterBy = "//button[normalize-space()='Filter by']";
    String buttoExport = "//button[@class='btn btn-default buttons-collection btn-sm btn-default-dt-options']";
    String buttonBulkActions = "//button[@class='btn btn-default btn-sm btn-default-dt-options']";
    String buttonReload = "//button[@data-original-title='Reload']";
    String dropdownLength = "//select[@name='leads_length']";

    String inputSearch = "//input[@class='form-control input-sm']";


    //Header
    String titleLeadsSummary = "//h4[normalize-space()='Leads Summary']";
    String titleActive = "//span[normalize-space()='Active']";
    String titlejjjj = "//span[normalize-space()='jjjj']";
    String titleCutomes = "//div[contains(@class,'tw-items-center')]//span[contains(text(),'Customer')]";
    String titleLostLeads = "//span[@class='text-danger']";

    //Xpath table
     String checkboxAll = "//div[@class='checkbox mass_select_all_wrap']";
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

    // ====== Add New Lead Form ======

     String labelStatusAdd = "//label[@for='status']";
     String requiredStatusMark = "//label[@for='status']//small[@class='req text-danger'][normalize-space()='*']";
     String dropdownStatusButton = "//button[@data-id='status']";
     String inputStatusSearch = "//button[@data-id='status']/following-sibling::div//input";
     String dropdownStatusOption = "//div[@id='bs-select-5']//a[@id='bs-select-5-3']/span";
     String buttonAddNewStatus = "//a[@onclick='new_lead_status_inline();return false;']";

     String requiredSource = "//label[@for='source']//small[@class='req text-danger'][normalize-space()='*']";
     String labelSourceAdd = "//label[@for='source']";
     String dropdownSourceButton = "//button[@data-id='source']";
     String inputSourceSearch = "//button[@data-id='source']/following-sibling::div//input";
     String dropdownSourceOption = "//a[@id='bs-select-6-2']/span";
     String buttonAddNewSource = "//a[@onclick='new_lead_source_inline();return false;']";


     String labelAssignedAdd = "//label[@for='assigned']";
     String dropdownAssignedButton = "//button[@title='Admin Example']";
     String inputAssignedSearch = "//div[@class='dropdown bootstrap-select bs3 open']//input[@aria-label='Search']";
     String dropdownAssignedOption = "//div[@id='bs-select-7']//span[normalize-space()='Admin Anh Tester']";


     String labelTag = "//label[normalize-space()='Tags']";
     String inputTag = "//div[@id='inputTagsWrapper']//input[@placeholder='Tag']";


     String labelNameAdd = "//div[@class='col-md-6']//label[@for='name']";
     String requiredName = "///div[@class='col-md-6']//small[@class='req text-danger'][normalize-space()='*']";
     String inputName = "//div[@class='col-md-6']//input[@id='name']";

     String labelAddress = "//label[normalize-space()='Address']";
     String inputAddress = "//textarea[@id='address']";

     String labelPosition = "//label[normalize-space()='Position']";
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
     String dropdownCountry = "//div[@app-field-wrapper='country']//button[@title='Nothing selected']']";


     String labelPhoneAdd = "//label[normalize-space()='Phone']";
     String inputPhone = "//input[@id='phonenumber']";

     String labelZipCode = "//label[normalize-space()='Zip Code']";
     String inputZipCode = "//input[@id='zip']";

     String labelLeadValue = "//label[normalize-space()='Lead value']";
     String inputLeadValue = "//input[@name='lead_value']";
     String iconLeadValue = "//div[contains(text(),'$')]";

     String labelDefaultLanguage = "//label[normalize-space()='Default Language']";
     String dropdownDefaultLanguage = "//button[@data-id='default_language']";


     String labelCompanyAdd = "//label[normalize-space()='Company']";
     String inputCompany = "//textarea[@id='company']";

     String labelDescription = "//label[normalize-space()='Description']";
     String inputDescription = "//input[@id='description']";



     String labelCheckboxPublic = "//label[@for='lead_public']";
     String checkboxPublic = "//input[@id='lead_public']";


     String labelCheckboxContactedToday = "//label[normalize-space()='Contacted Today']";
     String checkboxContactedToday = "//input[@id='contacted_today']";

     String labelDateContacted = "//label[normalize-space()='Date Contacted']";
     String inputDateContacted = "//input[@id='custom_contact_date']";


     String buttonClose = "//button[@type=' button']";            // Close
     String buttonSave = "//button[@id='lead-form-submit']";              // Save




}
