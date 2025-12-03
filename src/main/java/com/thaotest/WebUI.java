package com.thaotest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebUI {
    public static boolean checkExistsElement(WebDriver driver,By by) {
        List<WebElement> element = getWebElements(driver, by);
        if (element.size() > 0) {
            System.out.println("Phần tử tồn tại: " + by);
            return true;
        } else {
            System.out.println("Phần tử không tồn tại: " + by);
            return false;
        }
    }

    public static void waitForElementVisible(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementVisible(WebDriver driver, By by, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds), Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementToBeClickAble(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToBeClickAble(WebDriver driver, By by, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds), Duration.ofMillis(500));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static List<WebElement> getWebElements(WebDriver driver, By by){
        return  driver.findElements(by);
    }

    public static WebElement getWebElement(WebDriver driver, By by){
        return  driver.findElement(by);

    }
    public  static void openUrl(WebDriver driver, String url){
        driver.get(url);
        System.out.println("Open URL: " + url);

    }

    public static String getCurrentURL(WebDriver driver) {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        return currentUrl;
    }
    public static void setTextElement(WebDriver driver, By by, String text){
        WebUI.waitForElementVisible(driver, by);
      getWebElement(driver,by).sendKeys(text);
    }
    public static void clickElement(WebDriver driver, By by){
       waitForElementToBeClickAble(driver, by);
        getWebElement(driver,by).click();
    }

    public static String getText(WebDriver driver, By by){
        waitForElementVisible(driver, by);
        return getWebElement(driver,by).getText();
    }


    public static String getElementAttribute(WebDriver driver, By by, String attribute){
        waitForElementVisible(driver, by);
        WebElement element = getWebElement(driver, by);
        String textAttribute = element.getAttribute(attribute);
        return textAttribute;

    }

    public static void scrollAtTop(WebDriver driver, By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, by));

    }
    public static void scrollAtBottom(WebDriver driver, By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver,by));

    }



    public static void clearElementText(WebDriver driver, By by){
        waitForElementVisible(driver, by);
        getWebElement(driver,by).clear();
        System.out.println("Clear text element: " + by.toString());

    }
    public static boolean checkSeletedElement(WebDriver driver, By by) {
        waitForElementToBeClickAble(driver, by);
        WebElement element = getWebElement(driver, by);
        if (element.isSelected()) {
            System.out.println("Phần tử đã tích chọn: true " + by);
            return true;
        } else {
            System.out.println("Phần tử không tích chọn: false " + by);
            return false;
        }
    }




}
