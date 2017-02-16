package com.runfeng.test.day01;

import java.lang.annotation.*;

/**
 * Created by lenovo on 2017/2/15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(RfTags.class)
public @interface RfTag {
    String name() default "RF software";
    int age();
}
