package com.youjian.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class Code05_QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, r, l + (int)(Math.random()*(r - l + 1)));
            int[] temp = partition(arr, l, r);
            quickSort(arr, l, temp[0] - 1);
            quickSort(arr, temp[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        // l表示当前数位置，less表示小于区位置，more表示大于区位置
        // 当前数比参照数（arr[r]）小，交换当前数和小于区后一个数，l++, less++
        // 当前数与参照数相等，l++
        // 当前数比参照数大，交换当前数和大于区前一个数，more--
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, l++, ++less);
            } else if (arr[l] == arr[r]) {
                l++;
            } else {
                swap(arr, l, --more);
            }
        }

        // 将最后r位置的数和大于区第一个数（more）交换
        swap(arr, r, more);
        return new int[] {less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 4, 7, 9, 2, 0};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
