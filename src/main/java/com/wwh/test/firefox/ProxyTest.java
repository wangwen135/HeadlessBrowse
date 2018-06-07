package com.wwh.test.firefox;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * <pre>
 * 用于测试代理功能
 * </pre>
 * 
 */
public class ProxyTest {

    public static String BROWSER_PATH = "D:\\Program Files\\Mozilla Firefox\\firefox.exe";

    public static String GECKODRIVER_PATH = "D:\\Program Files\\Mozilla Firefox\\geckodriver.exe";

    public static void main(String[] args) throws InterruptedException, Exception {

        System.setProperty("webdriver.firefox.bin", BROWSER_PATH);

        System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);

        FirefoxOptions options = new FirefoxOptions();

        Proxy proxy = new Proxy();

        proxy.setSocksProxy("23.236.77.156:9150");

        // 23.236.77.156:9150
        // proxy.setSocksVersion(5);

        // proxy.setHttpProxy("192.168.1.93:8118");

        // options.setProxy(proxy);
        options.addPreference("network.proxy.type", 1);
        options.addPreference("network.proxy.socks", "23.236.77.156");
        options.addPreference("network.proxy.socks_port", 9150);
        // 使用socks5 代理DNS network.proxy.socks_remote_dns = true
        options.addPreference("network.proxy.socks_remote_dns", true);

        WebDriver driver = new FirefoxDriver(options);
        System.out.println("启动浏览器，输入任意内容继续");

        System.in.read();

        // 这个就不支持设置超时时间了？

        System.out.println("开始打开页面");
        try {
            driver.get("https://check.torproject.org/?lang=zh_CN");
            System.out.println(driver.getTitle());
        } catch (Exception e) {
            System.out.println("打开页面错误");
            e.printStackTrace();
        }

        System.in.read();

        System.out.println("开始打开页面");
        try {
            driver.get("http://4zkgktc6hjdmp6kw.onion");
        } catch (Exception e) {
            System.out.println("打开页面错误");
            e.printStackTrace();
        }

        System.in.read();

        // driver.get("http://ninw54rm6dg5f36s.onion/");

        System.out.println("开始打开页面");
        try {
            driver.get("http://www.google.com");
        } catch (Exception e) {
            System.out.println("打开页面错误");
            e.printStackTrace();
        }
        System.out.println("输入任何内容退出");

        System.in.read();

        driver.quit();
    }
}
