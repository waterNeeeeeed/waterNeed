package com.runfeng.apt;

import java.lang.annotation.*;

/**
 * Created by lenovo on 2017/2/15.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
@Documented
public @interface Id {
    String column();
    String type();
    String generator();
}
