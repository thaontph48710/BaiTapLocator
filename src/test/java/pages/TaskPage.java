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
        new WebUI(driver);
    }

    private By inputSearch = By.xpath("//div[@id='tasks_filter']//input[@type='search']");
    // Menu Tasks
    private By menuTasks = By.xpath("//a[@href='https://crm.anhtester.com/admin/tasks']");

    private By headerTasksPage = By.xpath("//span[normalize-space()='Tasks Summary']");
    private By buttonNewTasks = By.xpath("//a[normalize-space()='New Task']");


    //  Add New TaskTest
    private By headerAddNewTask = By.xpath("//div[@id='_task_modal']//h4[normalize-space()='Add new task']");
    private By checkboxPublic = By.xpath("//input[@id='task_is_public']");

    private By labelCheckboxPublic = By.xpath("//label[@for='task_is_public']");
    private By checkboxBillable = By.xpath("//input[@id='task_is_billable']");
    private By labelCheckboxBillable = By.xpath("//input[@id='task_is_billable']//following-sibling::label");


    private By linkAttachFiles = By.xpath("//a[normalize-space()='Attach Files']");
    private By inputAttachment = By.xpath("//div[@id='new-task-attachments']/descendant::input[@type='file']");

    private By inputSubject = By.xpath("//input[@id='name']");
    private By inputHourlyRate = By.xpath("//input[@id='hourly_rate']");
    private By inputStartDate = By.xpath("//div[@app-field-wrapper='startdate']//input[@id='startdate']");
    private By iconStartDate = By.xpath("//input[@id='startdate']/following-sibling::div");
    private By inputDueDate = By.xpath("//input[@id='duedate']");
    private By iconDueDate = By.xpath("//input[@id='duedate']/following-sibling::div");


    private By dropdownPrioryty = By.xpath("//button[@data-id='priority']");

    private By buttonEdit(String taskName) {
        By buttonEdit = By.xpath(" //td[./a[normalize-space()='" + taskName + "']]//a[normalize-space()='Edit']");
        return buttonEdit;
    }

    private By getValuePrioryty(String value) {
        By getValuePrioryty = By.xpath("//button[@data-id='priority']/following-sibling::div//span[normalize-space()='" + value + "']");
        return getValuePrioryty;
    }

    private By dropdownRepeatEvery = By.xpath("//button[@data-id='repeat_every']");

    private By getRepeatEvery(String value) {
        By getRepeatEvery = By.xpath("//button[@data-id='repeat_every']/following-sibling::div//span[normalize-space()='" + value + "']");
        return getRepeatEvery;
    }

    private By LabelForRelatedTo = By.xpath("//label[normalize-space()='Related To']");
    private By dropdownRelatedTo = By.xpath("//button[@data-id='rel_type']");

    private By listRelatedTo(String value) {
        By listRelatedTo = By.xpath("//button[@data-id='rel_type']/following-sibling::div//span[normalize-space()='" + value + "']");
        return listRelatedTo;
    }

    private By LabelProject = By.xpath("//span[@class='rel_id_label']");
    private By inputSearchProject = By.xpath("//button[@data-id='rel_id']");


    private By dropdownAssignees = By.xpath("//button[@data-id='assignees']");
    private By inputSearchAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//input[@type='search']");

    private By listAssignees(String value) {
        By listAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//span[normalize-space()='" + value + "']");
        return listAssignees;
    }


    private By dropdownFollowers = By.xpath("//button[@data-id='followers[]']");
    private By inputSearchFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div//input[@type='search']");

    private By listFollowers(String value) {
        By listFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div//span[normalize-space()='" + value + "']");
        return listFollowers;
    }

    private By dropdownValueForRepeatTo = By.xpath("//button[@data-id='rel_id']");

    private By inputTag = By.xpath("//div[@id='inputTagsWrapper']//input[@placeholder='Tag']");
    private By inputTagsEdit = By.xpath("(//input[@id='tags']/following-sibling::ul)/descendant::span[@class='tagit-label']");
    private By dropdownTag = By.xpath("//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']");

    private By listTag(String value) {
        By listTag = By.xpath("//input[@id='tags']/following-sibling::ul[@id='ui-id-2']//div[normalize-space()='" + value + "']");
        return listTag;
    }

    private By getValueForRepeatTo(String valueForRepeatTo) {
        By xpathValueForRepeatTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div//span[normalize-space()='" + valueForRepeatTo + "']");
        return xpathValueForRepeatTo;
    }

    private By inputSearchValueForRepeatTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div//input[@type='search']");

    private By getValueRepeatTo(String valueRepeatTo) {
        By xpathRepeatTo = By.xpath("//button[@data-id='rel_type']/following-sibling::div//span[normalize-space()='" + valueRepeatTo + "']");
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
    private By buttonClose = By.xpath("//button[@type='submit' and text()='Save']/preceding-sibling::button");


    private By firstRowTask = By.xpath("//table[@id='tasks']//tbody/tr[1]/td[3]/a");
    private By iconCloseProfile = By.xpath("//div[@id='task-modal']//button[@class='close']");

    private By iconCloseEdit = By.xpath("//h4[@id='myModalLabel']//preceding-sibling::button[@class = 'close']");

    private By getFirstRowItemTask(String taskName) {
        By xpath = By.xpath("//table[@id='tasks']//a[normalize-space()='" + taskName + "']");

        return xpath;
    }


    public void clickMenuTasks() throws InterruptedException {
        System.out.println("Click Menu Tasks");
        WebUI.clickElement(menuTasks);

        Assert.assertTrue(WebUI.checkExistsElement(headerTasksPage), "Không truy cập được vào trang Tasks!");
    }

    public void clickButtonNewTask() throws InterruptedException {
        System.out.println("Click Button New TaskTest");
        WebUI.clickElement(buttonNewTasks);
        WebUI.waitForElementToBeClickAble(headerAddNewTask, 5);

        Assert.assertTrue(WebUI.checkExistsElement(headerAddNewTask), "Khong mo duoc new task!");
    }

    public void addNewTask(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                           String relatedTo, String typeRelatedTo, String assignee, String follower, String description, String tag, int flag) throws InterruptedException {
        System.out.println("Add New TaskTest");

        if (flag == 1) {
            WebUI.clickElement(labelCheckboxPublic);
        }
        if (flag == 0) {
            WebUI.clickElement(labelCheckboxBillable);
        }

        WebUI.setTextElement(inputSubject, subject);
        WebUI.setTextElement(inputHourlyRate, hourlyRate);
        WebUI.clearElementText(inputStartDate);
        WebUI.clickElement(headerAddNewTask);
        WebUI.setTextElement(inputStartDate, startDate);
        WebUI.clickElement(headerAddNewTask);
        WebUI.setTextElement(inputDueDate, dueDate);
        WebUI.clickElement(headerAddNewTask);

// ---------------------------------Drowdown Prioryty-----------------------------
        WebUI.clickElement(dropdownPrioryty);
        WebUI.clickElement(getValuePrioryty(priority));
        WebUI.sleep(1);

//---------------------------------Drowdown Repeat Every-----------------------------
        WebUI.clickElement(dropdownRepeatEvery);
        WebUI.clickElement(getRepeatEvery(repeatEvery));
        WebUI.sleep(1);

//---------------------------------Drowdown Related To-----------------------------
        WebUI.clickElement(dropdownRelatedTo);
        WebUI.clickElement(listRelatedTo(relatedTo));
        WebUI.sleep(1);
//---------------------------------Drowdown Type Related To-----------------------------
        WebUI.clickElement(dropdownValueForRepeatTo);
        WebUI.setTextElement(inputSearchTypeRelatedTo, typeRelatedTo);
        WebUI.sleep(1);
//        Actions actions = new Actions(driver);
//        actions.click(WebUI.getWebElement(  inputSearchTypeRelatedTo)).sendKeys(" ").build().perform();
//       WebUI.sleep(1);
        WebUI.clickElement(getValueTypeRelatedTo(typeRelatedTo));


//---------------------------------Drowdown Assignees-----------------------------
        WebUI.clickElement(dropdownAssignees);
        WebUI.clickElement(listAssignees(assignee));
        WebUI.sleep(1);

        //---------------------------------Drowdown Followers-----------------------------
        WebUI.clickElement(dropdownFollowers);
        WebUI.clickElement(listFollowers(follower));
        WebUI.sleep(1);

        //------------------- Xác định dropdown Tag---------------------------
        // Mở dropdown
        WebUI.clickElement(inputTag);
        WebUI.setTextElement(inputTag, tag);
        WebUI.sleep(1);
        WebUI.clickElement(listTag(tag));
        WebUI.sleep(1);

        WebUI.clickElement(headerAddNewTask);

        WebUI.clickElement(inputTaskDescription);
        WebUI.switchToFrame(iframeDescription);
        WebUI.setTextElement(inputDescriptionFrame, description);
        WebUI.switchToParentFrame();

        WebUI.sleep(1);


    }

    public void clickSave() throws InterruptedException {
        System.out.println("Click Save TaskTest");
        WebUI.clickElement(buttonSave);

    }

    public void clickCloseProffile() throws InterruptedException {
        System.out.println("Close Profile");
        WebUI.clickElement(iconCloseProfile);

    }

    public void clickCloseEdit() {
        System.out.println("Close Edit Profile");
        WebUI.clickElement(iconCloseEdit);
    }

    public void searchTaskNewAdd(String Task) throws InterruptedException {
        WebUI.clickElement(menuTasks);
        WebUI.clearElementText(inputSearch);

        WebUI.setTextElement(inputSearch, Task);
        WebUI.sleep(1);
        String firstRowOfTask = WebUI.getText(firstRowTask);
        System.out.println("First row TaskTest: " + firstRowOfTask);
        WebUI.sleep(1);
    }

    public void verifyNewTask(String subject, String hourlyRate, String startDate, String dueDate,
                              String priority, String repeatEvery, String relatedTo, String typeRelatedTo, String assignee,
                              String follower, String tag, int flag) throws InterruptedException {

        System.out.println(" – Checking data after creating task...");

//
//        if (flag == 1) {
//            Assert.assertTrue(WebUI.checkSeletedElement(  checkboxPublic), "Checkbox không được chọn");
//            Assert.assertTrue(WebUI.checkSeletedElement(  checkboxBillable), "Checkbox không được chọn");
//        }
//        if (flag == 0) {
//            Assert.assertFalse(WebUI.checkSeletedElement(  checkboxPublic), "Checkbox được tích chọn");
//            Assert.assertFalse(WebUI.checkSeletedElement(  checkboxBillable), "Checkbox được tích chọn");
//        }


        // SUBJECT
        String actualSubject = WebUI.getElementAttribute(inputSubject, "value").trim();
        Assert.assertEquals(actualSubject, subject, "FAIL: Subject không khớp");

        // HOURLY RATE
        String actualRate = WebUI.getElementAttribute(inputHourlyRate, "value").trim();
        Assert.assertTrue(actualRate.contains(hourlyRate), "FAIL: Hourly Rate không khớp");

        // START DATE
        String actualStart = WebUI.getElementAttribute(inputStartDate, "value").trim();
        Assert.assertEquals(actualStart, startDate, "FAIL: Start Date không khớp");


        // DUE DATE
        String actualDue = WebUI.getElementAttribute(inputDueDate, "value").trim();
        Assert.assertEquals(actualDue, dueDate, "FAIL: Due Date không khớp");

        // PRIORITY (Select2)
        String actualPriority = WebUI.getText(dropdownPrioryty).trim();
        Assert.assertEquals(actualPriority, priority, "FAIL: Priority không đúng");


        // REPEAT EVERY (Select2)
        String actualRepeat = WebUI.getText(dropdownRepeatEvery).trim();
        Assert.assertEquals(actualRepeat, repeatEvery, "FAIL: Repeat Every không đúng");


        // RELATED TO (Select2)
        String actualRelatedTo = WebUI.getText(dropdownRelatedTo).trim();
        Assert.assertTrue(actualRelatedTo.contains(relatedTo), "FAIL: Related To không đúng");

//        Type Related To
        String actualTypeRelatedTo = WebUI.getText(typeRelatedToDropdown);
        Assert.assertTrue(actualTypeRelatedTo.contains(typeRelatedTo), "FAIL: Type Related To");

        // ASSIGNEE (Select2)
//        String actualAssignee = WebUI.getText(  dropdownAssignees).trim();
//        Assert.assertEquals(actualAssignee, assignee, "FAIL: Assignee không đúng");


        // FOLLOWER
//        String actualFolower = WebUI.getText(  dropdownFollowers).trim();
//        Assert.assertTrue(actualFolower.contains(follower), "FAIL: folower không chứa giá trị mong muốn");

        // TAG
        String actualTag = WebUI.getText(inputTagsEdit).trim().toLowerCase();
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
//            actions.click(WebUI.getWebElement(  checkboxPublic)).perform();
//           WebUI.sleep(1);
//        }
//        if (flag == 0) {
//            actions.click(WebUI.getWebElement(  checkboxBillable)).perform();
//           WebUI.sleep(1);
//        }
        // ======================= SUBJECT ==========================

        WebElement elementSubject = wait.until(ExpectedConditions.elementToBeClickable(
                WebUI.getWebElement(inputSubject)
        ));
        actions.click(elementSubject).perform();
        WebUI.sleep(1);

        pressCtrlA_Delete(robot);
        actions.sendKeys(subjectEdit).perform();
        WebUI.sleep(1);

        // ======================= HOURLY RATE ==========================

        WebElement elementHourlyRate = WebUI.getWebElement(inputHourlyRate);
        actions.click(elementHourlyRate).perform();
        WebUI.sleep(1);

        pressCtrlA_Delete(robot);
        actions.sendKeys(hourlyRateEdit).perform();
        WebUI.sleep(1);

        // ======================= START DATE ==========================
        WebElement elementStartDate = WebUI.getWebElement(inputStartDate);
        actions.click(elementStartDate).perform();
        WebUI.sleep(1);

        pressCtrlA_Delete(robot);
        actions.sendKeys(startDateEdit).perform();
        WebUI.sleep(1);

        // ======================= DUE DATE ==========================
        WebElement elementDueDate = WebUI.getWebElement(inputDueDate);
        actions.click(elementDueDate).perform();
        WebUI.sleep(1);

        pressCtrlA_Delete(robot);
        actions.sendKeys(dueDateEdit).perform();
        WebUI.sleep(1);

        // ======================= PRIORITY SELECT2 ==========================
        actions.click(WebUI.getWebElement(dropdownPrioryty)).perform();
        WebUI.sleep(1);

        actions.click(WebUI.getWebElement(getValuePrioryty(priorityEdit))).perform();
        WebUI.sleep(1);

        // ======================= REPEAT EVERY SELECT2 ==========================
        actions.click(WebUI.getWebElement(dropdownRepeatEvery)).perform();
        WebUI.sleep(1);

        actions.click(WebUI.getWebElement(getRepeatEvery(repeatEveryEdit))).perform();
        WebUI.sleep(1);

        // ======================= RELATED TO (cấp 1) ==========================
        actions.click(WebUI.getWebElement(dropdownRelatedTo)).perform();
        WebUI.sleep(1);

        actions.click(WebUI.getWebElement(getValueRepeatTo(relatedToEdit))).perform();
        WebUI.sleep(1);

        // ======================= TYPE OF RELATED (cấp 2) ==========================

        actions.click(WebUI.getWebElement(dropdownValueForRepeatTo)).perform();
        pressCtrlA_Delete(robot);
        WebUI.sleep(1);

        WebElement searchBox = WebUI.getWebElement(inputSearchValueForRepeatTo);
        actions.click(searchBox).perform();
        WebUI.sleep(1);

        actions.sendKeys(typeRelatedToEdit).perform();
        WebUI.sleep(1);

        // Enter để load option
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        WebUI.sleep(1);

//        actions.click(WebUI.getWebElement(  getValueForRepeatTo(typeRelatedToEdit))).perform();
//       WebUI.sleep(1);

        System.out.println("✔ Edit TaskTest completed (Robot + Actions + Wait)");
    }

    /**
     * Hàm rút gọn: Ctrl + A + Delete
     */
    public void pressCtrlA_Delete(Robot robot) throws Exception {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        WebUI.sleep(1);

        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        WebUI.sleep(1);
    }

    public void clickEditButton(String taskName) throws InterruptedException {
//        Actions action = new Actions(driver);
//        action.moveToElement(WebUI.getWebElement(getFirstRowItemTask(taskName))).perform();
        WebUI.moveToElement(getFirstRowItemTask(taskName));
        WebUI.sleep(1);
        WebUI.clickElement(buttonEdit(taskName));
        WebUI.sleep(1);
    }

}
