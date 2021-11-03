package com.youjian.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 首先在未排序序列中找到最小元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 */
public class Code01_SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) { // 遍历 0 ~ n-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { // 找到最小的，index赋给minIndex
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }

            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {-84, -53, -49, -44, -32, -31, -26, 0, -18, -9, -9, -6, -4, -2, -1, 3, 16, 17, 24, 41, 41, 41, 47, 54, 77, 85};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
