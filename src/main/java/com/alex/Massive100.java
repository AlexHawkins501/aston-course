package com.alex;

import java.util.Arrays;
// Задание 11
public class Massive100 {
    public static void main(String[] args) {

        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i]=i+1;
        }
        System.out.println(Arrays.toString(array));
    }
}
