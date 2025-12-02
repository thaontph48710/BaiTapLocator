package thuc_hanh;

import bai_tap_locators.LocatorsLeadsCRM;
import com.thaotest.WebUI;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import bai_tap_locators.LocatorsCRMTask;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import static bai_tap_locators.LocatorsLeadsCRM.*;

public class Task extends BaseTest {

    public void clickMenuTasks() throws InterruptedException {
        System.out.println("Click Menu Tasks");
        WebUI.clickElement(driver, LocatorsCRMTask.menuTasks);

        Assert.assertTrue(WebUI.checkExistsElement(driver,LocatorsCRMTask.headerTasksPage), "Không truy cập được vào trang Tasks!");
    }

    public void clickButtonNewTask() throws InterruptedException {
        System.out.println("Click Button New Task");
        WebUI.clickElement(driver, LocatorsCRMTask.buttonNewTasks);

        Assert.assertTrue(WebUI.checkExistsElement(driver,LocatorsCRMTask.headerAddNewTask), "Khong mo duoc new task!");
    }

    public static void addNewTask(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                  String relatedTo, String assignee, String follower, String tag, int flag) throws InterruptedException {
        System.out.println("Add New Task");

        if (flag == 1) {
            WebUI.clickElement(driver, LocatorsCRMTask.checkboxPublic);

        }
        if (flag == 0) {
            WebUI.clickElement(driver, LocatorsCRMTask.checkboxBillable);

        }
        WebUI.setTextElement(driver, LocatorsCRMTask.inputSubject, subject);
        WebUI.clearElementText(driver, LocatorsCRMTask.inputSubject);
        WebUI.setTextElement(driver, LocatorsCRMTask.inputHourlyRate, hourlyRate);
        WebUI.clearElementText(driver, LocatorsCRMTask.inputStartDate);
        WebUI.setTextElement(driver, LocatorsCRMTask.inputStartDate, startDate);
        WebUI.setTextElement(driver, LocatorsCRMTask.inputDueDate, dueDate);

// ---------------------------------Drowdown Prioryty-----------------------------
        WebUI.clickElement(driver, LocatorsCRMTask.dropdownPrioryty);
        WebUI.clickElement(driver, LocatorsCRMTask.getValuePrioryty(priority));
        Thread.sleep(2000);

//---------------------------------Drowdown Repeat Every-----------------------------
        WebUI.clickElement(driver, LocatorsCRMTask.dropdownRepeatEvery);
        WebUI.clickElement(driver, LocatorsCRMTask.getRepeatEvery(repeatEvery));
        Thread.sleep(2000);

//---------------------------------Drowdown Related To-----------------------------
        WebUI.clickElement(driver, LocatorsCRMTask.dropdownRelatedTo);
        WebUI.clickElement(driver, LocatorsCRMTask.listRelatedTo(relatedTo));
        Thread.sleep(2000);


//---------------------------------Drowdown Assignees-----------------------------
        WebUI.clickElement(driver, LocatorsCRMTask.dropdownAssignees);
        WebUI.clickElement(driver, LocatorsCRMTask.listAssignees(assignee));
        Thread.sleep(2000);

        //---------------------------------Drowdown Followers-----------------------------
        WebUI.clickElement(driver, LocatorsCRMTask.dropdownFollowers);
        WebUI.clickElement(driver, LocatorsCRMTask.listFollowers(follower));
        Thread.sleep(2000);

        //------------------- Xác định dropdown Tag---------------------------
        // Mở dropdown
        WebUI.clickElement(driver,LocatorsCRMTask.inputTag);  // Tag
        WebUI.clickElement(driver, LocatorsCRMTask.listTag(tag));
        Thread.sleep(2000);

        WebUI.setTextElement(driver, LocatorsCRMTask.inputTaskDescription, "Hoc tap va lam viec");

        Thread.sleep(2000);



    }

    public void clickSave() throws InterruptedException {
        System.out.println("Click Save Task");
     WebUI.clickElement(driver,LocatorsCRMTask.buttonSave);

    }

    public void clickCloseProffile() throws InterruptedException {
        System.out.println("Close Profile");
        WebUI.clickElement(driver,LocatorsCRMTask.iconCloseProfile);

    }
    public static void searchTaskNewAdd(String Task) throws InterruptedException {
        WebUI.clickElement(driver,LocatorsCRMTask.menuTasks);
        WebUI.clearElementText(driver,LocatorsCRMTask.inputSearch);

       WebUI.setTextElement(driver,LocatorsCRMTask.inputSearch,Task);
        Thread.sleep(2000);
        String firstRowOfTask = WebUI.getText(driver,LocatorsCRMTask.firstRowTask);
        System.out.println("First row Task: " + firstRowOfTask);
        Thread.sleep(6000);
    }
    public void verifyNewTask(String subject, String hourlyRate, String startDate, String dueDate,
                              String priority, String repeatEvery, String relatedTo, String assignee,
                              String follower, String tag, int flag) throws InterruptedException {

        System.out.println(" – Checking data after creating task...");

        Thread.sleep(2000);

        // SUBJECT
        String actualSubject = WebUI.getElementAttribute(driver,LocatorsCRMTask.inputSubject,"value").trim();
        Assert.assertEquals(actualSubject, subject, "FAIL: Subject không khớp");

        // HOURLY RATE
        String actualRate = WebUI.getElementAttribute(driver,LocatorsCRMTask.inputHourlyRate,"value").trim();
        Assert.assertEquals(actualRate, hourlyRate, "FAIL: Hourly Rate không khớp");

        // START DATE
        String actualStart = WebUI.getElementAttribute(driver,LocatorsCRMTask.inputStartDate,"value").trim();
        Assert.assertEquals(actualStart, startDate, "FAIL: Start Date không khớp");


        // DUE DATE
        String actualDue = WebUI.getElementAttribute(driver,LocatorsCRMTask.inputDueDate,"value").trim();
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
        String actualFolower = WebUI.getText(driver,LocatorsCRMTask.dropdownFollowers).trim();
        Assert.assertTrue(actualFolower.contains(follower), "FAIL: folower không chứa giá trị mong muốn");

        // TAG
        String actualTag =  WebUI.getText(driver,LocatorsCRMTask.inputTag).trim();
        Assert.assertEquals(actualTag, tag, "FAIL: Source không khớp.");


        // PUBLIC or BILLABLE
        if (flag == 1) {
            boolean isPublicChecked = WebUI.checkSeletedElement(driver,LocatorsCRMTask.checkboxPublic);
            Assert.assertTrue(isPublicChecked, "FAIL: Checkbox Public không được chọn.");

        } else {
            boolean isBillableChecked = WebUI.checkSeletedElement(driver,LocatorsCRMTask.checkboxBillable);
            Assert.assertFalse(WebUI.checkSeletedElement(driver, LocatorsCRMTask.checkboxBillable), "Checkbox không được chọn");

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
                WebUI.getWebElement(driver,LocatorsCRMTask.checkboxPublic)
        ));
        if (cbPublic.isSelected()) {
            actions.click(cbPublic).perform();
        }
        Thread.sleep(600);

