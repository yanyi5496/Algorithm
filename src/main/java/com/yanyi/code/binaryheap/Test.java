package com.yanyi.code.binaryheap;

/**
 * @author chenqiang
 * @description
 */
public class Test {
    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>(10);
        pq.insert(15);
        pq.insert(13);
        pq.insert(7);
        pq.toString();
    }
}
