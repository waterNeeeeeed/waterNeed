package com.runfeng.apt;

import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * Created by lenovo on 2017/2/15.
 */
public class Main {
    public static void main(String[] args){
        Processor p = new HibernateAnnotationProcessor();
        //p.process();
        RoundEnvironment runtimeEnvironment;
    }
}
