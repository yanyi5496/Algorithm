package com.yanyi.code.sort;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 希尔排序
 * <p>
 * 首先设置一个增量gap = length / 2，后续gap = gap / 2，直到gap = 1。gap为几则将整个数组分为几组
 *
 * @author chenqiang
 * @date 2020-09-22
 */
public class ShellSort {
    private static void sort(int[] array) {
        int len = array.length;
        //设置初始gap = len / 2;
        int gap = len / 2;
        int current;
        while (gap > 0) {

            for (int i = gap; i < len; i++) {
                //从gap起始，gap位数据和i-gap刚好构成一组 如len=10 gap=5 则5和0一组 6和1一组
                //对每一组的元素进行插入排序 以下部分为插入排序 前值为同组的前值，不再是实际上的前值
                //当前值
                current = array[i];
                //同组的前一个值
                int preIndex = i - gap;
                //前值大于当前值则交换位置
                while (preIndex > 0 && array[preIndex] > current) {
                    array[preIndex + gap] = array[preIndex];
                    array[preIndex] = current;
                    preIndex = preIndex - gap;
                }
            }
            //gap缩小
            gap = gap / 2;
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 12, 8, 4, 3, 14, 16, 7, 21, 22, 25, 24, 23, 2};
        StopWatch watch = new StopWatch();
        watch.start();
        sort(arr);
        watch.stop();
        System.out.println("watch. = " + watch.getTime(TimeUnit.MICROSECONDS));
    }
}
