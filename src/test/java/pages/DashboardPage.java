package pages;

import com.thaotest.WebUI;
import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends BasePage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    private By buttonDashboardOptions = By.xpath("//div[normalize-space()='Dashboard Options']");

    private By labelTotalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");

    public String getTotalConvertedLeads() {
        return WebUI.getText(labelTotalConvertedLeads).trim();
    }

    public void verifyDashboardPageDisplayed() {
        Assert.assertTrue(WebUI.checkExistsElement(buttonDashboardOptions), "Dashboard page is not displayed.");
    }


}
