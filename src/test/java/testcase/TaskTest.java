package testcase;

import pages.LeadsPage;
import com.thaotest.WebUI;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TaskPage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TaskTest extends BaseTest {

    public void clickMenuTasks() throws InterruptedException {
        System.out.println("Click Menu Tasks");
        WebUI.clickElement(driver, TaskPage.menuTasks);

        Assert.assertTrue(WebUI.checkExistsElement(driver, TaskPage.headerTasksPage), "Không truy cập được vào trang Tasks!");
    }

    public void clickButtonNewTask() throws InterruptedException {
        System.out.println("Click Button New TaskTest");
        WebUI.clickElement(driver, TaskPage.buttonNewTasks);

        Assert.assertTrue(WebUI.checkExistsElement(driver, TaskPage.headerAddNewTask), "Khong mo duoc new task!");
    }

    public static void addNewTask(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                  String relatedTo, String assignee, String follower, String tag, int flag) throws InterruptedException {
        System.out.println("Add New TaskTest");

        if (flag == 1) {
            WebUI.clickElement(driver, TaskPage.checkboxPublic);

        }
        if (flag == 0) {
            WebUI.clickElement(driver, TaskPage.checkboxBillable);

        }
        WebUI.setTextElement(driver, TaskPage.inputSubject, subject);
        WebUI.clearElementText(driver, TaskPage.inputSubject);
        WebUI.setTextElement(driver, TaskPage.inputHourlyRate, hourlyRate);
        WebUI.clearElementText(driver, TaskPage.inputStartDate);
        WebUI.setTextElement(driver, TaskPage.inputStartDate, startDate);
        WebUI.setTextElement(driver, TaskPage.inputDueDate, dueDate);

// ---------------------------------Drowdown Prioryty-----------------------------
        WebUI.clickElement(driver, TaskPage.dropdownPrioryty);
        WebUI.clickElement(driver, TaskPage.getValuePrioryty(priority));
        Thread.sleep(2000);

//---------------------------------Drowdown Repeat Every-----------------------------
        WebUI.clickElement(driver, TaskPage.dropdownRepeatEvery);
        WebUI.clickElement(driver, TaskPage.getRepeatEvery(repeatEvery));
        Thread.sleep(2000);

//---------------------------------Drowdown Related To-----------------------------
        WebUI.clickElement(driver, TaskPage.dropdownRelatedTo);
        WebUI.clickElement(driver, TaskPage.listRelatedTo(relatedTo));
        Thread.sleep(2000);


//---------------------------------Drowdown Assignees-----------------------------
        WebUI.clickElement(driver, TaskPage.dropdownAssignees);
        WebUI.clickElement(driver, TaskPage.listAssignees(assignee));
        Thread.sleep(2000);

        //---------------------------------Drowdown Followers-----------------------------
        WebUI.clickElement(driver, TaskPage.dropdownFollowers);
        WebUI.clickElement(driver, TaskPage.listFollowers(follower));
        Thread.sleep(2000);

        //------------------- Xác định dropdown Tag---------------------------
        // Mở dropdown
        WebUI.clickElement(driver, TaskPage.inputTag);  // Tag
        WebUI.clickElement(driver, TaskPage.listTag(tag));
        Thread.sleep(2000);

        WebUI.setTextElement(driver, TaskPage.inputTaskDescription, "Hoc tap va lam viec");

        Thread.sleep(2000);



    }

    public void clickSave() throws InterruptedException {
        System.out.println("Click Save TaskTest");
     WebUI.clickElement(driver, TaskPage.buttonSave);

    }

    public void clickCloseProffile() throws InterruptedException {
        System.out.println("Close Profile");
        WebUI.clickElement(driver, TaskPage.iconCloseProfile);

    }
    public static void searchTaskNewAdd(String Task) throws InterruptedException {
        WebUI.clickElement(driver, TaskPage.menuTasks);
        WebUI.clearElementText(driver, TaskPage.inputSearch);

       WebUI.setTextElement(driver, TaskPage.inputSearch,Task);
        Thread.sleep(2000);
        String firstRowOfTask = WebUI.getText(driver, TaskPage.firstRowTask);
        System.out.println("First row TaskTest: " + firstRowOfTask);
        Thread.sleep(6000);
    }
    public void verifyNewTask(String subject, String hourlyRate, String startDate, String dueDate,
                              String priority, String repeatEvery, String relatedTo, String assignee,
                              String follower, String tag, int flag) throws InterruptedException {

        System.out.println(" – Checking data after creating task...");

        Thread.sleep(2000);

        // SUBJECT
        String actualSubject = WebUI.getElementAttribute(driver, TaskPage.inputSubject,"value").trim();
        Assert.assertEquals(actualSubject, subject, "FAIL: Subject không khớp");

        // HOURLY RATE
        String actualRate = WebUI.getElementAttribute(driver, TaskPage.inputHourlyRate,"value").trim();
        Assert.assertEquals(actualRate, hourlyRate, "FAIL: Hourly Rate không khớp");

        // START DATE
        String actualStart = WebUI.getElementAttribute(driver, TaskPage.inputStartDate,"value").trim();
        Assert.assertEquals(actualStart, startDate, "FAIL: Start Date không khớp");


        // DUE DATE
        String actualDue = WebUI.getElementAttribute(driver, TaskPage.inputDueDate,"value").trim();
        Assert.assertEquals(actualDue, dueDate, "FAIL: Due Date không khớp");

        // PRIORITY (Select2)
        String actualPriority = driver.findElement(By.xpath(
                "//label[contains(text(),'Priority')]/following-sibling::div//span[contains(@class,'select2-chosen')]"
        )).getText().trim();
        Assert.assertEquals(actualPriority, priority, "FAIL: Priority không đúng");


        // REPEAT EVERY (Select2)
        String actualRepeat = driver.findElement(By.xpath(
                "//label[contains(text(),'Repeat every')]/following-sibling::div//span[contains(@class,'select2-chosen')]"
        )).getText().trim();
        Assert.assertEquals(actualRepeat, repeatEvery, "FAIL: Repeat Every không đúng");


        // RELATED TO (Select2)
        String actualRelatedTo = driver.findElement(By.xpath(
                "//label[contains(text(),'Related to')]/following-sibling::div//span[contains(@class,'select2-chosen')]"
        )).getText().trim();
        Assert.assertEquals(actualRelatedTo, relatedTo, "FAIL: Related To không đúng");


        // ASSIGNEE (Select2)
        String actualAssignee = driver.findElement(By.xpath(
                "//label[contains(text(),'Assignees')]/following-sibling::div//span[contains(@class,'select2-chosen')]"
        )).getText().trim();
        Assert.assertEquals(actualAssignee, assignee, "FAIL: Assignee không đúng");


        // FOLLOWER
        String actualFolower = WebUI.getText(driver, TaskPage.dropdownFollowers).trim();
        Assert.assertTrue(actualFolower.contains(follower), "FAIL: folower không chứa giá trị mong muốn");

        // TAG
        String actualTag =  WebUI.getText(driver, TaskPage.inputTag).trim();
        Assert.assertEquals(actualTag, tag, "FAIL: Source không khớp.");


        // PUBLIC or BILLABLE
        if (flag == 1) {
            boolean isPublicChecked = WebUI.checkSeletedElement(driver, TaskPage.checkboxPublic);
            Assert.assertTrue(isPublicChecked, "FAIL: Checkbox Public không được chọn.");

        } else {
            boolean isBillableChecked = WebUI.checkSeletedElement(driver, TaskPage.checkboxBillable);
            Assert.assertFalse(WebUI.checkSeletedElement(driver, TaskPage.checkboxBillable), "Checkbox không được chọn");

        }

        System.out.println("VERIFY SUCCESS — dữ liệu task KHỚP hoàn toàn!");
    }

    public static void editTasks(String subjectEdit, String hourlyRateEdit, String startDateEdit, String dueDateEdit,
                                 String priorityEdit, String repeatEveryEdit,
                                 String relatedToEdit, String typeRelatedToEdit) throws Exception {

        Actions actions = new Actions(driver);
        Robot robot = new Robot();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ======================= UNCHECK PUBLIC ==========================
        WebElement cbPublic = wait.until(ExpectedConditions.elementToBeClickable(
                WebUI.getWebElement(driver, TaskPage.checkboxPublic)
        ));
        if (cbPublic.isSelected()) {
            actions.click(cbPublic).perform();
        }
        Thread.sleep(600);

        // ======================= CHECK BILLABLE ==========================
        WebElement cbBillable = wait.until(ExpectedConditions.elementToBeClickable(
                WebUI.getWebElement(driver, TaskPage.checkboxBillable)
        ));
        if (!cbBillable.isSelected()) {
            actions.click(cbBillable).perform();
        }
        Thread.sleep(600);

        // ======================= SUBJECT ==========================
        WebElement elementSubject = wait.until(ExpectedConditions.elementToBeClickable(
                WebUI.getWebElement(driver, TaskPage.inputSubject)
        ));
        actions.click(elementSubject).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(subjectEdit).perform();
        Thread.sleep(800);

        // ======================= HOURLY RATE ==========================
        WebElement elementHourlyRate =  WebUI.getWebElement(driver, TaskPage.inputHourlyRate);
        actions.click(elementHourlyRate).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(hourlyRateEdit).perform();
        Thread.sleep(800);

        // ======================= START DATE ==========================
        WebElement elementStartDate =  WebUI.getWebElement(driver, TaskPage.inputStartDate);
        actions.click(elementStartDate).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(startDateEdit).perform();
        Thread.sleep(800);

        // ======================= DUE DATE ==========================
        WebElement elementDueDate = WebUI.getWebElement(driver, TaskPage.inputDueDate);
        actions.click(elementDueDate).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(dueDateEdit).perform();
        Thread.sleep(800);

        // ======================= PRIORITY SELECT2 ==========================
        actions.click(WebUI.getWebElement(driver, TaskPage.dropdownPrioryty)).perform();
        Thread.sleep(600);

        actions.click(WebUI.getWebElement(driver, TaskPage.getValuePrioryty(priorityEdit))).perform();
        Thread.sleep(800);

        // ======================= REPEAT EVERY SELECT2 ==========================
        actions.click(WebUI.getWebElement(driver, TaskPage.dropdownRepeatEvery)).perform();
        Thread.sleep(600);

        actions.click(WebUI.getWebElement(driver, TaskPage.getRepeatEvery(repeatEveryEdit))).perform();
        Thread.sleep(800);

        // ======================= RELATED TO (cấp 1) ==========================
        actions.click(WebUI.getWebElement(driver, TaskPage.dropdownRelatedTo)).perform();
        Thread.sleep(800);

        actions.click(WebUI.getWebElement(driver, TaskPage.getValueRepeatTo(relatedToEdit))).perform();
        Thread.sleep(800);

        // ======================= TYPE OF RELATED (cấp 2) ==========================
        actions.click(WebUI.getWebElement(driver, TaskPage.dropdownValueForRepeatTo)).perform();
        Thread.sleep(600);

        WebElement searchBox = WebUI.getWebElement(driver, TaskPage.inputSearchValueForRepeatTo);
        actions.click(searchBox).perform();
        Thread.sleep(400);

        actions.sendKeys(typeRelatedToEdit).perform();
        Thread.sleep(800);

        // Enter để load option
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(800);

        actions.click(WebUI.getWebElement(driver, TaskPage.getValueForRepeatTo(typeRelatedToEdit))).perform();
        Thread.sleep(1000);

        System.out.println("✔ Edit TaskTest completed (Robot + Actions + Wait)");
    }

    /** Hàm rút gọn: Ctrl + A + Delete */
    public static void pressCtrlA_Delete(Robot robot) throws Exception {
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
        action.moveToElement(WebUI.getWebElement(driver, TaskPage.getFirstRowItemTask(taskName))).perform();
        Thread.sleep(1000);
        WebUI.clickElement(driver, LeadsPage.buttonEdit(taskName));
        Thread.sleep(2000);
    }
    String subject = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
    String hourlyRate = "50";
    String startDate = "20/06/2024";
    String dueDate = "25/06/2024";
    String priority = "High";
    String repeatEvery = "Week";
    String relatedTo = "Project";
    String assignee = "Admin Example";
    String follower = "Admin Example";
    String tag = "Selenium";


    @Test
    public void testAddAndCheckNewTask() throws InterruptedException {


        clickMenuTasks();
        clickButtonNewTask();
        addNewTask(subject, hourlyRate, startDate, dueDate, priority, repeatEvery, relatedTo, assignee, follower, tag, 1);
        clickSave();
        clickCloseProffile();
        searchTaskNewAdd(subject);
        clickEditButton(subject);
        verifyNewTask(subject, hourlyRate, startDate, dueDate, priority, repeatEvery, relatedTo, assignee, follower, tag, 1);

    }
    @Test(priority = 1)
    public void testEditask() throws Exception {

         subject = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
       clickMenuTasks();
       clickButtonNewTask();

        addNewTask(subject, hourlyRate, startDate, dueDate, priority, repeatEvery, relatedTo, assignee, follower, tag, 0);
        Thread.sleep(2000);
        clickCloseProffile();

        searchTaskNewAdd(subject);
        Thread.sleep(2000);

        verifyNewTask(subject, hourlyRate + ".00", startDate, dueDate, priority, repeatEvery, relatedTo, assignee, follower, tag, 0);
        Thread.sleep(2000);


        String nameSubject = subject + "_Edit";
         hourlyRate  = "20";
         startDate  = "20-12-2025";
         dueDate  = "25-12-2025";
         priority  = "High";
         repeatEvery  = "2 Months";
         relatedTo = "Lead";
        relatedTo  = "Ha Ngoc Thao LeadsTest";

        editTasks(nameSubject, hourlyRate, startDate, dueDate , priority , repeatEvery , relatedTo , relatedTo);
        clickSave();

        Thread.sleep(4000);
        verifyNewTask(subject, hourlyRate + ".00", startDate, dueDate, priority, repeatEvery, relatedTo, assignee, follower, tag, 0);
        Thread.sleep(4000);
    }




}
