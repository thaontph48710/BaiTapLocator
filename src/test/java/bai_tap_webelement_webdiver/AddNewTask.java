package bai_tap_webelement_webdiver;

import leads.LocatorsLeadsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import task.LocatorsCRMTask;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class AddNewTask extends LoginCRM {

    public static void addNewTask(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                  String relatedTo, String assignee, String follower, String tag, int flag) throws InterruptedException {
        System.out.println("Add New Task");
        driver.findElement(By.xpath(LocatorsCRMTask.menuTasks)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRMTask.buttonNewTasks)).click();
        Thread.sleep(2000);

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

        driver.findElement(By.xpath(LocatorsCRMTask.buttonSave)).click();

        Thread.sleep(5000);

    }
    public static void searchTaskNewAdd(String Task) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsCRMTask.iconCloseProfile)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsCRMTask.menuTasks)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsCRMTask.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsCRMTask.inputSearch)).sendKeys(Task);
        Thread.sleep(2000);
        String firstRowOfTask = driver.findElement(By.xpath(LocatorsCRMTask.firstRowTask)).getText();
        System.out.println("First row Task: " + firstRowOfTask);
        Thread.sleep(6000);
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
        addNewTask(subject, hourlyRate, startDate, dueDate, priority, repeatEvery, relatedTo, assignee, follower, tag, flag);
        searchTaskNewAdd(subject);
    }



}
