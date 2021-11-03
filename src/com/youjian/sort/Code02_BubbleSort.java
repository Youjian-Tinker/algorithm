package com.youjian.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 重复地走访过要排序的数列，依次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 */
public class Code02_BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i > 0; i--) { // 从后往前排，表示0~i范围需要排序
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) { // 利用异或进行交换，前提条件是两个变量拥有独立的内存，即i != j
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 8, 0, 2, 1, 7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
