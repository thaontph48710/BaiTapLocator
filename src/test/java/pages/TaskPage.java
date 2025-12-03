package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskPage {
    public static   By  inputSearch =  By.xpath("//div[@id='tasks_filter']//input[@type='search']");
    // Menu Tasks
     public static By menuTasks = By.xpath("//a[@href='https://crm.anhtester.com/admin/tasks']");

     public static By headerTasksPage = By.xpath("//span[normalize-space()='Tasks Summary']");
     public static By buttonNewTasks= By.xpath("//a[normalize-space()='New TaskTest']");


    //  Add New TaskTest
     public static By headerAddNewTask = By.xpath("//div[@id='_task_modal']//h4[normalize-space()='Add new task']");
     public static By checkboxPublic = By.xpath("//input[@id='task_is_public']");
     public static By checkboxBillable= By.xpath("//input[@id='task_is_billable']");


     public static By linkAttachFiles = By.xpath("//a[normalize-space()='Attach Files']");
    public static By inputAttachment = By.xpath("//div[@id='new-task-attachments']/descendant::input[@type='file']");

     public static By inputSubject= By.xpath("//input[@id='name']");
     public static By inputHourlyRate = By.xpath("//input[@id='hourly_rate']");
     public static By inputStartDate = By.xpath("//div[@app-field-wrapper='startdate']//input[@id='startdate']");
     public static By iconStartDate = By.xpath("//input[@id='startdate']/following-sibling::div");
     public static By inputDueDate = By.xpath("//input[@id='duedate']");
     public static By iconDueDate= By.xpath("//input[@id='duedate']/following-sibling::div");

     public static By dropdownPrioryty = By.xpath("//button[@data-id='priority']");



    public static By getValuePrioryty(String value) {
         By getValuePrioryty = By.xpath("//button[@data-id='priority']/following-sibling::div//span[normalize-space()='" +value+ "']");
        return getValuePrioryty;
    }

     public static By dropdownRepeatEvery = By.xpath("//button[@data-id='repeat_every']");
     public static By getRepeatEvery(String value) {
         By getRepeatEvery = By.xpath("//button[@data-id='repeat_every']/following-sibling::div//span[normalize-space()='" +value+ "']");
        return getRepeatEvery;
    }

     public static By LabelForRelatedTo = By.xpath("//label[normalize-space()='Related To']");
     public static By dropdownRelatedTo = By.xpath("//button[@data-id='rel_type']");
     public static By listRelatedTo(String value) {
         By listRelatedTo = By.xpath("//button[@data-id='rel_type']/following-sibling::div//span[normalize-space()='" +value+"']");
        return listRelatedTo;
    }
     public static By LabelProject = By.xpath("//span[@class='rel_id_label']");
     public static By inputSearchProject = By.xpath("//button[@data-id='rel_id']");



     public static By dropdownAssignees = By.xpath("//button[@data-id='assignees']");
     public static By inputSearchAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//input[@type='search']");
     public static By listAssignees(String value) {
         By listAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//span[normalize-space()='" +value+ "']");
        return listAssignees;
    }


     public static By dropdownFollowers= By.xpath("//button[@data-id='followers[]']");
     public static By inputSearchFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div//input[@type='search']");
     public static By listFollowers(String value) {
         By listFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div//span[normalize-space()='" +value+ "']");
        return listFollowers;
    }

     public static By dropdownValueForRepeatTo = By.xpath("//button[@data-id='rel_id']");

     public static By inputTag = By.xpath("//div[@id='inputTagsWrapper']//input[@placeholder='Tag']");
     public static By dropdownTag = By.xpath("//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']");
     public static By listTag (String value ) {
         By listTag  = By.xpath("//input[@id='tags']/following-sibling::ul[@id='ui-id-2']//div[normalize-space()='" +value+ "']");
        return listTag ;
    }

     public static By getValueForRepeatTo(String valueForRepeatTo) {
         By xpathValueForRepeatTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div//span[normalize-space()='"+valueForRepeatTo +"']");
        return xpathValueForRepeatTo;
    }
     public static By inputSearchValueForRepeatTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div//input[@type='search']");
     public static By getValueRepeatTo(String valueRepeatTo) {
         By xpathRepeatTo = By.xpath("//button[@data-id='rel_type']/following-sibling::div//span[normalize-space()='" +valueRepeatTo+ "']");
        return xpathRepeatTo;
    }

     public static By inputTaskDescription = By.xpath("//textarea[@id='description']");
     public static By buttonSave = By.xpath("//button[@type='submit' and text()='Save']");
     public static By buttonClose= By.xpath("//button[@type='submit' and text()='Save']/preceding-sibling::button");


     public static By firstRowTask= By.xpath("//table[@id='tasks']//tbody/tr[1]/td[3]/a");
     public static By iconCloseProfile = By.xpath("//div[@id='task-modal']//button[@class='close']");

     public static By getFirstRowItemTask(String taskName) {
         By xpath = By.xpath("//table[@id='tasks']//a[normalize-space()='" + taskName + "']");

    return xpath;
}
}
