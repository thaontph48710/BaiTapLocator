package thuc_hanh;

import bai_tap_locators.LocatorsLeadsCRM;
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
        driver.findElement(By.xpath(LocatorsCRMTask.menuTasks)).click();
        Thread.sleep(1000);
        Assert.assertTrue(checkExistsElement(LocatorsCRMTask.headerTasksPage), "Không truy cập được vào trang Tasks!");
    }

    public void clickButtonNewTask() throws InterruptedException {
        System.out.println("Click Button New Task");
        driver.findElement(By.xpath(LocatorsCRMTask.buttonNewTasks)).click();
        Thread.sleep(2000);
        Assert.assertTrue(checkExistsElement(LocatorsCRMTask.headerAddNewTask), "Khong mo duoc new task!");
    }

    public static void addNewTask(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                  String relatedTo, String assignee, String follower, String tag, int flag) throws InterruptedException {
        System.out.println("Add New Task");

        if (flag == 1) {
            driver.findElement(By.xpath(LocatorsCRMTask.checkboxPublic)).click();
            Thread.sleep(500);
        }
        if (flag == 0) {
            driver.findElement(By.xpath(LocatorsCRMTask.checkboxBillable)).click();
            Thread.sleep(500);
        }


        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsCRMTask.inputSubject)).sendKeys(subject);
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsCRMTask.inputHourlyRate)).clear();
        driver.findElement(By.xpath(LocatorsCRMTask.inputHourlyRate)).sendKeys(hourlyRate);
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsCRMTask.inputStartDate)).clear();
        driver.findElement(By.xpath(LocatorsCRMTask.inputStartDate)).sendKeys(startDate);
        Thread.sleep(2000);


        driver.findElement(By.xpath(LocatorsCRMTask.inputDueDate)).sendKeys(dueDate);
        Thread.sleep(2000);
// ---------------------------------Drowdown Prioryty-----------------------------
        driver.findElement(By.xpath(LocatorsCRMTask.dropdownPrioryty)).click();
        Thread.sleep(2000);
        String xpathPrioryty = LocatorsCRMTask.getValuePrioryty(priority);
        driver.findElement(By.xpath(xpathPrioryty)).click();
        Thread.sleep(2000);

//---------------------------------Drowdown Repeat Every-----------------------------
        driver.findElement(By.xpath(LocatorsCRMTask.dropdownRepeatEvery)).click();
        Thread.sleep(2000);
        String xpathRepeatEvery = LocatorsCRMTask.getRepeatEvery(repeatEvery);
        driver.findElement(By.xpath(xpathRepeatEvery)).click();
        Thread.sleep(2000);

//---------------------------------Drowdown Related To-----------------------------
        driver.findElement(By.xpath(LocatorsCRMTask.dropdownRelatedTo)).click();
        Thread.sleep(2000);
        String xpathRelatedTo = LocatorsCRMTask.listRelatedTo(relatedTo);
        driver.findElement(By.xpath(xpathRelatedTo)).click();
        Thread.sleep(2000);


