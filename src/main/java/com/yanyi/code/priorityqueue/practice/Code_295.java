package com.yanyi.code.priorityqueue.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author chenqiang
 * @date 2020-09-17
 */
public class Code_295 {
    //数据总体小的堆  大堆顶
    private PriorityQueue<Integer> low;
    //数据总体大的堆  小堆顶  数据优先放在high中
    private PriorityQueue<Integer> high;

    public Code_295() {
        low = new PriorityQueue<>((a, b) -> b - a);
        high = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    }

    private void addNum(int num) {
        if (low.size() == high.size()) {
            // 优先放入到high中 要保证两个栈的元素树之差不能大于1 在优先放到high的情况下，只会有相等和high大1
            //值先放入low中
            low.offer(num);
            //将low中栈顶元素弹出存入到high中
            //保证low的栈顶小于high的栈顶
            high.offer(low.poll());
        } else {
            // 元素数不等，说明high大1，此处应该向low放入元素
            //先放入high中
            high.offer(num);
            //将high中最小的元素取出放到low中，保证low的栈顶小于high的栈顶
            low.offer(high.poll());
        }
    }

    private double findMedian() {
        if (low.size() == high.size()) {
            //元素数量一样，偶数个，取均值
            return (low.peek() + high.peek())/2.0;
        } else {
            //元素数量不一样，由于优先向high中放入，所以直接去high中栈顶元素
            return high.peek();
        }
    }

    public static void main(String[] args) {

        Code_295 finder = new Code_295();
        finder.addNum(1);
        finder.addNum(3);
        finder.addNum(2);
        finder.addNum(4);
        double median = finder.findMedian();
        System.out.println("median = " + median);
        finder.addNum(15);
        finder.addNum(8);
        System.out.println("finder.findMedian() = " + finder.findMedian());
    }
}
