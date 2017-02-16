package com.runfeng.test.day01;

import java.io.IOException;

/**
 * Created by lenovo on 2017/2/10.
 */
public class test1 {

    @Testable
    public static void m1(){

    }

    @Testable
    public static void m2() throws IOException {
        throw new IOException("m2 异常");
    }

    @Testable
    public void m3(){

    }

    @Testable
    public static void m4() throws Exception {
        throw new Exception("m4 异常");
    }

}
