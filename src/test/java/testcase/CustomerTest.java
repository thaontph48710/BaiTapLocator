package testcase;

import com.thaotest.WebUI;
import common.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.DashboardPage;
import pages.LoginPage;

import javax.lang.model.element.Element;

public class CustomerTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CustomerPage customerPage;

    String customerNameTest = "w";

    @Test
    public void testDeleteALL() throws InterruptedException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        customerPage = dashboardPage.clickMenuCustomer();

        for (int i = 1; i <= 100; i++) {
            customerPage.searchCustomerByName(customerNameTest);
            customerPage.clickbuttonDelete(customerNameTest);
        }


    }
}
