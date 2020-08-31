package com.yanyi.lru;

/**
 * @author chenqiang
 * @description LRU自实现 链表节点
 */
public class Node {
    public int key;
    public int val;
    public Node node;
    public Node next;
    public Node prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}
