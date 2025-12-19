package testcase;

import com.keywors.WebUI;
import common.BaseTest;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LeadsPage;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TaskPage;

import java.text.SimpleDateFormat;
import java.util.Date;


public class LeadsTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadsPage leadsPage;
    private TaskPage taskPage;



    String leadsNameTest = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
    String dropdownStatus = "Customer";
    String dropdownSource = "Facebook";
    String dropdownAssigned = "Admin Anh Tester";
    String dropdownTag = "Selenium";
    String address = "Hà Nội";
    String position = "Tester";
    String city = "Việt Nam";
    String emailAddress = "thao" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
    String state = "hangocthao";
    String website = "thao.com.vn";
    String country = "Vietnam";
    String phone = "0966674456";
    String zipCode = "123456";
    String leadValue = "123456";
    String language = "Vietnamese";
    String company = "NDJSC";
    String description = "Them moi leads cho CRM";
    String lastContacted = "10-11-2025";

    @Test(priority = 1)
    public void testAndLeadsCheckNewLead() throws InterruptedException {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();

        leadsPage.clickButtonNewLeads();
        leadsNameTest = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        emailAddress = "thao" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
        leadsPage.fillDate(dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, leadsNameTest, address, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 1, 0);

        leadsPage.clickCloseProfile();
        leadsPage.searchLeads(leadsNameTest);
        leadsPage.verifyNewLeadsFirstRowItemLeadName(leadsNameTest);
        leadsPage.clickEditButton(leadsNameTest);

        leadsPage.verifyNewLeadInEdit(dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, leadsNameTest, address, position,
                city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 1);
    }


    @Test(priority = 2)
    public void testEditLeads() throws InterruptedException {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();


        leadsPage.clickButtonNewLeads();
        leadsNameTest = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        emailAddress = "thao" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
        leadsPage.fillDate(dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, leadsNameTest, address, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 1, 0);
        leadsPage.clickCloseProfile();
        leadsPage.searchLeads(leadsNameTest);
        leadsPage.verifyNewLeadsFirstRowItemLeadName(leadsNameTest);

        String nameLead = leadsNameTest + "_Edit";
        dropdownStatus = "Active";
        dropdownSource = "Google";
        dropdownAssigned = "Admin Anh Tester";
        dropdownTag = "JSC_NEW";
        address = "Lạng Sơn";
        position = "Tester";
        city = "NODO Việt Nam";
        emailAddress = "ngocthao" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
        state = "hangocthao080604";
        website = "thao123.com.vn";
        country = "Vietnam";
        phone = "0966674789";
        zipCode = "123456789";
        leadValue = "1234566789";
        language = "Vietnamese";
        company = "NDJSC";
        description = "Edit leads cho CRM";
        lastContacted = "20-11-2025";

        leadsPage.clickEditButton(leadsNameTest);
        leadsPage.fillDate(dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, nameLead, address, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 0, 1);
        leadsPage.clickCloseProfile();
        leadsPage.searchLeads(nameLead);
        leadsPage.verifyNewLeadsFirstRowItemLeadName(nameLead);
        leadsPage.clickEditButton(nameLead);
        leadsPage.verifyNewLeadInEdit(dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, nameLead, address, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 1);

    }

    @Test(priority = 3)
    public void testDeleteLeads() throws InterruptedException {


        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();

        ;
        leadsPage.clickButtonNewLeads();
        leadsNameTest = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        emailAddress = "thao" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";

        leadsPage.fillDate(dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, leadsNameTest, address, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 1, 0);
        leadsPage.clickCloseProfile();
        leadsPage.searchLeads(leadsNameTest);
        leadsPage.verifyNewLeadsFirstRowItemLeadName(leadsNameTest);

        leadsPage.clickbuttonDelete(leadsNameTest);
        leadsPage.searchLeads(leadsNameTest);
        leadsPage.verifyAfterDeleteLead(leadsNameTest);


    }


    @Test(priority = 4)
    public void testSoSanhActiveTruocVaSauKhiThemMoi() throws InterruptedException {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();

        leadsPage.clickButtonLeadsSummary();
        String totalActiveBefore = leadsPage.getTotalStatusActive();
        leadsPage.clickButtonNewLeads();
        leadsNameTest = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        dropdownStatus = "Active";
        emailAddress = "thao" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
        leadsPage.fillDate(dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, leadsNameTest, address, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 1, 0);

        leadsPage.clickCloseProfile();
        WebUI.refreshWeb();
        leadsPage.clickButtonLeadsSummary();
        String totalActiveAfter = leadsPage.getTotalStatusActive();
        int totalActiveBeforeInt = Integer.parseInt(totalActiveBefore);
        int totalActiveAfterInt = Integer.parseInt(totalActiveAfter);
        Assert.assertEquals(totalActiveAfterInt, totalActiveBeforeInt + 1, "So sanh so luong Active truoc va sau khi them moi Lead khong dung");
    }
    @Test(priority = 5)
    public void testAddNewLeadsEditTask() throws Exception {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();

        //Add new leads and edit leads
        leadsPage.clickButtonNewLeads();
        leadsNameTest = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        emailAddress = "thao" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
        leadsPage.fillDate(dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, leadsNameTest, address, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 1, 0);
        leadsPage.clickCloseProfile();
        leadsPage.searchLeads(leadsNameTest);
        leadsPage.verifyNewLeadsFirstRowItemLeadName(leadsNameTest);
        leadsPage.clickEditButton(leadsNameTest);

        String nameLead = leadsNameTest + "_Edit";
        dropdownStatus = "Active";
        dropdownSource = "Google";
        dropdownAssigned = "Admin Anh Tester";
        dropdownTag = "JSC_NEW";
        address = "Lạng Sơn";
        position = "Tester";
        city = "NODO Việt Nam";
        emailAddress = "ngocthao" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "@gmail.com";
        state = "hangocthao080604";
        website = "thao123.com.vn";
        country = "Vietnam";
        phone = "0966674789";
        zipCode = "123456789";
        leadValue = "1234566789";
        language = "Vietnamese";
        company = "NDJSC";
        description = "Edit leads cho CRM";
        lastContacted = "20-11-2025";

        WebUI.sleep(2);
        leadsPage.fillDate(dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, nameLead, address, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 0, 1);
        leadsPage.clickCloseProfile();
        leadsPage.searchLeads(nameLead);
        leadsPage.verifyNewLeadsFirstRowItemLeadName(nameLead);
        leadsPage.clickEditButton(nameLead);
        leadsPage.verifyNewLeadInEdit(dropdownStatus, dropdownSource, dropdownAssigned, dropdownTag, nameLead, address, position, city, emailAddress, state, website, country, phone, zipCode,
                leadValue, language, company, description, lastContacted, 1);
        leadsPage.clickCloseProfile();

        //Add new task and edit task
        TaskTest taskTest = new TaskTest();
        taskPage = leadsPage.clickMenuTask();
       taskTest.subject = "HaNgocThao" + new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        taskTest.typeRelatedTo = nameLead;
        taskPage.clickButtonNewTask();
        taskPage.addNewTask(taskTest.subject, taskTest.hourlyRate, taskTest.startDate, taskTest.dueDate, taskTest.priority, taskTest.repeatEvery, taskTest.relatedTo,
                taskTest.typeRelatedTo, taskTest.assignee, taskTest.follower, taskTest.description, taskTest.tag, 0);
        taskPage.clickSave();
        taskPage.clickCloseProffile();
        taskPage.searchTaskNewAdd(taskTest.subject);
        taskPage.clickEditButton(taskTest.subject);
        taskPage.verifyNewTask(taskTest.subject, taskTest.hourlyRate + ".00", taskTest.startDate, taskTest.dueDate,
                taskTest.priority, taskTest.repeatEvery, taskTest.relatedTo, taskTest.typeRelatedTo, taskTest.assignee, taskTest.follower, taskTest.tag, 0);
        String nameSubject = taskTest.subject + "_Edit";
        taskTest.hourlyRate = "20";
        taskTest.startDate = "20-12-2025";
        taskTest.dueDate = "25-12-2025";
        taskTest.priority = "High";
        taskTest.repeatEvery = "2 Months";
        taskTest.relatedTo = "Lead";
//      typeRelatedTo  = "Giang Test";

        taskPage.editTasks(nameSubject, taskTest.hourlyRate, taskTest.startDate, taskTest.dueDate, taskTest.priority,
                taskTest.repeatEvery, taskTest.relatedTo, taskTest.typeRelatedTo, 1);
        taskPage.clickSave();
        taskPage.clickCloseProffile();
        taskPage.searchTaskNewAdd(nameSubject);
        taskPage.clickEditButton(nameSubject);
        taskPage.verifyNewTask(nameSubject, taskTest.hourlyRate + ".00", taskTest.startDate, taskTest.dueDate,
                taskTest.priority, taskTest.repeatEvery, taskTest.relatedTo, taskTest.typeRelatedTo, taskTest.assignee, taskTest.follower, taskTest.tag, 0);


    }

}
