package com.wwh.test.firefox;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

/**
 * <pre>
 * 用于爬虫，想禁用掉浏览器的下载功能
 * </pre>
 * 
 * @author wwh
 * @date 2018年3月28日 下午3:09:03
 */
public class DownloadTest {

    public static String BROWSER_PATH = "D:\\Program Files\\Mozilla Firefox\\firefox.exe";

    public static String GECKODRIVER_PATH = "D:\\Program Files\\Mozilla Firefox\\geckodriver.exe";

    public static List<String> URLs = new ArrayList<>();

    public static String URL = "http://192.168.1.166/xxx.abc";

    // public static String URL = "http://mirror.bit.edu.cn/apache//commons/logging/binaries/commons-logging-1.2-bin.zip";

    // public static String URL = "http://seopic.699pic.com/photo/2016/12/19/efe5c976-b1a3-4286-b20a-a8ed0c34f356.jpg_wh1200.jpg";

    static {
        URLs.add(URL);
    }

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.firefox.bin", BROWSER_PATH);

        System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);

        GeckoDriverService geckoDriverService = GeckoDriverService.createDefaultService();

        geckoDriverService.start();

        System.out.println(geckoDriverService.getUrl());
        System.out.println("服务启动，按回车继续");

        byte[] bb = new byte[100];

        System.in.read(bb);

        try {

            FirefoxOptions options = new FirefoxOptions();

            // options.addPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain, application/octet-stream");

            // options.addPreference("browser.download.folderList", 2);

            // options.addPreference("browser.download.dir", "F:\\temp");

            WebDriver driver = new FirefoxDriver(geckoDriverService, options);

            System.out.println("启动浏览器，按回车继续");

            System.in.read(bb);

            System.out.println("开始打开下载页面");

            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

            try {
                driver.get(URL);
                // driver.manage().timeouts().

                // 如果不进行其他的处理，程序会卡在这个地方
                // 因为浏览器弹出了阻塞式的文件打开窗口

                System.out.println("页面已经打开：");
                System.out.println(driver.getTitle());
            } catch (Exception e) {
                System.out.println("打开页面错误");
                e.printStackTrace();
            }

            System.out.println("按回车退出");

            System.in.read(bb);

            driver.quit();

            System.out.println("按回车关闭服务");
            System.in.read(bb);

        } finally {
            System.out.println("关闭服务");
            geckoDriverService.stop();
        }

    }
}
