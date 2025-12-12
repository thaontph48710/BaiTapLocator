package com.thaotest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {
    private static  WebDriver driver;

    public WebUI( WebDriver driver) {
        WebUI.driver = driver;
    }
    public static boolean checkExistsElement( By by) {

        List<WebElement> element = getWebElements( by);
        if (element.size() > 0) {
            System.out.println("Phần tử tồn tại: " + by);
            return true;
        } else {
            System.out.println("Phần tử không tồn tại: " + by);
            return false;
        }
    }

    //Hàm kiểm tra hiển  với WebDriverWait - tương ứng driver.findElement(By).isDisplayed()
//    public static boolean checkElementDisplay(By by, int timeoutSeconds) {
//        try {
//            WebElement element = waitForElementVisible(by, timeoutSeconds);
//            highlightElement(element);
//            System.out.println("Element found: " + by.toString() + " within " + timeoutSeconds + " seconds.");
//            return true;
//        } catch (TimeoutException e) {
//            System.out.println("Element not found: " + by.toString() + " within " + timeoutSeconds + " seconds.");
//            return false;
//        }
//    }

    public static void waitForElementVisible(By by){
        WebDriverWait wait = new WebDriverWait(  driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementVisible(By by, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(timeoutInSeconds), Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementToBeClickAble(By by){
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToBeClickAble(   By by, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(timeoutInSeconds), Duration.ofMillis(500));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static List<WebElement> getWebElements(  By by){
        return  driver.findElements(by);
    }

    public static WebElement getWebElement(By by){
        return  driver.findElement(by);

    }
    public  static void openUrl(   String url){
        driver.get(url);
        System.out.println("Open URL: " + url);

    }

    public static String getCurrentURL( WebDriver driver) {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        return currentUrl;
    }
    public static void setTextElement(   By by, String text){
        WebUI.waitForElementVisible(  by);
      getWebElement( by).sendKeys(text);
    }
    public static void clickElement(By by){
       waitForElementToBeClickAble(by);
        getWebElement(by).click();
    }
    private static int WAIT_TIMEOUT = 7;

    public static String getText(   By by){
        waitForElementVisible(  by);
        return getWebElement( by).getText();
    }
    public static String getElementAttribute(   By by, String attribute){
        waitForElementVisible(  by);
        WebElement element = getWebElement(  by);
        String textAttribute = element.getAttribute(attribute);
        return textAttribute;

    }


    public static void switchToFrame(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
        } catch (Throwable error) {
            System.out.println("Timeout waiting for Switch To Frame. " + by.toString());
            Assert.fail("Timeout waiting for Switch To Frame. " + by.toString());
        }
    }

    public static void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public static void switchToDefaultContentFrame() {
        driver.switchTo().defaultContent();
    }



    public static void scrollAtTop(   By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(  by));

    }
    public static void scrollAtBottom(   By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", getWebElement( by));

    }



    public static void clearElementText(   By by){
        waitForElementVisible(by);
        getWebElement(by).clear();
        System.out.println("Clear text element: " + by.toString());

    }
    public static boolean checkSeletedElement(   By by) {
        waitForElementToBeClickAble(  by);
        WebElement element = getWebElement(  by);
        if (element.isSelected()) {
            System.out.println("Phần tử đã tích chọn: true " + by);
            return true;
        } else {
            System.out.println("Phần tử không tích chọn: false " + by);
            return false;
        }
    }




}
