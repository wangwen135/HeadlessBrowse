package com.wwh.test.chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestControl {

    public static void main(String[] args) throws InterruptedException {

        // 如果不设置将搜索环境变量
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com/");

        Thread.sleep(3000);

        WebElement searchBox = driver.findElement(By.id("kw"));

        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();

        Thread.sleep(3000);
        driver.quit();

    }
}
