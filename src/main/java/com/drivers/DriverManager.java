package com.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {

        private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

        private DriverManager() {
        }

        public static WebDriver getDriver() {
            return driver.get(); // Lay data tu ThreadLocal
        }

        public static void setDriver(WebDriver driver) {
            DriverManager.driver.set(driver); // Gan data cho ThreadLocal
        }

        public static void quit() {
            DriverManager.driver.get().quit(); // Dong trinh duyet
            driver.remove(); // Xoa data khoi ThreadLocal

        }


}
