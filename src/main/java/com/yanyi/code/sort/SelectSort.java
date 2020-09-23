package com.yanyi.code.sort;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 选择排序实现
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * <p>
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，
 * <p>
 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 *
 * 已排序部分的数据不会发生改变。
 * <p>
 * 第一遍会将最大（小）值选择到起始位置 依此类推
 * <p>
 * 在遍历完一次之后才进行元素的交换
 *
 * @author chenqiang
 * @date 2020-09-21
 */
public class SelectSort {
    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //最小值的索引 初始为起始循环值
            int index = i;
            //前i个已经有序
            for (int j = i; j < array.length; j++) {
                //遍历每一个值来与当前的最小值比较
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
        int[] arr = new int[]{1, 5, 12, 8, 4, 3, 14, 16, 7, 21, 22, 25, 24, 23};
        StopWatch watch = new StopWatch();
        watch.start();
        sort(arr);
        watch.stop();
        System.out.println("watch. = " + watch.getTime(TimeUnit.MICROSECONDS));
    }
}
