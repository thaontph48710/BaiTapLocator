package testcase;

import com.helpers.ExcelHelper;
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
    @Test
    public void tesGetExcel() throws InterruptedException {
        ExcelHelper excelHelper = new ExcelHelper();
        String filePath = "src/test/resources/testdata/DataLogin.xlsx";
        excelHelper.setExcelFile(filePath, "Login");
        String email = excelHelper.getCellData("EMAIL", 2);
        String password = excelHelper.getCellData("PASSWORD", 2);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

    }

    @Test
    public void tesGetExcel_Lead() throws InterruptedException {
        ExcelHelper excelHelper = new ExcelHelper();
        String filePath = "src/test/resources/testdata/DataLogin.xlsx";
        excelHelper.setExcelFile(filePath, "Leads");
        String leadsNameExcel = excelHelper.getCellData("LEADS_NAME", 1);
        String nam = excelHelper.getCellData("NAM", 1);
        System.out.println("LEADS_NAME: " + leadsNameExcel);
        System.out.println("NAM: " + nam);

    }

    @Test
    public void tesSetExcel() throws InterruptedException {
        ExcelHelper excelHelper = new ExcelHelper();
        String filePath = "src/test/resources/testdata/DataLogin.xlsx";
        excelHelper.setExcelFile(filePath, "Login");
        excelHelper.setCellData("Pass", "RESULT",1 );
    }
}
