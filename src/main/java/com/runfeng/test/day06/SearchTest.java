package com.runfeng.test.day06;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by hasee-pc on 2017/2/19.
 */
public class SearchTest {
    public static void main(String[] args){
        ArrayList numbers = new ArrayList();
        numbers.add(1);
        numbers.add(2);
        numbers.add(-1);
        numbers.add(8);
        System.out.println(numbers);
        System.out.println(Collections.max(numbers));
        System.out.println(Collections.min(numbers));
        Collections.replaceAll(numbers, 1, 6);
        System.out.println(numbers);
        System.out.println(Collections.frequency(numbers, 0));
        Collections.sort(numbers);
        System.out.println(numbers);
        System.out.println(Collections.binarySearch(numbers, 2));
    }
}
