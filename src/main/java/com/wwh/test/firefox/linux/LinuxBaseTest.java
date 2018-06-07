package com.wwh.test.firefox.linux;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LinuxBaseTest {

    public static String BROWSER_PATH = "/data/softwares/firefox/firefox";

    public static String GECKODRIVER_PATH = "/data/softwares/firefoxDriver/geckodriver";

    public static void main(String[] args) throws InterruptedException, IOException {

        if (args.length >= 2) {

            System.setProperty("webdriver.firefox.bin", args[0]);

            System.setProperty("webdriver.gecko.driver", args[1]);

        }

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
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

        try {
            driver.get("http://www.baidu.com");
            String source = driver.getPageSource();
            System.out.println(source);

            Thread.sleep(2000);

            driver.get("http://pic1.win4000.com/wallpaper/8/58523e1737494.jpg");
            source = driver.getPageSource();
            System.out.println(source);

        } catch (Exception e) {
            System.out.println(e.getClass());
            e.printStackTrace();
        }

        driver.quit();
    }
}
