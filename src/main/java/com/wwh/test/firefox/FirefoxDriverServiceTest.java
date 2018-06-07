package com.wwh.test.firefox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

public class FirefoxDriverServiceTest {

    public static String BROWSER_PATH = "D:\\Program Files\\Mozilla Firefox\\firefox.exe";

    public static String GECKODRIVER_PATH = "D:\\Program Files\\Mozilla Firefox\\geckodriver.exe";

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.firefox.bin", BROWSER_PATH);

        System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);

        GeckoDriverService geckoDriverService = GeckoDriverService.createDefaultService();

        geckoDriverService.start();
        System.out.println("服务启动，按回车继续");

        System.in.read();

        FirefoxOptions options = new FirefoxOptions();

        
        
        FirefoxDriver driver = new FirefoxDriver(geckoDriverService);
        driver.get("http://www.baidu.com");

        System.out.println("打开第一个浏览器窗口");

        System.out.println(driver.getTitle());

        Thread.sleep(1000);
        FirefoxDriver driver2 = new FirefoxDriver(geckoDriverService);
        driver2.get("http://www.163.com");

        System.out.println("打开第二个浏览器窗口，按回车继续");

        System.in.read();

        System.out.println("在第一个窗口中进行操作");
        WebElement searchBox = driver.findElement(By.id("kw"));

        searchBox.sendKeys("geckodriver");

        searchBox.submit();

        System.out.println("输入任意字符关闭第一个窗口");
        System.in.read();
        driver.quit();

        System.out.println("输入任意字符关闭第二个窗口");
        System.in.read();
        driver2.quit();

        System.out.println("输入任意字符关闭服务");
        System.in.read();
        geckoDriverService.stop();
    }
}
