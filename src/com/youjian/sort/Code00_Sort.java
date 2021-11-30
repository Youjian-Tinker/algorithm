package com.youjian.sort;

import java.util.Arrays;

/////////////////////////////////////////////////////////////////////////////////////////
// 算法       // 时间复杂度 // 空间复杂度 // 稳定性   //
/////////////////////////////////////////////////////////////////////////////////////////
// 选择       // N^2      // 1        // false    //
/////////////////////////////////////////////////////////////////////////////////////////
// 冒泡       // N^2      // 1        // true     //
/////////////////////////////////////////////////////////////////////////////////////////
// 插入       // N^2      // 1        // true     //
/////////////////////////////////////////////////////////////////////////////////////////
// 归并       // NlogN    // N        // true     //
/////////////////////////////////////////////////////////////////////////////////////////
// 快排       // NlogN    // logN     // false    //
/////////////////////////////////////////////////////////////////////////////////////////
// 堆         // NlogN    // 1        // false    //
/////////////////////////////////////////////////////////////////////////////////////////

public class Code00_Sort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**************************************选择排序***************************************/
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    /**************************************冒泡排序***************************************/
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**************************************插入排序***************************************/
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--) {
                swap(arr, j, j+1);
            }
        }
    }

    /**************************************归并排序***************************************/
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + ((r  - l) >> 1);
            process(arr, l, m);
            process(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while(p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    /**************************************快速排序***************************************/
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        int temp = l + (int) ((r - l + 1) * Math.random());
        swap(arr, temp, r);
        int[] res = partition(arr, l, r);
        if (l < res[0] - 1) {
            quickSort(arr, l, res[0] - 1);
        }
        if (r > res[1] + 1) {
            quickSort(arr, res[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        int i = l;
        while (i < more) {
            if (arr[i] < arr[r]) {
                swap(arr, ++less, i++);
            } else if (arr[i] == arr[r]) {
                i++;
            } else {
                swap(arr, i, --more);
            }
        }

        swap(arr, more, r);
        return new int[] {less + 1, more};
    }

    /**************************************堆排序***************************************/
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        while (heapSize > 0) {
            swap(arr, 0, heapSize - 1);
            heapify(arr, 0, --heapSize);
        }

    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize ? (arr[left] > arr[left + 1] ? left : left + 1) : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (arr[index] >= arr[largest]) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    /**************************************对数器*****************************************/
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1) - Math.random() * (maxValue + 1));
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }

        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return arr1 == null && arr2 == null;
        }
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**************************************主函数*****************************************/
    public static void main(String[] args) {
        int testTimes = 10000;
        int maxSize = 100;
        int maxValue = 100;
        boolean success = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            Arrays.sort(arr1);
            heapSort(arr2);
            if (!isEqual(arr1, arr2)) {
                success = false;
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                break;
            }
        }

        if (success) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }
}
