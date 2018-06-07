package com.wwh.test;
import java.io.*;

/**
 * @author Administrator
 * @date 2017/11/25 17:33.
 */
public class PhantomJSTest {

    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("PhantomJSResult.html");
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("D:/phantomjs.exe D:/code.js " + "http://huaban.com/favorite/home/");
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sbf = new StringBuffer();
        String tmp = "";
        while ((tmp = br.readLine()) != null) {

            sbf.append(tmp).append("\n");

        }

        System.out.println(sbf.toString());
        writer.write(sbf.toString());
        writer.flush();
        writer.close();

    }

}
