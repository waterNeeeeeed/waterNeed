package com.runfeng.test;

import java.io.IOError;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
