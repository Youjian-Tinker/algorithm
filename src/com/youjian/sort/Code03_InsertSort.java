package com.youjian.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class Code03_InsertSort {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) { // j+1为当前数，从位置开始；j为左侧待比较对象
                swap(arr, j, j + 1); // 当前数小于待比较对象时交换，并向左移一位；直到到达0位置或者待比较对象比当前数大
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 8, 0, 2, 1, 7};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
