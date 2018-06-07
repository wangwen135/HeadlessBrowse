package com.wwh.test.chrome;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static void main(String[] args) throws InterruptedException {
        // 设置ChromeDriver的路径
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://www.baidu.com/");

        Thread.sleep(2000);

        // HttpResponseCode
        //driver.navigate().
        //driver.getNetworkConnection()
        //System.out.println( driver.getErrorHandler().isIncludeServerErrors());

        System.out.println(driver.getCurrentUrl());

        System.out.println(driver.getPageSource());

        List<WebElement> list = driver.findElements(By.tagName("a"));
        for (WebElement webElement : list) {
            System.out.println(webElement.getText());
            System.out.println(webElement.getAttribute("href"));
        }

        Thread.sleep(2000);

        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("alert('hello world');");
        }

        try {
            System.in.read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        driver.get("http://www.hao123.com");

        System.out.println(driver.getPageSource());

        Thread.sleep(2000);

        list = driver.findElements(By.tagName("a"));
        for (WebElement webElement : list) {
            System.out.println(webElement.getText());
            System.out.println(webElement.getAttribute("href"));
        }

        // driver.close();
        driver.quit();
    }
}
