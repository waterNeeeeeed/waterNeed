package com.runfeng.test.day04;

/**
 * Created by lenovo on 2017/2/17.
 */
public class Test {
    public static void main(String[] args){
        Dog target = new GunDog();
        Dog dog = (Dog)MyProxyFactory.getProxy(target);
        dog.info();
        dog.run();
    }
}
