package common;

import com.thaotest.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LeadsPage;
import pages.TaskPage;

public class BasePage {
        private WebDriver driver;

        public BasePage(WebDriver driver) {
                this.driver = driver;
        }

        public By menuDashboard = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Dashboard' and @class='menu-text']");
        public By menuLead = By.xpath("//ul[@id='side-menu']//span[normalize-space()='LeadsTest' and @class='menu-text']");
        public By menuTasks = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Tasks' and @class='menu-text']");

        public DashboardPage clickMenuDashboard() {
                WebUI.clickElement(driver, menuDashboard);
                return new DashboardPage(driver);
        }

        public LeadsPage clickMenuLead() {
                WebUI.clickElement(driver, menuLead);
                return new LeadsPage(driver);
        }

        public TaskPage clickMenuTask() {
                WebUI.clickElement(driver, menuTasks);
                return new TaskPage(driver);
        }
}
