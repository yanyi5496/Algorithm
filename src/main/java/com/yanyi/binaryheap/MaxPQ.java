package com.yanyi.binaryheap;

import java.util.Arrays;

/**
 * @author chenqiang
 * @description binary heap 二叉堆
 * priority queue优先级队列  最大堆，即堆顶为最大值
 * @url https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/er-cha-dui-xiang-jie-shi-xian-you-xian-ji-dui-lie
 */
public class MaxPQ<Key extends Comparable<Key>> {
    //存储元素的数组
    private Key[] pq;
    //元素的个数
    private int N = 0;

    public MaxPQ(int capacity) {
        //索引0不使用，需要多分配一个空间
        pq = (Key[]) new Comparable[capacity + 1];
    }

    /**
     * 返回队列的最大元素
     *
     * @return
     */
    public Key max() {
        return pq[1];
    }

    /**
     * 向堆中插入元素
     *
     * @param e
     */
    public void insert(Key e) {
        N++;
        pq[N] = e;
        swim(N);
    }

    /**
     * 删除并返回当前队列的最大元素
     *
     * @return
     */
    public Key delMax() {
        //堆顶元素即为最大元素
        Key max = pq[1];
        //将堆顶元素和堆底元素交换位置
        swap(1, N);
        //将堆底（最大值）的值删除
        pq[N] = null;
        N--;
        //将堆顶的元素下沉
        sink(1);
        return max;
    }

    /**
     * 上浮第k个元素 维护最大堆性质
     *
     * @param k
     */
    private void swim(int k) {
        //非堆顶且父节点小于子节点 上浮
        while (k > 1 && less(parent(k), k)) {
            swap(parent(k), k);
            k = parent(k);
        }
    }

    /**
     * 下沉第k个元素，维护最大堆性质
     *
     * @param k
     */
    private void sink(int k) {
        // 如果沉到堆底，就沉不下去了
        while (left(k) < N) {
            // 假设左节点比较大
            int older = left(k);
            // 如果右节点存在则比较大小
            if (right(k) <= N && less(older, right(k))) {
                older = right(k);
            }
            if (less(older,k)) break;
            swap(k, older);
            k = older;
        }
    }

    /**
     * 交换两个元素的值
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /**
     * 元素是否小于
     *
     * @param i 索引
     * @param j 索引
     * @return
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * 当前节点的父节点索引
     *
     * @param root
     * @return
     */
    private int parent(int root) {
        return root / 2;
    }

    /**
     * 当前节点的左孩子索引
     *
     * @param root
     * @return
     */
    private int left(int root) {
        return root * 2;
    }

    /**
     * 当前节点的右孩子索引
     *
     * @param root
     * @return
     */
    private int right(int root) {
        return root * 2 + 1;
    }

    @Override
    public String toString() {
        return "MaxPQ{" +
                "pq=" + Arrays.toString(pq) +
                ", N=" + N +
                '}';
    }
}
