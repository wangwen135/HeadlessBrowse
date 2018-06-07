package com.wwh.test.chrome;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestRemoteWebDriver {

    /**
     * <pre>
     * 第一步先启动ChromeDriver服务
     * 控制台执行：
     * $ ./chromedriver
     * 
     * Starting ChromeDriver 2.37.543627 (63642262d9fb93fb4ab52398be4286d844092a5e) on port 9515
     * Only local connections are allowed.
     * </pre>
     * 
     * @throws MalformedURLException
     * @throws InterruptedException
     *
     */

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), DesiredCapabilities.chrome());
        
        WebDriver driver2 = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), DesiredCapabilities.chrome());
        
        WebDriver driver3 = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), DesiredCapabilities.chrome());

        driver.get("http://www.baidu.com");

        Thread.sleep(2000);
        
        for (int i = 0; i < 100; i++) {
            driver.get("http://www.baidu.com");

            Thread.sleep(2000);
            driver.get("http://www.hao123.com");

            Thread.sleep(2000);
        }
        // driver.quit();

        // driver.close();
    }
}
