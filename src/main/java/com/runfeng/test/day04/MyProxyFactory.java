package com.runfeng.test.day04;

import java.lang.reflect.Proxy;

/**
 * Created by lenovo on 2017/2/17.
 */
public class MyProxyFactory {
    public static Object getProxy(Object target){
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setTarget(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
    }
}
