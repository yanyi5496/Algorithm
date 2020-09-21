package com.yanyi.code.sort;

import java.util.Arrays;

/**
 * 选择排序实现
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，
 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * @author chenqiang
 * @date 2020-09-21
 */
public class SelectSort {
    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //最小值的索引 初始为开始循环值
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[index]) {
                    //寻找到更小值，更改最小值索引
                    index = j;
                }
            }
            //交换起始值和最小值
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 12, 8, 4, 3, 14};
        sort(arr);
    }
}
