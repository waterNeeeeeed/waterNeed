package com.runfeng.test.day05;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by lenovo on 2017/2/18.
 */
public class ClassLoaderPropTest {
    public static void main(String[] args) throws IOException {
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemLoader);
        Enumeration<URL> urlEnumeration = systemLoader.getResources("");
        while (urlEnumeration.hasMoreElements()){
            System.out.println(urlEnumeration.nextElement());
        }
        ClassLoader extentionLoader = systemLoader.getParent();
        System.out.println(extentionLoader);
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(extentionLoader.getParent());
    }
}
