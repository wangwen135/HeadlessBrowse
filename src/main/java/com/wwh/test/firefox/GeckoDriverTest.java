package com.wwh.test.firefox;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

public class GeckoDriverTest {

    public static String BROWSER_PATH = "D:\\Program Files\\Mozilla Firefox\\firefox.exe";

    public static String GECKODRIVER_PATH = "D:\\Program Files\\Mozilla Firefox\\geckodriver.exe";

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.firefox.bin", BROWSER_PATH);

        System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);

        GeckoDriverService geckoDriverService = GeckoDriverService.createDefaultService();

        geckoDriverService.start();

        System.out.println("服务启动，按回车继续");
        System.out.println(geckoDriverService.getUrl());

        byte[] bb = new byte[100];

        System.in.read(bb);

        try {

            FirefoxOptions options = new FirefoxOptions();

            WebDriver driver = new FirefoxDriver(geckoDriverService, options);
            System.out.println("启动浏览器，按回车继续");

            System.out.println("开始打开页面1");
            try {
                driver.get("http://www.baidu.com");

                System.out.println("页面已经打开：");
                System.out.println(driver.getTitle());
            } catch (Exception e) {
                System.out.println("打开页面错误");
                e.printStackTrace();
            }

            System.out.println("准备关闭这个浏览器");
            System.in.read(bb);
            driver.quit();

            System.out.println("重新打开新的浏览器");
            WebDriver driver2 = new FirefoxDriver(geckoDriverService, options);

            System.out.println("开始打开页面2");
            try {
                driver2.get("https://www.baidu.com");

                System.out.println("页面2已经打开：");
                System.out.println(driver.getTitle());
            } catch (Exception e) {
                System.out.println("打开页面2错误");
                e.printStackTrace();
            }


            System.out.println("按回车退出");

            System.in.read(bb);

            driver2.quit();

            System.out.println("按回车关闭服务");
            System.in.read();

        } finally {
            System.out.println("关闭服务");
            geckoDriverService.stop();
        }
    }

}
