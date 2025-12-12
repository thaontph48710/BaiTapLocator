package common;

import com.thaotest.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CustomerPage;
import pages.DashboardPage;
import pages.LeadsPage;
import pages.TaskPage;

public class BasePage {
        private WebDriver driver;

        public BasePage(WebDriver driver) {
                this.driver = driver;
        }

        public By menuDashboard = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Dashboard' and @class='menu-text']");
        public By menuLeads = By.xpath("//span[@class='menu-text' and normalize-space()='Leads']");
        public By menuTasks = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Tasks' and @class='menu-text']");
        public By menuCustomers = By.xpath("//aside[@id='menu']//li[normalize-space() = 'Customers']");

        public DashboardPage clickMenuDashboard() {
                WebUI.clickElement(  menuDashboard);
                return new DashboardPage(driver);
        }

        public LeadsPage clickMenuLead() {
                WebUI.clickElement(  menuLeads);
                return new LeadsPage(driver);
        }

        public TaskPage clickMenuTask() {
                WebUI.clickElement(  menuTasks);
                return new TaskPage(driver);
        }
        public CustomerPage clickMenuCustomer() {
                WebUI.clickElement(  menuCustomers);
                return new CustomerPage(driver);
        }
}
