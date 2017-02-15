package com.runfeng.test;

/**
 * Created by lenovo on 2017/2/15.
 */
@RfTags({@RfTag(age=5), @RfTag(name="la", age=6)})
public class RfTagTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<RfTagTest> clzz = RfTagTest.class;
        //Class<?> clzz1 = Class.forName("com.runfeng.test.RfTagTest");//RfTagTest.class;
        //RfTagTest rt = new RfTagTest();
        RfTag[] rfTags = clzz.getDeclaredAnnotationsByType(RfTag.class);
        for (RfTag r:rfTags){
            System.out.println(r.name() + ":" + r.age());
        }

        RfTags container = clzz.getDeclaredAnnotation(RfTags.class);
        System.out.println(container);
    }
}
