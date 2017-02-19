package com.runfeng.test.day06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by hasee-pc on 2017/2/19.
 */
public class SortTest {
    public static void main(String[] args){
        ArrayList numbers = new ArrayList();

        numbers.add(1);
        numbers.add(2);
        numbers.add(-1);
        numbers.add(8);
        System.out.println(numbers);
        Collections.reverse(numbers);
        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println(numbers);
        Collections.rotate(numbers, 2);
        System.out.println(numbers);
        Collections.shuffle(numbers);
        System.out.println(numbers);

    }
}
