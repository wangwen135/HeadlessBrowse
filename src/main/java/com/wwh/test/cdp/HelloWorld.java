package com.wwh.test.cdp;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import io.webfolder.cdp.Launcher;
import io.webfolder.cdp.session.Session;
import io.webfolder.cdp.session.SessionFactory;

public class HelloWorld {
    public static void main(String[] args) {

        // Path path = new Path
        // asList("--disable-gpu", "--headless")
        Launcher launcher = new Launcher();

        try (SessionFactory factory = launcher.launch(asList("--headless", "--disable-gpu")); Session session = factory.create()) {

            session.navigate("https://webfolder.io");
            session.waitDocumentReady();
            String content = (String) session.getProperty("//body", "outerText");
            System.out.println(content);

        }
    }
}