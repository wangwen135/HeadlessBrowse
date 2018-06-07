package com.wwh.test.firefox;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * <pre>
 * 测试cookie
 * </pre>
 * 
 * @author wwh
 * @date 2018年3月27日 下午4:30:20
 */
public class CookieTest {

    public static String BROWSER_PATH = "D:\\Program Files\\Mozilla Firefox\\firefox.exe";

    public static String GECKODRIVER_PATH = "D:\\Program Files\\Mozilla Firefox\\geckodriver.exe";

    public static void main(String[] args) throws InterruptedException, Exception {

        System.setProperty("webdriver.firefox.bin", BROWSER_PATH);

        System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);

        WebDriver driver = null;
        try {
            FirefoxOptions options = new FirefoxOptions();

            // 禁止弹出式窗口
            // dom.disable_open_during_load = true
            options.addPreference("dom.disable_open_during_load", true);

            // 设置user-agent信息 general.useragent.override

            // 火狐的user-agent信息是：
            // Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0

            // 设置成chrome的user-agent信息
            options.addPreference("general.useragent.override",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

            driver = new FirefoxDriver(options);

            System.out.println("启动浏览器，输入任意内容继续");

            byte[] bb = new byte[100];

            System.in.read(bb);

            // ttttt
            // driver.manage().addCookie(new Cookie("JSESSIONID", "wwwwwww", "192.168.1.92", "/", null));

            System.out.println("开始打开页面");
            try {
                driver.get("http://192.168.1.92");
                System.out.println(driver.getTitle());
            } catch (Exception e) {
                System.out.println("打开页面错误");
                e.printStackTrace();
            }

            Set<Cookie> ckSet = driver.manage().getCookies();

            System.out.println("当前的cookie信息");
            System.out.println(ckSet);

            System.out.println("下一步设置cookie信息");
            System.in.read(bb);

            // 设置cookie
            Cookie ck = new Cookie("JSESSIONID", "2C82696C98093C436C4DD3A7E21C2235");
            driver.manage().addCookie(ck);

            System.out.println("再打开");
            System.in.read(bb);

            try {
                driver.get("http://192.168.1.92/#/main/userCtrl");
            } catch (Exception e) {
                System.out.println("打开页面错误");
                e.printStackTrace();
            }

            System.out.println("再次打开上一个网站  <--");
            System.in.read(bb);

            try {
                // driver.get("http://www.baidu.com");
                driver.get("http://news.163.com/");
            } catch (Exception e) {
                System.out.println("打开页面错误");
                e.printStackTrace();
            }

            System.out.println("输入任何内容退出");

            System.in.read(bb);

        } finally {
            if (driver != null)
                driver.quit();
            System.out.println("结束");
        }

    }

}
