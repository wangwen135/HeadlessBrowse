package com.wwh.test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Administrator
 * @date 2017/11/25 11:33.
 */
public class SeleniumTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
        WebDriver driver=new FirefoxDriver();
        driver.get("http://www.baidu.com/");
        driver.manage().window().maximize();
        WebElement txtbox = driver.findElement(By.name("wd"));
        txtbox.sendKeys("Glen");
        WebElement btn = driver.findElement(By.id("su"));
        btn.click();
        driver.close();

    }

}
