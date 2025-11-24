package bai_tap_webelement_webdiver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import task.LocatorsCRMTask;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class AddNewTask extends LoginCRM {

    public void clickMenuTasks() throws InterruptedException {
        System.out.println("Click Menu Tasks");
        driver.findElement(By.xpath(LocatorsCRMTask.menuTasks)).click();
        Thread.sleep(1000);
    }

    public void clickButtonNewTask() throws InterruptedException {
        System.out.println("Click Button New Task");
        driver.findElement(By.xpath(LocatorsCRMTask.buttonNewTasks)).click();
        Thread.sleep(2000);
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
        assert actualSubject.equals(subject) : "FAIL: Subject không khớp";

        // HOURLY RATE
        String actualRate = driver.findElement(By.xpath(LocatorsCRMTask.inputHourlyRate)).getAttribute("value").trim();
        assert actualRate.equals(hourlyRate) : "FAIL: Hourly Rate không đúng";

        // START DATE
        String actualStart = driver.findElement(By.xpath(LocatorsCRMTask.inputStartDate)).getAttribute("value").trim();
        assert actualStart.equals(startDate) : "FAIL: Start Date không khớp";

        // DUE DATE
        String actualDue = driver.findElement(By.xpath(LocatorsCRMTask.inputDueDate)).getAttribute("value").trim();
        assert actualDue.equals(dueDate) : "FAIL: Due Date không khớp";

        // PRIORITY (Select2)
        String actualPriority = driver.findElement(By.xpath(
                "//label[contains(text(),'Priority')]/following-sibling::div//span[contains(@class,'select2-chosen')]"
        )).getText().trim();
        assert actualPriority.equals(priority) : "FAIL: Priority không đúng";

        // REPEAT EVERY (Select2)
        String actualRepeat = driver.findElement(By.xpath(
                "//label[contains(text(),'Repeat every')]/following-sibling::div//span[contains(@class,'select2-chosen')]"
        )).getText().trim();
        assert actualRepeat.equals(repeatEvery) : "FAIL: Repeat Every không đúng";

        // RELATED TO (Select2)
        String actualRelatedTo = driver.findElement(By.xpath(
                "//label[contains(text(),'Related to')]/following-sibling::div//span[contains(@class,'select2-chosen')]"
        )).getText().trim();
        assert actualRelatedTo.equals(relatedTo) : "FAIL: Related To không đúng";

        // ASSIGNEE (Select2)
        String actualAssignee = driver.findElement(By.xpath(
                "//label[contains(text(),'Assignees')]/following-sibling::div//span[contains(@class,'select2-chosen')]"
        )).getText().trim();
        assert actualAssignee.equals(assignee) : "FAIL: Assignee không đúng";

        // FOLLOWER
        List<WebElement> followers = driver.findElements(By.xpath("//label[contains(text(),'Followers')]/following-sibling::div//li//span"));
        boolean followerFound = followers.stream().anyMatch(f -> f.getText().trim().equals(follower));
        assert followerFound : "FAIL: Follower không đúng";

        // TAG (Tag-it)
        List<WebElement> tags = driver.findElements(By.xpath("//ul[@class='tagit-choice']//span[@class='tagit-label']"));
        boolean tagFound = tags.stream().anyMatch(t -> t.getText().trim().equals(tag));
        assert tagFound : "FAIL: Tag không khớp";

        // PUBLIC or BILLABLE
        if (flag == 1) {
            assert driver.findElement(By.xpath(LocatorsCRMTask.checkboxPublic)).isSelected()
                    : "FAIL: Public phải được tick";
        } else {
            assert driver.findElement(By.xpath(LocatorsCRMTask.checkboxBillable)).isSelected()
                    : "FAIL: Billable phải được tick";
        }

        System.out.println("VERIFY SUCCESS — Task data matches perfectly!");
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



    @Test
    public void testAddAndCheckNeưTask() throws InterruptedException {
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
        int flag = 1;

        clickMenuTasks();
        clickButtonNewTask();
        addNewTask(subject, hourlyRate, startDate, dueDate, priority, repeatEvery, relatedTo, assignee, follower, tag, flag);
        clickSave();
        clickCloseProffile();
        searchTaskNewAdd(subject);
        verifyNewTask(subject, hourlyRate, startDate, dueDate, priority, repeatEvery, relatedTo, assignee, follower, tag, flag);

    }
    @Test(priority = 1)
    public void testEditask() throws Exception {
        String subject = "Thaont09";
        String hourlyRate = "10";
        String startDate = "14-12-2025";
        String dueDate = "18-12-2025";
        String priority = "High";
        String repeatEvery = "1 Month";
        String totalCycles = "56622";
        String relatedTo = "Customer";
        String typeRelatedTo = "An test 02";
        String assignee = "Admin Anh Tester";
        String follower = "Admin Example";
        String tag = "JSC_NEW";
        int flag = 0;

       clickMenuTasks();
       clickButtonNewTask();

        addNewTask(subject, hourlyRate, startDate, dueDate, priority, repeatEvery, relatedTo, assignee, follower, tag, flag);
        Thread.sleep(2000);
        clickCloseProffile();

        searchTaskNewAdd("Thaont09");
        Thread.sleep(2000);

        verifyNewTask(subject, hourlyRate + ".00", startDate, dueDate, priority, repeatEvery, relatedTo, assignee, follower, tag, flag);
        Thread.sleep(2000);


        String subjectEdit = "Thaont09 Task 2";
        String hourlyRateEdit  = "20";
        String startDateEdit  = "20-12-2025";
        String dueDateEdit  = "25-12-2025";
        String priorityEdit  = "High";
        String repeatEveryEdit  = "2 Months";
        String relatedToEdit  = "Lead";
        String typeRelatedToEdit  = "Ha Ngoc Thao Leads";

        editTasks(subjectEdit, hourlyRateEdit, startDateEdit, dueDateEdit , priorityEdit , repeatEveryEdit , relatedToEdit , typeRelatedToEdit);
        clickSave();

        Thread.sleep(4000);

        Thread.sleep(4000);
    }




}
