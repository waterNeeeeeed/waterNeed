package com.runfeng.test.day04;

/**
 * Created by lenovo on 2017/2/17.
 */
public class GunDog implements Dog{
    @Override
    public void info() {
        System.out.println("GunDog info");
    }

    @Override
    public void run() {
        System.out.println("GunDog run");
    }
}
