package com.example.datastructre.sortings;

import java.util.Arrays;

/**
 * Created by Dipak Kumar Mehta on 11/22/2021.
 */
public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }

    public static void main(String a[]) {
        int[] arr = {40, 10, -30, 45, 39, 32};
        System.out.println("Before Sorting : ");
        System.out.println(Arrays.toString(arr));
        arr = selectionSort(arr);
        System.out.println("===================");
        System.out.println("After Sorting : ");
        System.out.println(Arrays.toString(arr));
    }
}
