package com.yanyi.code.sort;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 插入排序
 * <p>
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 * <p>
 * 插入排序第一次会使第一位有序
 * <p>
 * 第二次会使前两位有序，但不一定是整个数组得最小（大）值部分，只是这两个元素之间有序。
 * <p>
 * 即前面的有序部分中的元素在下一次遍历中位置也可能发生更改。
 * <p>
 * 遍历未排序的元素，将其和该元素前一个值比较
 * <p>
 * 若该元素和前值的大小关系和有序部分不一致，
 * <p>
 * 则交换该元素和前值，然后该元素和新的前值继续比较，交换
 * <p>
 * 直到找到自己的位置，使前n位依然有序
 *
 * @author chenqiang
 * @date 2020-09-21
 */
public class InsertSort {
    /**
     * 结果从小到大排列
     *
     * @param array
     */
    private static void sort(int[] array) {
        int current;
        //第0位默认有序，直接从第1位开始遍历
        for (int i = 1; i < array.length; i++) {
            //当前值
            current = array[i];
            //索引 初始化为当前值的前一位
            int preIndex = i - 1;
            //索引大于0 并且 前一位大于当前值 则当前值需要往更前方移动 重复比较 直到该值位于正确的位置
            while (preIndex >= 0 && array[preIndex] > current) {
                //将当前值和前一位交换
                array[preIndex + 1] = array[preIndex];
                array[preIndex] = current;
                //索引前移
                preIndex--;
            }
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