        // ======================= CHECK BILLABLE ==========================
        WebElement cbBillable = wait.until(ExpectedConditions.elementToBeClickable(
                WebUI.getWebElement(driver,LocatorsCRMTask.checkboxBillable)
        ));
        if (!cbBillable.isSelected()) {
            actions.click(cbBillable).perform();
        }
        Thread.sleep(600);

        // ======================= SUBJECT ==========================
        WebElement elementSubject = wait.until(ExpectedConditions.elementToBeClickable(
                WebUI.getWebElement(driver,LocatorsCRMTask.inputSubject)
        ));
        actions.click(elementSubject).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(subjectEdit).perform();
        Thread.sleep(800);

        // ======================= HOURLY RATE ==========================
        WebElement elementHourlyRate =  WebUI.getWebElement(driver,LocatorsCRMTask.inputHourlyRate);
        actions.click(elementHourlyRate).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(hourlyRateEdit).perform();
        Thread.sleep(800);

        // ======================= START DATE ==========================
        WebElement elementStartDate =  WebUI.getWebElement(driver,LocatorsCRMTask.inputStartDate);
        actions.click(elementStartDate).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(startDateEdit).perform();
        Thread.sleep(800);

        // ======================= DUE DATE ==========================
        WebElement elementDueDate = WebUI.getWebElement(driver,LocatorsCRMTask.inputDueDate);
        actions.click(elementDueDate).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(dueDateEdit).perform();
        Thread.sleep(800);

        // ======================= PRIORITY SELECT2 ==========================
        actions.click(WebUI.getWebElement(driver,LocatorsCRMTask.dropdownPrioryty)).perform();
        Thread.sleep(600);

        actions.click(WebUI.getWebElement(driver,LocatorsCRMTask.getValuePrioryty(priorityEdit))).perform();
        Thread.sleep(800);

        // ======================= REPEAT EVERY SELECT2 ==========================
        actions.click(WebUI.getWebElement(driver,LocatorsCRMTask.dropdownRepeatEvery)).perform();
        Thread.sleep(600);

        actions.click(WebUI.getWebElement(driver,LocatorsCRMTask.getRepeatEvery(repeatEveryEdit))).perform();
        Thread.sleep(800);

        // ======================= RELATED TO (cấp 1) ==========================
        actions.click(WebUI.getWebElement(driver,LocatorsCRMTask.dropdownRelatedTo)).perform();
        Thread.sleep(800);

        actions.click(WebUI.getWebElement(driver,LocatorsCRMTask.getValueRepeatTo(relatedToEdit))).perform();
        Thread.sleep(800);

        // ======================= TYPE OF RELATED (cấp 2) ==========================
        actions.click(WebUI.getWebElement(driver,LocatorsCRMTask.dropdownValueForRepeatTo)).perform();
        Thread.sleep(600);

        WebElement searchBox = WebUI.getWebElement(driver,LocatorsCRMTask.inputSearchValueForRepeatTo);
        actions.click(searchBox).perform();
        Thread.sleep(400);

        actions.sendKeys(typeRelatedToEdit).perform();
        Thread.sleep(800);

        // Enter để load option
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(800);

        actions.click(WebUI.getWebElement(driver,LocatorsCRMTask.getValueForRepeatTo(typeRelatedToEdit))).perform();
        Thread.sleep(1000);

        System.out.println("✔ Edit Task completed (Robot + Actions + Wait)");
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
        action.moveToElement(WebUI.getWebElement(driver,LocatorsCRMTask.getFirstRowItemTask(taskName))).perform();
        Thread.sleep(1000);
        WebUI.clickElement(driver,LocatorsLeadsCRM.buttonEdit(taskName));
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
        relatedTo  = "Ha Ngoc Thao Leads";

        editTasks(nameSubject, hourlyRate, startDate, dueDate , priority , repeatEvery , relatedTo , relatedTo);
        clickSave();

        Thread.sleep(4000);
        verifyNewTask(subject, hourlyRate + ".00", startDate, dueDate, priority, repeatEvery, relatedTo, assignee, follower, tag, 0);
        Thread.sleep(4000);
    }




}
