package com.runfeng.test.day05;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by hasee-pc on 2017/2/18.
 */
public class MyClassLoader extends ClassLoader {

    private boolean compile(String name){
        try {
            Process p = Runtime.getRuntime().exec("javac "+ name);
            p.waitFor();
            return (p.exitValue() == 0);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        System.out.println("findClass" + ":" + name);
        String filestub = name.replace(".", "/");
        String javaFilename = filestub + ".java";
        String classFilename = filestub + ".class";

        File javaFile = new File(javaFilename);
        File classFile = new File(classFilename);

        System.out.println(javaFile.getAbsolutePath());
        if (javaFile.exists() && (!classFile.exists() || javaFile.lastModified()>classFile.lastModified()) ){
            if (!compile(javaFilename) || !classFile.exists()){
                try {
                    throw new Exception("compile false");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try{
                File cf = new File(classFilename);
                FileInputStream fin = new FileInputStream(cf);
                byte[] buffer = new byte[(int)cf.length()];
                fin.read(buffer);
                Class<?> clzz = defineClass(name.substring(name.lastIndexOf(".") + 1), buffer, 0, buffer.length);
                return clzz;
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    /*
    进入类的根目录，命令行执行：
     */
    public static void main(String... args)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        MyClassLoader mcl = new MyClassLoader();
        String progClass = args[0];
        System.out.println(progClass);
        Class<?> clzz = mcl.loadClass(progClass);//("com.runfeng.test.day05.Hello");
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
