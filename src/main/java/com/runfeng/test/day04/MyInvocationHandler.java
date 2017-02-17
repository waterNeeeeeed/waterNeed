package com.runfeng.test.day04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lenovo on 2017/2/17.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public void setTarget(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil du = new DogUtil();
        du.method1();
        Object result = method.invoke(target, args);
        du.method2();
        return result;
    }
}
