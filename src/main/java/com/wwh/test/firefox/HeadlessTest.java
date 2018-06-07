package com.wwh.test.firefox;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessTest {

    public static String BROWSER_PATH = "D:\\Program Files\\Mozilla Firefox\\firefox.exe";

    public static String GECKODRIVER_PATH = "D:\\Program Files\\Mozilla Firefox\\geckodriver.exe";

    public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.firefox.bin", BROWSER_PATH);

        System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);

        // ===================================

        FirefoxOptions options = new FirefoxOptions();
        // 禁止弹出式窗口
        // dom.disable_open_during_load = true
        options.addPreference("dom.disable_open_during_load", true);

        // 设置user-agent信息
        options.addPreference("general.useragent.override",
                "Mozilla/5.0 (Windows NT 6.1; rv:45.0) Gecko/20100101 Firefox/45.0");

        // 配置代理
        options.addPreference("network.proxy.type", 0);

        // socks代理
        options.addPreference("network.proxy.socks", "127.0.0.1");
        options.addPreference("network.proxy.socks_port", 0);
        options.addPreference("network.proxy.socks_remote_dns", true);
        options.addPreference("network.proxy.socks_version", 5);
        // http代理
        options.addPreference("network.proxy.http", "127.0.0.1");
        options.addPreference("network.proxy.http_port", 0);

        options.addArguments("-headless");

        WebDriver driver = new FirefoxDriver(options);

        // 设置超时时间
        driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);

        try {
            driver.get("http://www.baidu.com");

            System.out.println(driver.getPageSource());

            System.out.println(driver.getTitle());

            System.out.println("#########____________________############__________###########");

            driver.get("http://www.hao123.com");

            System.out.println(driver.getPageSource());

            System.out.println(driver.getTitle());

        } catch (Exception e) {
            System.out.println(e.getClass());
            e.printStackTrace();
        }

        System.in.read();

        driver.quit();
    }
}
