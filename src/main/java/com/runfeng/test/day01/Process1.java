package com.runfeng.test.day01;

import java.lang.reflect.Method;

/**
 * Created by lenovo on 2017/2/15.
 */
public class Process1 {
    public static void process() throws ClassNotFoundException, IllegalAccessException, InstantiationException{
        System.out.println("hello");
        int passed = 0;
        int failed = 0;
        Method[] methods = Class.forName("com.runfeng.test.day01.test1").getMethods();
        Object t = Class.forName("com.runfeng.test.day01.test1").newInstance();
        for (Method m : methods){
            if (m.isAnnotationPresent(Testable.class)){
                try {
                    //System.out.println(m.getName().toLowerCase());
                    //m.invoke(t);
                    m.invoke(null);
                    passed++;
                } catch (Exception e) {
                    e.printStackTrace();
                    failed++;
                }
            }
        }
        System.out.println("Success:" + passed + ";\n" + "Failed:" + failed);
    }
}
