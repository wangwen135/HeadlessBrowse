package com.wwh.test.firefox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * <pre>
 * 测试多页面下载
 * </pre>
 * 
 * @author wwh
 */
public class DownloadMultiPage {

    public static String BROWSER_PATH = "D:\\Program Files\\Mozilla Firefox\\firefox.exe";

    public static String GECKODRIVER_PATH = "D:\\Program Files\\Mozilla Firefox\\geckodriver.exe";

    public static List<String> URLs = new ArrayList<>(100000);

    public static Set<String> distinct = new HashSet<>(100000);

    public static String URL = "http:www.baidu.com";

    // public static String URL = "http://192.168.1.166/xxx.abc";

    // public static String URL = "http://mirror.bit.edu.cn/apache//commons/logging/binaries/commons-logging-1.2-bin.zip";

    // public static String URL = "http://seopic.699pic.com/photo/2016/12/19/efe5c976-b1a3-4286-b20a-a8ed0c34f356.jpg_wh1200.jpg";

    static {
        URLs.add(URL);
    }

    /**
     * 关闭浏览器
     * 
     * @param driver
     */
    public static void closeDriver(WebDriver driver) {
        if (driver != null) {
            try {

                driver.quit();
            } catch (Exception e) {
                System.out.println("关闭浏览器异常");
                e.printStackTrace();
            }
        }
    }

    public static WebDriver createDriver() {
        FirefoxOptions options = new FirefoxOptions();

        // options.addPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain, application/octet-stream");

        // options.addPreference("browser.download.folderList", 2);

        // options.addPreference("browser.download.dir", "F:\\temp");

        // options.addArguments("-headless");

        WebDriver driver = new FirefoxDriver(options);

        System.out.println("打开了新的浏览器并设置了超时时间");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        return driver;
    }

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.firefox.bin", BROWSER_PATH);

        System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);

        WebDriver driver;

        driver = createDriver();

        while (!URLs.isEmpty()) {
            String url = URLs.remove(0);

            try {
                driver.get(url);
                System.out.println("当前页面标题");
                System.out.println(driver.getTitle());

                // 找出该页面的所有地址
                List<WebElement> list = driver.findElements(By.tagName("a"));

                // System.out.println("在该页面上发现的新地址：");

                // 如果容量到了 ，就不测试了
                if (distinct.size() > 1000000) {
                    continue;
                }

                for (WebElement webElement : list) {
                    // System.out.println(webElement.getText());
                    String href = webElement.getAttribute("href");
                    // System.out.println(href);

                    if (StringUtils.isBlank(href)) {
                        continue;
                    }

                    // 判断去重
                    if (distinct.add(href)) {
                        URLs.add(href);
                    }
                }

            } catch (Exception e) {
                System.out.println("打开页面出错");
                e.printStackTrace();
                closeDriver(driver);

                driver = createDriver();
            }
        }

    }
}
