package com.runfeng.test.day03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by 帝 on 2017/2/16.
 */
public class ObjectPoolFactory {
    private Map<String, Object> objectPool = new HashMap<>();
    private Object createObject(String clzzName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clzz = Class.forName(clzzName);
        return clzz.newInstance();
    }

    public void initPool(String fileName) throws FileNotFoundException{
        InputStream fin = this.getClass().getResourceAsStream(fileName);
        Properties p = new Properties();
        try {
            p.load(fin);
            for (String name : p.stringPropertyNames()){
                objectPool.put(name, createObject(p.getProperty(name)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Object getObject(String name){
        return objectPool.get(name);
    }

    /*@Override
    public String toString(){
        return this.getClass().getSimpleName();
    }
*/
    public static void main(String[] args){
        ObjectPoolFactory poolFactory = new ObjectPoolFactory();
        try {
            poolFactory.initPool("/test.properties");
            System.out.println(poolFactory.getObject("a"));
            System.out.println(poolFactory.getObject("b"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
