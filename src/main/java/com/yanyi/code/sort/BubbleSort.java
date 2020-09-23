package com.yanyi.code.sort;

import java.util.Arrays;

/**
 * 冒泡算法实现
 * <p>
 * 它重复地走访过要排序的元素列，依次比较两个相邻的元素，如果顺序（如从大到小、首字母从Z到A）错误就把他们交换过来。
 * 走访元素的工作是重复地进行直到没有相邻元素需要交换，也就是说该元素列已经排序完成。
 * <p>
 * 第一遍会将最小值或者最大值冒泡到最后
 * <p>
 * 第二遍则会将倒数第二大（小）值冒泡到倒数第二位，依此类推
 * <p>
 * 冒泡在不停的移动元素
 * <p>
 * 有序部分不会再发生改变
 *
 * @author chenqiang
 * @date 2020-09-21
 */
public class BubbleSort {
    /**
     * 冒泡排序算法实现
     *
     * @param arr
     * @return
     */
    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // -i的原因 前面循环i次已经使后i的元素有序，可以不再比较
            // -1的原因 防止 j+1数组越界
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 12, 8, 4, 3, 14};
        sort(arr);
    }
}
