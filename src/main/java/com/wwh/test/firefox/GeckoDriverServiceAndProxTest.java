package com.wwh.test.firefox;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

public class GeckoDriverServiceAndProxTest {

    public static String BROWSER_PATH = "D:\\Program Files\\Mozilla Firefox\\firefox.exe";

    public static String GECKODRIVER_PATH = "D:\\Program Files\\Mozilla Firefox\\geckodriver.exe";

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.firefox.bin", BROWSER_PATH);

        System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);

        GeckoDriverService geckoDriverService = GeckoDriverService.createDefaultService();

        geckoDriverService.start();

        System.out.println("服务启动，按回车继续");
        System.out.println(geckoDriverService.getUrl());

        System.in.read();

        try {

            FirefoxOptions options = new FirefoxOptions();

            // 设置代理
            Proxy proxy = new Proxy();

            proxy.setSocksProxy("23.236.77.156:9150");
            // 23.236.77.156:9150
            // proxy.setSocksVersion(5);

            // proxy.setHttpProxy("192.168.1.93:8118");

            // options.setProxy(proxy);

            /**
             * network.proxy.type = 1 network.proxy.socks = 23.236.77.156 network.proxy.socks_port = 9150
             */

            options.addPreference("network.proxy.type", 1);
            options.addPreference("network.proxy.socks", "23.236.77.156");
            options.addPreference("network.proxy.socks_port", 9150);
            // 使用socks5 代理DNS network.proxy.socks_remote_dns = true
            options.addPreference("network.proxy.socks_remote_dns", true);

            WebDriver driver = new FirefoxDriver(geckoDriverService, options);
            System.out.println("启动浏览器，按回车继续");

            System.in.read();

            // 这个就不支持设置超时时间了？

            System.out.println("开始打开页面1");
            try {
                driver.get("http://4zkgktc6hjdmp6kw.onion");

                System.out.println("页面已经打开：");
                System.out.println(driver.getTitle());
            } catch (Exception e) {
                System.out.println("打开页面错误");
                e.printStackTrace();
            }

            System.in.read();

            System.out.println("开始打开页面2");
            try {
                driver.get("https://check.torproject.org/?lang=zh_CN");

                System.out.println("页面已经打开：");
                System.out.println(driver.getTitle());
            } catch (Exception e) {
                System.out.println("打开页面错误");
                e.printStackTrace();
            }

            System.in.read();

            // driver.get("http://ninw54rm6dg5f36s.onion/");

            System.out.println("开始打开页面3");
            try {
                driver.get("http://www.google.com");

                System.out.println("页面已经打开：");
                System.out.println(driver.getTitle());
            } catch (Exception e) {
                System.out.println("打开页面错误");
                e.printStackTrace();
            }
            System.out.println("按回车退出");

            System.in.read();

            driver.quit();

            System.out.println("按回车关闭服务");
            System.in.read();

        } finally {
            System.out.println("关闭服务");
            geckoDriverService.stop();
        }
    }

}
