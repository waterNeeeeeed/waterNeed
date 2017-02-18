package com.runfeng.test.day05;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by hasee-pc on 2017/2/18.
 */
public class MyClassLoader extends ClassLoader {


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass" + ":" + name);
        return super.findClass(name);
    }

    public static void main(String... args)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        MyClassLoader mcl = new MyClassLoader();
        Class<?> clzz = mcl.loadClass("com.runfeng.test.day05.Hello");
        Method main = clzz.getMethod("main", (new String[1]).getClass());
        Method hi = clzz.getMethod("hi", (new int[0]).getClass());
        Method argTest = clzz.getMethod("argTest", int.class, String.class);
        String[] progArgs = new String[]{"hello", "world"};
        //Object[] array = (Object[])progArgs;
        Object[] array = {progArgs};
        for (Object o : array){
            System.out.println(o);
        }
        System.out.println(array.length);
        Object obj = clzz.newInstance();

        main.invoke(null, array);//(Object[])(new String[1]));//(Object[])(new String[0]));
        int[] a = {1,2};
        Object[] array1 ={a};
        hi.invoke(obj, array1);

        Object[] array2 = {1, "haha"};
        System.out.println("I see" + ":" + array2.length);
        argTest.invoke(obj, array2);
    }
}
