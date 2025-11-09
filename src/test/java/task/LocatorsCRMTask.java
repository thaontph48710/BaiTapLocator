package task;

public class LocatorsCRMTask {

    //Login


    public String inputEmail = "//input[@id='email']";
    public String inputPassWord = "//input[@id='password']";
    public String logoLogin = "//h1[normalize-space()='Login']";
    public String checkboxRememberMe = "//input[@id='remember']";
    public String buttonLogin = "//button[normalize-space()='Login']";
    public String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public String alertErrorMessage = "//div[contains(text(), 'Invalid email')]";
    public String alertErrorMessageEmailRequired = "//div[text()='The Email Address field is required.']";
    public String alertErrorMessagePasswordRequired = "//div[text()='The Password field is required.']";

    // Menu Tasks
    public String menuTasks = "//a[@href='https://crm.anhtester.com/admin/tasks']";

    public String headerTasksPage = "//span[normalize-space()='Tasks Summary']";
    public String buttonNewTasks= "//a[normalize-space()='New Task']";


    //  Add New Task

    public String checkboxPublic = "//input[@id='task_is_public']";
    public String checkboxBillable= "//input[@id='task_is_billable']";


    public String linkAttachFiles = "//a[normalize-space()='Attach Files']";
    public String inputAttachment = "//div[@id='new-task-attachments']/descendant::input[@type='file']";

    public String inputSubject= "//input[@id='name']";
    public String inputHourlyRate = "//input[@id='hourly_rate']";
    public String inputStartDate = "//div[@app-field-wrapper='startdate']//input[@id='startdate']";
    public String iconStartDate = "//input[@id='startdate']/following-sibling::div";
    public String inputDueDate = "//input[@id='duedate']";
    public String iconDueDate= "//input[@id='duedate']/following-sibling::div";

    public String dropdownPrioryty = "//button[@data-id='priority']";
    public static String getValuePrioryty(String value) {
        String getValuePrioryty = "//button[@data-id='priority']/following-sibling::div//span[normalize-space()='" +value+ "']";
        return getValuePrioryty;
    }

    public String dropdownRepeatEvery = "//button[@data-id='repeat_every']";
    public static String getRepeatEvery(String value) {
        String getRepeatEvery = "//button[@data-id='repeat_every']/following-sibling::div//span[normalize-space()='" +value+ "']";
        return getRepeatEvery;
    }

    public String LabelForRelatedTo = "//label[normalize-space()='Related To']";
    public String dropdownRelatedTo = "//button[@data-id='rel_type']";
    public static String listRelatedTo(String value) {
        String listRelatedTo = "//button[@data-id='rel_type']/following-sibling::div//span[normalize-space()='" +value+"']";
        return listRelatedTo;
    }
    public String LabelProject = "//span[@class='rel_id_label']";
    public String inputSearchProject = "//button[@data-id='rel_id']";



    public String dropdownAssignees = "//button[@data-id='assignees']";
    public String inputSearchAssignees = "//button[@data-id='assignees']/following-sibling::div//input[@type='search']";
    public static String listAssignees(String value) {
        String listAssignees = "//button[@data-id='assignees']/following-sibling::div//span[normalize-space()='" +value+ "']";
        return listAssignees;
    }


    public String dropdownFollowers= "//button[@data-id='followers[]']";
    public String inputSearchFollowers = "//button[@data-id='followers[]']/following-sibling::div//input[@type='search']";
    public static String listFollowers(String value) {
        String listFollowers = "//button[@data-id='followers[]']/following-sibling::div//span[normalize-space()='" +value+ "']";
        return listFollowers;
    }



    public String inputTag = "//div[@id='inputTagsWrapper']//input[@placeholder='Tag']";
    public String dropdownTag = "//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']";
    public static String listTag (String value ) {
        String listTag  = "//input[@id='tags']/following-sibling::ul[@id='ui-id-2']//div[normalize-space()='" +value+ "']";
        return listTag ;
    }

    public String inputTaskDescription = "//textarea[@id='description']";
    public String buttonSave = "//button[@type='submit' and text()='Save']";
    public String buttonClose= "//button[@type='submit' and text()='Save']/preceding-sibling::button";



}
