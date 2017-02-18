package com.runfeng.test.day05;

import java.net.URL;

/**
 * Created by lenovo on 2017/2/18.
 */
public class BootstrapTest {
    public static void main(String[] args){
        /*URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls){
            System.out.println(url);
        }*/
        System.out.println(System.getProperty("java.ext.dirs"));
    }
}
