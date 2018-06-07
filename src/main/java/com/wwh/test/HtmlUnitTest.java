package com.wwh.test;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Administrator
 * @date 2017/11/22 18:22.
 */


public class HtmlUnitTest {

    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("result.html");
        WebClient webClient = new WebClient(BrowserVersion.CHROME);

        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setTimeout(10000);

        ProxyConfig proxyConfig = webClient.getOptions().getProxyConfig();
        proxyConfig.setProxyHost("192.168.1.93");
        proxyConfig.setProxyPort(8118);

//        Cookie cookie = new Cookie("http://192.168.1.92/#/main/operationLogs","JSESSIONID","04318A3E0BFA3938CEE832AD2F19F092");
//        webClient.getCookieManager().addCookie(cookie);

        HtmlPage page = webClient.getPage("http://toutiao.com/");
        webClient.waitForBackgroundJavaScript(10000);
        String html = page.asXml();
        System.out.println(html);
        writer.write(html);
        writer.flush();
        writer.close();

    }

}
