package com.yanyi.code.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode-295
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenqiang
 * @date 2020-09-17
 * @url https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487197&idx=1&sn=0cb587fda164bda7fbcaa54cb9630fde&chksm=9bd7f0d5aca079c3ec2e68ba81a3bbd52e4260f413fa50c6d70fbffc8dd418ad68423cc1f482&scene=126&sessionid=1600311147&key=9462a1d00922de3bd761c2b022e40f3b7830840d3b6d1b3c231adac83f9a2b750df13ee57b4e5c8b9809f664984ff9d5ca52f95efc1cf4a7b4b487a14581b5554e394e442251fd2b2125f0bd91b27244d1dadff938803fd74537cd77a86be9ff94fac5115d1846c2e621d7b1aea2280775c651efe700eda10f7e9be5f1616275&ascene=1&uin=MjkyNjU0OTEwMg%3D%3D&devicetype=Windows+10+x64&version=62090529&lang=zh_CN&exportkey=A3WE%2FBX7HbnvWKNy9811jWc%3D&pass_ticket=hzfnRCLXI%2BSXn%2BKXFYEs9Td%2Blha6l1uXjtx8Th0vhWL%2BzP85QfXkTBS4veUB1j%2Fh&wx_header=0
 */
public class MedianFinder_295 {
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    private MedianFinder_295() {
        // 小顶堆  存放较大部分的数据
        large = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        // 大顶堆  存放较小部分的数据
        small = new PriorityQueue<>((a, b) -> b - a);
    }

    /**
     * 返回数据的中位数结果
     * @return
     */
    private double findMedian() {
        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (large.peek() + small.peek()) / 2.0;
    }

    /**
     * 添加一个数据到数据流结构中
     * @param num
     */
    private void addNum(int num) {
        if (small.size() == large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public static void main(String[] args) {
        MedianFinder_295 finder = new MedianFinder_295();
        finder.addNum(1);
        finder.addNum(3);
        finder.addNum(2);
        double median = finder.findMedian();
        System.out.println("median = " + median);
        finder.addNum(15);
        System.out.println("finder.findMedian() = " + finder.findMedian());
    }
}
