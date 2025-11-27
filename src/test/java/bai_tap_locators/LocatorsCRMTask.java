package bai_tap_locators;

public class LocatorsCRMTask {
    public static   String inputSearch =  "//div[@id='tasks_filter']//input[@type='search']";
    // Menu Tasks
    public static String menuTasks = "//a[@href='https://crm.anhtester.com/admin/tasks']";

    public static String headerTasksPage = "//span[normalize-space()='Tasks Summary']";
    public static String buttonNewTasks= "//a[normalize-space()='New Task']";


    //  Add New Task
    public static String headerAddNewTask = "//div[@id='_task_modal']//h4[normalize-space()='Add new task']";
    public static String checkboxPublic = "//input[@id='task_is_public']";
    public static String checkboxBillable= "//input[@id='task_is_billable']";


    public static String linkAttachFiles = "//a[normalize-space()='Attach Files']";
    public String inputAttachment = "//div[@id='new-task-attachments']/descendant::input[@type='file']";

    public static String inputSubject= "//input[@id='name']";
    public static String inputHourlyRate = "//input[@id='hourly_rate']";
    public static String inputStartDate = "//div[@app-field-wrapper='startdate']//input[@id='startdate']";
    public static String iconStartDate = "//input[@id='startdate']/following-sibling::div";
    public static String inputDueDate = "//input[@id='duedate']";
    public static String iconDueDate= "//input[@id='duedate']/following-sibling::div";

    public static String dropdownPrioryty = "//button[@data-id='priority']";

    public static String getValuePrioryty(String value) {
        String getValuePrioryty = "//button[@data-id='priority']/following-sibling::div//span[normalize-space()='" +value+ "']";
        return getValuePrioryty;
    }

    public static String dropdownRepeatEvery = "//button[@data-id='repeat_every']";
    public static String getRepeatEvery(String value) {
        String getRepeatEvery = "//button[@data-id='repeat_every']/following-sibling::div//span[normalize-space()='" +value+ "']";
        return getRepeatEvery;
    }

    public static String LabelForRelatedTo = "//label[normalize-space()='Related To']";
    public static String dropdownRelatedTo = "//button[@data-id='rel_type']";
    public static String listRelatedTo(String value) {
        String listRelatedTo = "//button[@data-id='rel_type']/following-sibling::div//span[normalize-space()='" +value+"']";
        return listRelatedTo;
    }
    public static String LabelProject = "//span[@class='rel_id_label']";
    public static String inputSearchProject = "//button[@data-id='rel_id']";



    public static String dropdownAssignees = "//button[@data-id='assignees']";
    public static String inputSearchAssignees = "//button[@data-id='assignees']/following-sibling::div//input[@type='search']";
    public static String listAssignees(String value) {
        String listAssignees = "//button[@data-id='assignees']/following-sibling::div//span[normalize-space()='" +value+ "']";
        return listAssignees;
    }


    public static String dropdownFollowers= "//button[@data-id='followers[]']";
    public static String inputSearchFollowers = "//button[@data-id='followers[]']/following-sibling::div//input[@type='search']";
    public static String listFollowers(String value) {
        String listFollowers = "//button[@data-id='followers[]']/following-sibling::div//span[normalize-space()='" +value+ "']";
        return listFollowers;
    }

    public static String dropdownValueForRepeatTo = "//button[@data-id='rel_id']";

    public static String inputTag = "//div[@id='inputTagsWrapper']//input[@placeholder='Tag']";
    public static String dropdownTag = "//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']";
    public static String listTag (String value ) {
        String listTag  = "//input[@id='tags']/following-sibling::ul[@id='ui-id-2']//div[normalize-space()='" +value+ "']";
        return listTag ;
    }

    public static String getValueForRepeatTo(String valueForRepeatTo) {
        String xpathValueForRepeatTo = "//button[@data-id='rel_id']/following-sibling::div//span[normalize-space()='"+valueForRepeatTo +"']";
        return xpathValueForRepeatTo;
    }
    public static String inputSearchValueForRepeatTo = "//button[@data-id='rel_id']/following-sibling::div//input[@type='search']";
    public static String getValueRepeatTo(String valueRepeatTo) {
        String xpathRepeatTo = "//button[@data-id='rel_type']/following-sibling::div//span[normalize-space()='" +valueRepeatTo+ "']";
        return xpathRepeatTo;
    }

    public static String inputTaskDescription = "//textarea[@id='description']";
    public static String buttonSave = "//button[@type='submit' and text()='Save']";
    public static String buttonClose= "//button[@type='submit' and text()='Save']/preceding-sibling::button";


    public static String firstRowTask= "//table[@id='tasks']//tbody/tr[1]/td[3]/a";
    public static String iconCloseProfile = "//div[@id='task-modal']//button[@class='close']";

    public static String getFirstRowItemTask(String taskName) {
    String xpath = "//table[@id='tasks']//a[normalize-space()='" + taskName + "']";

    return xpath;
}
}
