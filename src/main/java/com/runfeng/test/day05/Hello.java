package com.runfeng.test.day05;

/**
 * Created by hasee-pc on 2017/2/19.
 */
public class Hello {
    public void argTest(int a, String b){
        System.out.println(a);
        System.out.println(b);
    }

    public void hi(int[] args){
        System.out.println(args[0]);
        System.out.println(args[1]);
    }

    public static void main(String[] args){
        System.out.println("MyClassLoader" + ":" + "Hello");
    }
}
