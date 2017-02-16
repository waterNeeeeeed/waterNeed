package com.runfeng.test.day03;


import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by 帝 on 2017/2/16.
 */
public class CreateFrame {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> jframe = Class.forName("javax.swing.JFrame");
        Constructor constructor = jframe.getConstructor(String.class);
        Object obj = constructor.newInstance("Test");
        ((JFrame)obj).setVisible(true);
        System.out.println(obj);
    }
}
