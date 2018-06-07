package com.wwh.test.chrome;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverServiceTest {

    public static void main(String[] args) throws IOException {

        String driverPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";

        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(driverPath))
                .usingAnyFreePort().build();

        service.start();

        WebDriver driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());

        driver.get("http://www.baidu.com");

        WebDriver driver2 = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());

        driver2.get("http://www.bing.com");

        WebDriver driver3 = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());

        driver3.get("http://www.163.com");

        driver.quit();
        driver2.quit();
        driver3.quit();

        // 关闭 ChromeDriver 接口
        service.stop();
    }
}
