package com.wwh.test.firefox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest2 {

    public static String BROWSER_PATH = "D:\\Program Files\\Mozilla Firefox\\firefox.exe";

    public static String GECKODRIVER_PATH = "D:\\Program Files\\Mozilla Firefox\\geckodriver.exe";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.firefox.bin", BROWSER_PATH);

        System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);

        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.baidu.com");

        Thread.sleep(1000);
        
        WebElement searchBox = driver.findElement(By.id("kw"));

        searchBox.sendKeys("geckodriver");
        
        searchBox.submit();
        
        Thread.sleep(10000);

        driver.quit();
    }
}
