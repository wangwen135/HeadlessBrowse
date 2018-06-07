package com.wwh.test.chrome;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest2 {

    public static void main(String[] args) throws InterruptedException {
        // 设置ChromeDriver的路径
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        // options.addArguments("start-maximized");

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("192.168.1.93:8118");

        options.setProxy(proxy);

        ChromeDriver driver = new ChromeDriver(options);

        // driver.get("https://check.torproject.org/?lang=zh_CN");
        // driver.get("http://4zkgktc6hjdmp6kw.onion");
        // driver.get("http://ninw54rm6dg5f36s.onion/");
        driver.get("http://www.google.com");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(driver.getCurrentUrl());

        // driver.close();
        driver.quit();
        driver.quit();
        driver.quit();
    }
}
