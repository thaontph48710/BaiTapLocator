package testcase;

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
    String subject = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
    String hourlyRate = "50";
    String startDate = "20-06-2024";
    String dueDate = "25-06-2024";
    String priority = "High";
    String repeatEvery = "Week";
    String relatedTo = "Lead";
    String typeRelatedTo = "HaNgocThao_04122025_231550";
    String assignee = "Admin Anh Tester";
    String follower = "Admin Example";
    String description = " description Admin Example";
    String tag = "test";


    @Test(priority = 1)
    public void testAddTaskAndCheckNewTask() throws InterruptedException {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();

        subject = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());

        taskPage.clickButtonNewTask();
        taskPage.addNewTask(subject, hourlyRate, startDate, dueDate, priority, repeatEvery, relatedTo, typeRelatedTo, assignee, follower, description, tag, 1);
        taskPage.clickSave();
        taskPage.clickCloseProffile();
        taskPage.searchTaskNewAdd(subject);
        taskPage.clickEditButton(subject);
        taskPage.verifyNewTask(subject, hourlyRate, startDate, dueDate, priority, repeatEvery, relatedTo, typeRelatedTo, assignee, follower, tag, 1);

    }

    @Test(priority = 2)
    public void testEditask() throws Exception {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        taskPage = dashboardPage.clickMenuTask();

        subject = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskPage.clickButtonNewTask();
        taskPage.addNewTask(subject, hourlyRate, startDate, dueDate, priority, repeatEvery, relatedTo, typeRelatedTo, assignee, follower, description, tag, 0);
        taskPage.clickSave();
        taskPage.clickCloseProffile();
        taskPage.searchTaskNewAdd(subject);
        taskPage.clickEditButton(subject);

        taskPage.verifyNewTask(subject, hourlyRate + ".00", startDate, dueDate, priority, repeatEvery, relatedTo, typeRelatedTo, assignee, follower, tag, 0);
        String nameSubject = subject + "_Edit";
        hourlyRate = "20";
        startDate = "20-12-2025";
        dueDate = "25-12-2025";
        priority = "High";
        repeatEvery = "2 Months";
        relatedTo = "Lead";
//        typeRelatedTo  = "Giang Test";

        taskPage.editTasks(nameSubject, hourlyRate, startDate, dueDate, priority, repeatEvery, relatedTo, typeRelatedTo, 1);
        taskPage.clickSave();
        taskPage.clickCloseProffile();
        taskPage.searchTaskNewAdd(nameSubject);
        taskPage.clickEditButton(nameSubject);
        taskPage.verifyNewTask(nameSubject, hourlyRate + ".00", startDate, dueDate, priority, repeatEvery, relatedTo, typeRelatedTo, assignee, follower, tag, 0);
    }


}
