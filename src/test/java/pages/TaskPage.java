package pages;

import com.thaotest.WebUI;
import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class TaskPage extends BasePage {
    private WebDriver driver;

    public TaskPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private   By  inputSearch =  By.xpath("//div[@id='tasks_filter']//input[@type='search']");
    // Menu Tasks
     private By menuTasks = By.xpath("//a[@href='https://crm.anhtester.com/admin/tasks']");

     private By headerTasksPage = By.xpath("//span[normalize-space()='Tasks Summary']");
     private By buttonNewTasks= By.xpath("//a[normalize-space()='New Task']");


    //  Add New TaskTest
     private By headerAddNewTask = By.xpath("//div[@id='_task_modal']//h4[normalize-space()='Add new task']");
    private By checkboxPublic = By.xpath("//input[@id='task_is_public']");

    private By labelCheckboxPublic = By.xpath("//label[@for='task_is_public']");
    private By checkboxBillable = By.xpath("//input[@id='task_is_billable']");
    private By labelCheckboxBillable = By.xpath("//input[@id='task_is_billable']//following-sibling::label");


     private By linkAttachFiles = By.xpath("//a[normalize-space()='Attach Files']");
    private By inputAttachment = By.xpath("//div[@id='new-task-attachments']/descendant::input[@type='file']");

     private By inputSubject= By.xpath("//input[@id='name']");
     private By inputHourlyRate = By.xpath("//input[@id='hourly_rate']");
     private By inputStartDate = By.xpath("//div[@app-field-wrapper='startdate']//input[@id='startdate']");
     private By iconStartDate = By.xpath("//input[@id='startdate']/following-sibling::div");
     private By inputDueDate = By.xpath("//input[@id='duedate']");
     private By iconDueDate= By.xpath("//input[@id='duedate']/following-sibling::div");



    private By dropdownPrioryty = By.xpath("//button[@data-id='priority']");

    private By buttonEdit(String taskName) {
         By buttonEdit = By.xpath(" //td[./a[normalize-space()='" + taskName +"']]//a[normalize-space()='Edit']");
        return buttonEdit;
    }

    private By getValuePrioryty(String value) {
         By getValuePrioryty = By.xpath("//button[@data-id='priority']/following-sibling::div//span[normalize-space()='" +value+ "']");
        return getValuePrioryty;
    }

     private By dropdownRepeatEvery = By.xpath("//button[@data-id='repeat_every']");
     private By getRepeatEvery(String value) {
         By getRepeatEvery = By.xpath("//button[@data-id='repeat_every']/following-sibling::div//span[normalize-space()='" +value+ "']");
        return getRepeatEvery;
    }

     private By LabelForRelatedTo = By.xpath("//label[normalize-space()='Related To']");
     private By dropdownRelatedTo = By.xpath("//button[@data-id='rel_type']");
     private By listRelatedTo(String value) {
         By listRelatedTo = By.xpath("//button[@data-id='rel_type']/following-sibling::div//span[normalize-space()='" +value+"']");
        return listRelatedTo;
    }
     private By LabelProject = By.xpath("//span[@class='rel_id_label']");
     private By inputSearchProject = By.xpath("//button[@data-id='rel_id']");



     private By dropdownAssignees = By.xpath("//button[@data-id='assignees']");
     private By inputSearchAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//input[@type='search']");
     private By listAssignees(String value) {
         By listAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//span[normalize-space()='" +value+ "']");
        return listAssignees;
    }


     private By dropdownFollowers= By.xpath("//button[@data-id='followers[]']");
     private By inputSearchFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div//input[@type='search']");
     private By listFollowers(String value) {
         By listFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div//span[normalize-space()='" +value+ "']");
        return listFollowers;
    }

     private By dropdownValueForRepeatTo = By.xpath("//button[@data-id='rel_id']");

     private By inputTag = By.xpath("//div[@id='inputTagsWrapper']//input[@placeholder='Tag']");
    private By inputTagsEdit = By.xpath("(//input[@id='tags']/following-sibling::ul)/descendant::span[@class='tagit-label']");
     private By dropdownTag = By.xpath("//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']");
     private By listTag (String value ) {
         By listTag  = By.xpath("//input[@id='tags']/following-sibling::ul[@id='ui-id-2']//div[normalize-space()='" +value+ "']");
        return listTag ;
    }

     private By getValueForRepeatTo(String valueForRepeatTo) {
         By xpathValueForRepeatTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div//span[normalize-space()='"+valueForRepeatTo +"']");
        return xpathValueForRepeatTo;
    }
     private By inputSearchValueForRepeatTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div//input[@type='search']");
     private By getValueRepeatTo(String valueRepeatTo) {
         By xpathRepeatTo = By.xpath("//button[@data-id='rel_type']/following-sibling::div//span[normalize-space()='" +valueRepeatTo+ "']");
        return xpathRepeatTo;
    }


    private By typeRelatedToDropdown = By.xpath("//button[@data-id='rel_id']");
     private By inputSearchTypeRelatedTo = By.xpath("//div[@id='rel_id_select']/descendant::input[@type ='search']");

    private By getValueTypeRelatedTo(String valueTypeRelatedTo) {
        By xpath = By.xpath("//button[@data-id='rel_id']/following-sibling::div/descendant::a[contains(normalize-space(),'" + valueTypeRelatedTo + "')]");
        return xpath;
    }

    private By iframeDescription = By.xpath("//iframe[@id='description_ifr']");
    private By inputDescriptionFrame = By.xpath("//body[@id='tinymce']/p");
     private By inputTaskDescription = By.xpath("//textarea[@id='description']");

     private By buttonSave = By.xpath("//button[@type='submit' and text()='Save']");
     private By buttonClose= By.xpath("//button[@type='submit' and text()='Save']/preceding-sibling::button");


     private By firstRowTask= By.xpath("//table[@id='tasks']//tbody/tr[1]/td[3]/a");
     private By iconCloseProfile = By.xpath("//div[@id='task-modal']//button[@class='close']");

     private By iconCloseEdit = By.xpath("//h4[@id='myModalLabel']//preceding-sibling::button[@class = 'close']");

     private By getFirstRowItemTask(String taskName) {
         By xpath = By.xpath("//table[@id='tasks']//a[normalize-space()='" + taskName + "']");

    return xpath;
}


    public  void clickMenuTasks() throws InterruptedException {
        System.out.println("Click Menu Tasks");
        WebUI.clickElement(driver, menuTasks);

        Assert.assertTrue(WebUI.checkExistsElement(driver, headerTasksPage), "Không truy cập được vào trang Tasks!");
    }

    public void clickButtonNewTask() throws InterruptedException {
        System.out.println("Click Button New TaskTest");
        WebUI.clickElement(driver, buttonNewTasks);

        Assert.assertTrue(WebUI.checkExistsElement(driver, headerAddNewTask), "Khong mo duoc new task!");
    }

    public void addNewTask(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                  String relatedTo, String typeRelatedTo, String assignee, String follower, String description, String tag, int flag) throws InterruptedException {
        System.out.println("Add New TaskTest");

        if (flag == 1) {
            WebUI.clickElement(driver, labelCheckboxPublic);
        }
        if (flag == 0) {
            WebUI.clickElement(driver, labelCheckboxBillable);
        }

        WebUI.setTextElement(driver, inputSubject, subject);
        WebUI.setTextElement(driver, inputHourlyRate, hourlyRate);
        WebUI.clearElementText(driver, inputStartDate);
        WebUI.clickElement(driver, headerAddNewTask);
        WebUI.setTextElement(driver, inputStartDate, startDate);
        WebUI.clickElement(driver, headerAddNewTask);
        WebUI.setTextElement(driver, inputDueDate, dueDate);
        WebUI.clickElement(driver, headerAddNewTask);

// ---------------------------------Drowdown Prioryty-----------------------------
        WebUI.clickElement(driver, dropdownPrioryty);
        WebUI.clickElement(driver, getValuePrioryty(priority));
        Thread.sleep(2000);

//---------------------------------Drowdown Repeat Every-----------------------------
        WebUI.clickElement(driver, dropdownRepeatEvery);
        WebUI.clickElement(driver, getRepeatEvery(repeatEvery));
        Thread.sleep(2000);

//---------------------------------Drowdown Related To-----------------------------
        WebUI.clickElement(driver, dropdownRelatedTo);
        WebUI.clickElement(driver, listRelatedTo(relatedTo));
        Thread.sleep(2000);
//---------------------------------Drowdown Type Related To-----------------------------
        WebUI.clickElement(driver, dropdownValueForRepeatTo);
        WebUI.setTextElement(driver, inputSearchTypeRelatedTo, typeRelatedTo);
        Thread.sleep(1000);
//        Actions actions = new Actions(driver);
//        actions.click(WebUI.getWebElement(driver, inputSearchTypeRelatedTo)).sendKeys(" ").build().perform();
//        Thread.sleep(2000);
        WebUI.clickElement(driver, getValueTypeRelatedTo(typeRelatedTo));


//---------------------------------Drowdown Assignees-----------------------------
        WebUI.clickElement(driver, dropdownAssignees);
        WebUI.clickElement(driver, listAssignees(assignee));
        Thread.sleep(2000);

        //---------------------------------Drowdown Followers-----------------------------
        WebUI.clickElement(driver, dropdownFollowers);
        WebUI.clickElement(driver, listFollowers(follower));
        Thread.sleep(2000);

        //------------------- Xác định dropdown Tag---------------------------
        // Mở dropdown
        WebUI.clickElement(driver, inputTag);
        WebUI.setTextElement(driver, inputTag, tag);
        Thread.sleep(2000);
        WebUI.clickElement(driver, listTag(tag));
        Thread.sleep(2000);

        WebUI.clickElement(driver, headerAddNewTask);

        WebUI.clickElement(driver, inputTaskDescription);
        WebUI.switchToFrame(driver, iframeDescription);
        WebUI.setTextElement(driver, inputDescriptionFrame, description);
        WebUI.switchToParentFrame(driver);

        Thread.sleep(2000);



    }

    public void clickSave() throws InterruptedException {
        System.out.println("Click Save TaskTest");
        WebUI.clickElement(driver, buttonSave);

    }

    public void clickCloseProffile() throws InterruptedException {
        System.out.println("Close Profile");
        WebUI.clickElement(driver, iconCloseProfile);

    }

    public void clickCloseEdit(){
        System.out.println("Close Edit Profile");
        WebUI.clickElement(driver, iconCloseEdit);
    }
    public void searchTaskNewAdd(String Task) throws InterruptedException {
        WebUI.clickElement(driver, menuTasks);
        WebUI.clearElementText(driver, inputSearch);

        WebUI.setTextElement(driver, inputSearch,Task);
        Thread.sleep(2000);
        String firstRowOfTask = WebUI.getText(driver, firstRowTask);
        System.out.println("First row TaskTest: " + firstRowOfTask);
        Thread.sleep(6000);
    }
    public void verifyNewTask(String subject, String hourlyRate, String startDate, String dueDate,
                              String priority, String repeatEvery, String relatedTo, String typeRelatedTo, String assignee,
                              String follower, String tag, int flag) throws InterruptedException {

        System.out.println(" – Checking data after creating task...");

//
//        if (flag == 1) {
//            Assert.assertTrue(WebUI.checkSeletedElement(driver, checkboxPublic), "Checkbox không được chọn");
//            Assert.assertTrue(WebUI.checkSeletedElement(driver, checkboxBillable), "Checkbox không được chọn");
//        }
//        if (flag == 0) {
//            Assert.assertFalse(WebUI.checkSeletedElement(driver, checkboxPublic), "Checkbox được tích chọn");
//            Assert.assertFalse(WebUI.checkSeletedElement(driver, checkboxBillable), "Checkbox được tích chọn");
//        }



        // SUBJECT
        String actualSubject = WebUI.getElementAttribute(driver, inputSubject,"value").trim();
        Assert.assertEquals(actualSubject, subject, "FAIL: Subject không khớp");

        // HOURLY RATE
        String actualRate = WebUI.getElementAttribute(driver, inputHourlyRate,"value").trim();
        Assert.assertTrue(actualRate.contains(hourlyRate), "FAIL: Hourly Rate không khớp");

        // START DATE
        String actualStart = WebUI.getElementAttribute(driver, inputStartDate,"value").trim();
        Assert.assertEquals(actualStart, startDate, "FAIL: Start Date không khớp");


        // DUE DATE
        String actualDue = WebUI.getElementAttribute(driver, inputDueDate,"value").trim();
        Assert.assertEquals(actualDue, dueDate, "FAIL: Due Date không khớp");

        // PRIORITY (Select2)
        String actualPriority = WebUI.getText(driver, dropdownPrioryty).trim();
        Assert.assertEquals(actualPriority, priority, "FAIL: Priority không đúng");


        // REPEAT EVERY (Select2)
        String actualRepeat = WebUI.getText(driver, dropdownRepeatEvery).trim();
        Assert.assertEquals(actualRepeat, repeatEvery, "FAIL: Repeat Every không đúng");


        // RELATED TO (Select2)
        String actualRelatedTo = WebUI.getText(driver, dropdownRelatedTo).trim();
        Assert.assertTrue(actualRelatedTo.contains(relatedTo), "FAIL: Related To không đúng");

//        Type Related To
        String actualTypeRelatedTo = WebUI.getText(driver, typeRelatedToDropdown);
        Assert.assertTrue(actualTypeRelatedTo.contains(typeRelatedTo), "FAIL: Type Related To");

        // ASSIGNEE (Select2)
//        String actualAssignee = WebUI.getText(driver, dropdownAssignees).trim();
//        Assert.assertEquals(actualAssignee, assignee, "FAIL: Assignee không đúng");


        // FOLLOWER
//        String actualFolower = WebUI.getText(driver, dropdownFollowers).trim();
//        Assert.assertTrue(actualFolower.contains(follower), "FAIL: folower không chứa giá trị mong muốn");

        // TAG
        String actualTag =  WebUI.getText(driver, inputTagsEdit).trim().toLowerCase();
        Assert.assertEquals(actualTag, tag, "FAIL: tag không khớp.");



        System.out.println("VERIFY SUCCESS — dữ liệu task KHỚP hoàn toàn!");
    }

    public void editTasks(String subjectEdit, String hourlyRateEdit, String startDateEdit, String dueDateEdit,
                                 String priorityEdit, String repeatEveryEdit,
                                 String relatedToEdit, String typeRelatedToEdit, int flag) throws Exception {

        Actions actions = new Actions(driver);
        Robot robot = new Robot();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        //checkbox
//        if (flag == 1) {
//            actions.click(WebUI.getWebElement(driver, checkboxPublic)).perform();
//            Thread.sleep(2000);
//        }
//        if (flag == 0) {
//            actions.click(WebUI.getWebElement(driver, checkboxBillable)).perform();
//            Thread.sleep(2000);
//        }
        // ======================= SUBJECT ==========================

        WebElement elementSubject = wait.until(ExpectedConditions.elementToBeClickable(
                WebUI.getWebElement(driver, inputSubject)
        ));
        actions.click(elementSubject).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(subjectEdit).perform();
        Thread.sleep(800);

        // ======================= HOURLY RATE ==========================
        pressCtrlA_Delete(robot);
        WebElement elementHourlyRate =  WebUI.getWebElement(driver, inputHourlyRate);
        actions.click(elementHourlyRate).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(hourlyRateEdit).perform();
        Thread.sleep(800);

        // ======================= START DATE ==========================
        WebElement elementStartDate =  WebUI.getWebElement(driver, inputStartDate);
        actions.click(elementStartDate).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(startDateEdit).perform();
        Thread.sleep(800);

        // ======================= DUE DATE ==========================
        WebElement elementDueDate = WebUI.getWebElement(driver, inputDueDate);
        actions.click(elementDueDate).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(dueDateEdit).perform();
        Thread.sleep(800);

        // ======================= PRIORITY SELECT2 ==========================
        actions.click(WebUI.getWebElement(driver, dropdownPrioryty)).perform();
        Thread.sleep(600);

        actions.click(WebUI.getWebElement(driver, getValuePrioryty(priorityEdit))).perform();
        Thread.sleep(800);

        // ======================= REPEAT EVERY SELECT2 ==========================
        actions.click(WebUI.getWebElement(driver, dropdownRepeatEvery)).perform();
        Thread.sleep(600);

        actions.click(WebUI.getWebElement(driver, getRepeatEvery(repeatEveryEdit))).perform();
        Thread.sleep(800);

        // ======================= RELATED TO (cấp 1) ==========================
        actions.click(WebUI.getWebElement(driver, dropdownRelatedTo)).perform();
        Thread.sleep(800);

        actions.click(WebUI.getWebElement(driver, getValueRepeatTo(relatedToEdit))).perform();
        Thread.sleep(800);

        // ======================= TYPE OF RELATED (cấp 2) ==========================
        actions.click(WebUI.getWebElement(driver, dropdownValueForRepeatTo)).perform();
        Thread.sleep(600);

        WebElement searchBox = WebUI.getWebElement(driver, inputSearchValueForRepeatTo);
        actions.click(searchBox).perform();
        Thread.sleep(400);

        actions.sendKeys(typeRelatedToEdit).perform();
        Thread.sleep(800);

        // Enter để load option
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(800);

        actions.click(WebUI.getWebElement(driver, getValueForRepeatTo(typeRelatedToEdit))).perform();
        Thread.sleep(1000);

        System.out.println("✔ Edit TaskTest completed (Robot + Actions + Wait)");
    }

    /** Hàm rút gọn: Ctrl + A + Delete */
    public void pressCtrlA_Delete(Robot robot) throws Exception {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(200);

        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        Thread.sleep(300);
    }

    public void clickEditButton(String taskName) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(WebUI.getWebElement(driver, getFirstRowItemTask(taskName))).perform();
        Thread.sleep(1000);
        WebUI.clickElement(driver,buttonEdit(taskName));
        Thread.sleep(2000);
    }

}
