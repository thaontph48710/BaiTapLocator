package pages;

import com.keywors.WebUI;
import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CustomerPage extends BasePage {



    private By inputSearchCustomer = By.xpath("//div[@class='input-group']//input[@type = 'search']");
    private By table = By.xpath("//table[@id='clients']");

    private By firstRowCustomers = By.xpath("//table[@id='clients']//tbody/tr[1]/td[3]");
//    private By getFirstRowItemCustomerName(String customerName) {
//        By xpath = By.xpath("//table[@id='clients']//a[contains(normalize-space(), '" + customerName + "')]");
//        return xpath;
//    }


    public void searchCustomerByName(String customerName) throws InterruptedException {
        WebUI.setTextElement(inputSearchCustomer, customerName);

    }

    public List<WebElement> getAllRowsCustomerName() {
        return WebUI.getWebElements(table);
    } //  co trong ham chung

    private By buttonDelete(String customerName) {
        By buttonDelete = By.xpath("//td[./a[contains(normalize-space(),'" + customerName + "')]]//a[normalize-space()='Delete']");
        return buttonDelete;
    }

    public void clickbuttonDelete(String customerName) throws InterruptedException {
//        Actions action = new Actions(driver);
//        action.moveToElement(WebUI.getWebElement(firstRowCustomers)).perform();// co trong ham chung
        WebUI.moveToElement(firstRowCustomers);
        WebUI.clickElement(buttonDelete(customerName));
        WebUI.alerAccept();

    }


}
