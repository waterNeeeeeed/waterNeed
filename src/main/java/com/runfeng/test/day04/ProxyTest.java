package com.runfeng.test.day04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lenovo on 2017/2/17.
 */
interface Person{
    void walk();
    void sayHello(String name);
}

class MyInvokationHandler implements InvocationHandler{
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("***Executing the method:" + method);
        if (null != args){
            System.out.println("***The args");
            for (Object arg : args){
                System.out.println(arg);
            }
        }
        else {
            System.out.println("***No args");
        }
        return null;
    }
}
public class ProxyTest {
    public static void main(String[] args){
        InvocationHandler handler = new MyInvokationHandler();
        Person p = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[] {Person.class}, handler);
        p.walk();
        p.sayHello("hello proxy");
    }
}
