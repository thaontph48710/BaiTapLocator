package bai_tap_webelement_webdiver;

import leads.LocatorsLeadsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import task.LocatorsCRMTask;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AddNewTask extends LoginCRM {

    public static void addNewTask(String Task) throws InterruptedException {
        System.out.println("Add New Task");
        driver.findElement(By.xpath(LocatorsCRMTask.menuTasks)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRMTask.buttonNewTasks)).click();
        Thread.sleep(2000);

        boolean isPublicSelected = driver.findElement(By.xpath(LocatorsCRMTask.checkboxPublic)).isSelected();
        if (isPublicSelected == false) {
            driver.findElement(By.xpath(LocatorsCRMTask.checkboxPublic)).click();
        }
        Thread.sleep(2000);
        boolean isBillableSelected = driver.findElement(By.xpath(LocatorsCRMTask.checkboxBillable)).isSelected();
        if (isBillableSelected == true) {
            driver.findElement(By.xpath(LocatorsCRMTask.checkboxBillable)).click();

        }

        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsCRMTask.inputSubject)).sendKeys(Task);
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsCRMTask.inputHourlyRate)).clear();
        driver.findElement(By.xpath(LocatorsCRMTask.inputHourlyRate)).sendKeys("50");
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsCRMTask.inputStartDate)).clear();
        driver.findElement(By.xpath(LocatorsCRMTask.inputStartDate)).sendKeys("08/11/2025");
        Thread.sleep(2000);


        driver.findElement(By.xpath(LocatorsCRMTask.inputDueDate)).sendKeys("08/12/2025");
        Thread.sleep(2000);
// ---------------------------------Drowdown Prioryty-----------------------------
        driver.findElement(By.xpath(LocatorsCRMTask.dropdownPrioryty)).click();
        Thread.sleep(2000);
        String xpathPrioryty = LocatorsCRMTask.getValuePrioryty("High");
        driver.findElement(By.xpath(xpathPrioryty)).click();
        Thread.sleep(2000);

//---------------------------------Drowdown Repeat Every-----------------------------
        driver.findElement(By.xpath(LocatorsCRMTask.dropdownRepeatEvery)).click();
        Thread.sleep(2000);
        String xpathRepeatEvery = LocatorsCRMTask.getRepeatEvery("Week");
        driver.findElement(By.xpath(xpathRepeatEvery)).click();
        Thread.sleep(2000);

//---------------------------------Drowdown Related To-----------------------------
        driver.findElement(By.xpath(LocatorsCRMTask.dropdownRelatedTo)).click();
        Thread.sleep(2000);
        String xpathRelatedTo = LocatorsCRMTask.listRelatedTo("Project");
        driver.findElement(By.xpath(xpathRelatedTo)).click();
        Thread.sleep(2000);


//---------------------------------Drowdown Assignees-----------------------------
        driver.findElement(By.xpath(LocatorsCRMTask.dropdownAssignees)).click();
        Thread.sleep(2000);
        String xpatAssignees = LocatorsCRMTask.listAssignees("Admin Anh Tester");
        driver.findElement(By.xpath(xpatAssignees)).click();
        Thread.sleep(2000);

        //---------------------------------Drowdown Followers-----------------------------
        driver.findElement(By.xpath(LocatorsCRMTask.dropdownFollowers)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsCRMTask.inputSearchFollowers)).sendKeys("Admin Anh Tester");
        Thread.sleep(2000);

        //------------------- Xác định dropdown Tag---------------------------
        // Mở dropdown
        driver.findElement(By.xpath(LocatorsCRMTask.inputTag)).click();  // Tag
        Thread.sleep(2000);
        String xpathTags = LocatorsCRMTask.listTag("Selenium");
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

    public static void main(String[] args) throws InterruptedException {
        createChromeDriver();
        loginCRM();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String currentDateTime = now.format(formatter);
        addNewTask("TaskHaNgocThao " + currentDateTime);
        searchTaskNewAdd("TaskHaNgocThao " + currentDateTime);
        driver.quit();


    }
}
