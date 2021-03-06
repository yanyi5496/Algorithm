package com.yanyi.code.lru;

import java.util.HashMap;

/**
 * @author chenqiang
 * @description  LRU的自实现 在cache中删除掉一个节点时，要同时删除map中的值
 * @url https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/lru-suan-fa
 */
public class LRUCache {
    //key -> Node(key,val)
    private HashMap<Integer,Node> map;
    //双向链表模拟实际缓存 Node(key,val) <-> Node(key,val)
    private DoubleList cache;
    //缓存最大容量
    private int capacity;

    /**
     * 初始化
     * @param capacity
     */
    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    /**
     * 将某个key提升为最近使用的
     * @param key
     */
    private void makeRecently(int key) {
        Node root = map.get(key);
        //从链表中删除
        cache.remove(root);
        //插入到队尾
        cache.addLast(root);
    }


    /**
     * 添加最近使用的元素
     * @param key
     * @param val
     */
    private void addRecently(int key, int val) {
        Node root = new Node(key,val);
        map.put(key,root);
        cache.addLast(root);
    }

    /**
     * 删除一个key
     * @param key
     */
    private void deleteKey(int key) {
        Node root = map.get(key);
        cache.remove(root);
        map.remove(key);
    }


    /**
     * 删除最久未使用的节点
     */
    private void removeLeastRecently() {
        //头部即是最久未使用节点
        Node root = cache.remodeFirst();
        int key = root.key;
        map.remove(key);
    }

    /**
     * 若key存在返回key对应的值
     * @param key
     * @return
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //使其成为最近使用的
        makeRecently(key);
        return map.get(key).val;
    }

    /**
     * 加入到 cache中
     * @param key
     * @param val
     */
    public void put(int key, int val) {
        if (map.containsKey(key)) {
            //如果已有该key
            deleteKey(key);
            addRecently(key,val);
            return;
        }
        if (capacity == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key,val);
    }



}
