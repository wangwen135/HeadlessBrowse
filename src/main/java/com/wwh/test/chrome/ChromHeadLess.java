package com.wwh.test.chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromHeadLess {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        // System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        // 设置为 headless 模式 （必须）
        chromeOptions.addArguments("--headless");
        // 设置浏览器窗口打开大小 （非必须）
        chromeOptions.addArguments("--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://www.baidu.com");
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();

    }
}