//---------------------------------Drowdown Assignees-----------------------------
        driver.findElement(By.xpath(LocatorsCRMTask.dropdownAssignees)).click();
        Thread.sleep(2000);
        String xpatAssignees = LocatorsCRMTask.listAssignees(assignee);
        driver.findElement(By.xpath(xpatAssignees)).click();
        Thread.sleep(2000);

        //---------------------------------Drowdown Followers-----------------------------
        driver.findElement(By.xpath(LocatorsCRMTask.dropdownFollowers)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsCRMTask.inputSearchFollowers)).sendKeys(follower, Keys.ENTER);
        Thread.sleep(2000);

        //------------------- Xác định dropdown Tag---------------------------
        // Mở dropdown
        driver.findElement(By.xpath(LocatorsCRMTask.inputTag)).click();  // Tag
        Thread.sleep(2000);
        String xpathTags = LocatorsCRMTask.listTag(tag);
        driver.findElement(By.xpath(xpathTags)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsCRMTask.inputTaskDescription)).sendKeys("Hoc tap va lam viec");

        Thread.sleep(2000);



    }

    public void clickSave() throws InterruptedException {
        System.out.println("Click Save Task");
        driver.findElement(By.xpath(LocatorsCRMTask.buttonSave)).click();

        Thread.sleep(5000);
    }

    public void clickCloseProffile() throws InterruptedException {
        System.out.println("Close Profile");
        driver.findElement(By.xpath(LocatorsCRMTask.iconCloseProfile)).click();
        Thread.sleep(2000);
    }
    public static void searchTaskNewAdd(String Task) throws InterruptedException {

        driver.findElement(By.xpath(LocatorsCRMTask.menuTasks)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsCRMTask.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsCRMTask.inputSearch)).sendKeys(Task);
        Thread.sleep(2000);
        String firstRowOfTask = driver.findElement(By.xpath(LocatorsCRMTask.firstRowTask)).getText();
        System.out.println("First row Task: " + firstRowOfTask);
        Thread.sleep(6000);
    }
    public void verifyNewTask(String subject, String hourlyRate, String startDate, String dueDate,
                              String priority, String repeatEvery, String relatedTo, String assignee,
                              String follower, String tag, int flag) throws InterruptedException {

        System.out.println(" – Checking data after creating task...");

        Thread.sleep(2000);

        // SUBJECT
        String actualSubject = driver.findElement(By.xpath(LocatorsCRMTask.inputSubject)).getAttribute("value").trim();
        Assert.assertEquals(actualSubject, subject, "FAIL: Subject không khớp");

        // HOURLY RATE
        String actualRate = driver.findElement(By.xpath(LocatorsCRMTask.inputHourlyRate)).getAttribute("value").trim();
        Assert.assertEquals(actualRate, hourlyRate, "FAIL: Hourly Rate không khớp");

        // START DATE
        String actualStart = driver.findElement(By.xpath(LocatorsCRMTask.inputStartDate)).getAttribute("value").trim();
        Assert.assertEquals(actualStart, startDate, "FAIL: Start Date không khớp");


        // DUE DATE
        String actualDue = driver.findElement(By.xpath(LocatorsCRMTask.inputDueDate)).getAttribute("value").trim();
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
        String actualFolower = driver.findElement(By.xpath(LocatorsCRMTask.dropdownFollowers)).getText().trim();
        Assert.assertTrue(actualFolower.contains(follower), "FAIL: folower không chứa giá trị mong muốn");

        // TAG
        String actualTag = driver.findElement(By.xpath(LocatorsCRMTask.inputTag)).getText().trim();
        Assert.assertEquals(actualTag, tag, "FAIL: Source không khớp.");


        // PUBLIC or BILLABLE
        if (flag == 1) {
            boolean isPublicChecked = driver.findElement(By.xpath(LocatorsCRMTask.checkboxPublic)).isSelected();
            Assert.assertTrue(isPublicChecked, "FAIL: Checkbox Public không được chọn.");

        } else {
            boolean isBillableChecked = driver.findElement(By.xpath(LocatorsCRMTask.checkboxBillable)).isSelected();
            assert driver.findElement(By.xpath(LocatorsCRMTask.checkboxBillable)).isSelected()
                    : "FAIL: Billable phải được tick";
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
                By.xpath(LocatorsCRMTask.checkboxPublic)
        ));
        if (cbPublic.isSelected()) {
            actions.click(cbPublic).perform();
        }
        Thread.sleep(600);

        // ======================= CHECK BILLABLE ==========================
        WebElement cbBillable = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(LocatorsCRMTask.checkboxBillable)
        ));
        if (!cbBillable.isSelected()) {
            actions.click(cbBillable).perform();
        }
        Thread.sleep(600);

        // ======================= SUBJECT ==========================
        WebElement elementSubject = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(LocatorsCRMTask.inputSubject)
        ));
        actions.click(elementSubject).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(subjectEdit).perform();
        Thread.sleep(800);

        // ======================= HOURLY RATE ==========================
        WebElement elementHourlyRate = driver.findElement(By.xpath(LocatorsCRMTask.inputHourlyRate));
        actions.click(elementHourlyRate).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(hourlyRateEdit).perform();
        Thread.sleep(800);

        // ======================= START DATE ==========================
        WebElement elementStartDate = driver.findElement(By.xpath(LocatorsCRMTask.inputStartDate));
        actions.click(elementStartDate).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(startDateEdit).perform();
        Thread.sleep(800);

        // ======================= DUE DATE ==========================
        WebElement elementDueDate = driver.findElement(By.xpath(LocatorsCRMTask.inputDueDate));
        actions.click(elementDueDate).perform();
        Thread.sleep(300);

        pressCtrlA_Delete(robot);
        actions.sendKeys(dueDateEdit).perform();
        Thread.sleep(800);

        // ======================= PRIORITY SELECT2 ==========================
        actions.click(driver.findElement(By.xpath(LocatorsCRMTask.dropdownPrioryty))).perform();
        Thread.sleep(600);

        actions.click(driver.findElement(By.xpath(LocatorsCRMTask.getValuePrioryty(priorityEdit)))).perform();
        Thread.sleep(800);

        // ======================= REPEAT EVERY SELECT2 ==========================
        actions.click(driver.findElement(By.xpath(LocatorsCRMTask.dropdownRepeatEvery))).perform();
        Thread.sleep(600);

        actions.click(driver.findElement(By.xpath(LocatorsCRMTask.getRepeatEvery(repeatEveryEdit)))).perform();
        Thread.sleep(800);

        // ======================= RELATED TO (cấp 1) ==========================
        actions.click(driver.findElement(By.xpath(LocatorsCRMTask.dropdownRelatedTo))).perform();
        Thread.sleep(800);

        actions.click(driver.findElement(By.xpath(LocatorsCRMTask.getValueRepeatTo(relatedToEdit)))).perform();
        Thread.sleep(800);

        // ======================= TYPE OF RELATED (cấp 2) ==========================
        actions.click(driver.findElement(By.xpath(LocatorsCRMTask.dropdownValueForRepeatTo))).perform();
        Thread.sleep(600);

        WebElement searchBox = driver.findElement(By.xpath(LocatorsCRMTask.inputSearchValueForRepeatTo));
        actions.click(searchBox).perform();
        Thread.sleep(400);

        actions.sendKeys(typeRelatedToEdit).perform();
        Thread.sleep(800);

        // Enter để load option
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(800);

        actions.click(driver.findElement(By.xpath(LocatorsCRMTask.getValueForRepeatTo(typeRelatedToEdit)))).perform();
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
        action.moveToElement(driver.findElement(By.xpath(LocatorsCRMTask.getFirstRowItemTask(taskName)))).perform();
        Thread.sleep(1000);
//        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonEdit(taskName))).click();
//        Thread.sleep(2000);
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
