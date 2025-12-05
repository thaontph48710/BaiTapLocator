package testcase;

import com.thaotest.WebUI;
import common.BasePage;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LeadsPage;
import pages.LoginPage;
import pages.TaskPage;

public class DashboardTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadsPage leadPage;
    private TaskPage taskPage;

    @Test
    public void testConvertedLeads() throws InterruptedException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyDashboardPageDisplayed();

        String totalCustomerLeadOnDashboard = dashboardPage.getTotalConvertedLeads();

        leadPage = dashboardPage.clickMenuLead();

        leadPage.clickButtonLeadsSummary();

        Assert.assertEquals(totalCustomerLeadOnDashboard, leadPage.getTotalStatusCustomer() + " / " + leadPage.getTotalStatusLeads(),
                "Sai gia tri cua Converted Leads tren Dashboard va trong Leads Summary");
    }
}
