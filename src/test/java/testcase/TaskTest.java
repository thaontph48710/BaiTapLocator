package testcase;

import com.helpers.ExcelHelper;
import models.LeadsDTO;
import models.TaskDTO;
import pages.DashboardPage;
import common.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TaskPage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private TaskPage taskPage;
    private TaskDTO getTaskDataFromExcel(int rowIndex) {

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Task");
        TaskDTO task = new TaskDTO();
        task.setSubject(excel.getCellData("SUBJECT", rowIndex));
        task.setHourlyRate(excel.getCellData("HOURLYRATE", rowIndex));
        task.setStartDate(excel.getCellData("STARTDATE", rowIndex));
        task.setDueDate(excel.getCellData("DUEDATE", rowIndex));
        task.setPriority(excel.getCellData("PRIORITY", rowIndex));
        task.setRepeatEvery(excel.getCellData("REPEATEVERY", rowIndex));
        task.setRelatedTo(excel.getCellData("RELATEDTO", rowIndex));
        task.setTypeRelatedTo(excel.getCellData("TYPERELATEDTO", rowIndex));
        task.setAssignee(excel.getCellData("ASSIGNEE", rowIndex));
        task.setFollower(excel.getCellData("FOLLOWER", rowIndex));
        task.setDescription(excel.getCellData("DESCIPTION", rowIndex));
        task.setTag(excel.getCellData("TAG", rowIndex));
        task.setFlag(Integer.parseInt(excel.getCellData("FLAG", rowIndex)));
        return task;
    }



    @Test(priority = 1)
    public void testAddTaskAndCheckNewTask() throws InterruptedException {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();

        TaskDTO taskData = getTaskDataFromExcel(1);
        String dateTime =  new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskData.setSubject(taskData.getSubject() + dateTime);

        taskPage.clickButtonNewTask();
        taskPage.addNewTask(taskData);
        taskPage.clickSave();
        taskPage.clickCloseProffile();
        taskPage.searchTaskNewAdd(taskData.getSubject());
        taskPage.clickEditButton(taskData.getSubject());
        taskPage.verifyNewTask(taskData);

    }

    @Test(priority = 2)
    public void testEditask() throws Exception {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();

        TaskDTO taskData = getTaskDataFromExcel(1);
        String dateTime =  new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskData.setSubject(taskData.getSubject() + dateTime);
        taskPage.clickButtonNewTask();
        taskPage.addNewTask(taskData);
        taskPage.clickSave();
        taskPage.clickCloseProffile();
        taskPage.searchTaskNewAdd(taskData.getSubject());
        taskPage.clickEditButton(taskData.getSubject());

        taskPage.verifyNewTask(taskData);
        TaskDTO taskDataEdit = getTaskDataFromExcel(2);

        taskDataEdit.setSubject(taskDataEdit.getSubject() + dateTime);

        taskPage.editTasks(taskDataEdit);
        taskPage.clickSave();
        taskPage.clickCloseProffile();
        taskPage.searchTaskNewAdd(taskDataEdit.getSubject());
        taskPage.clickEditButton(taskDataEdit.getSubject());
        taskPage.verifyNewTask(taskDataEdit);
    }


}
