package testcase;

import common.BaseTest;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.DashboardPage;
import pages.LoginPage;

public class CustomerTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CustomerPage customerPage;

    String customerNameTest = "w";

    @Test
    public void testDeleteALL() throws InterruptedException {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        customerPage = dashboardPage.clickMenuCustomer();

        for (int i = 1; i <= 100; i++) {
            customerPage.searchCustomerByName(customerNameTest);
            customerPage.clickbuttonDelete(customerNameTest);
        }


    }
}
