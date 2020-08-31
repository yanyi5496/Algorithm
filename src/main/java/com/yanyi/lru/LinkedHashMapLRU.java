package com.yanyi.lru;

import java.util.LinkedHashMap;

/**
 * @author chenqiang
 * @description  使用LinkedhashMap完成LRU(Least Recently Used)算法 内存淘汰算法
 */
public class LinkedHashMapLRU {
    public int capacity;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LinkedHashMapLRU(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsValue(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsValue(key)) {
            cache.put(key,val); //此操作只替换了旧值，未将其移至最近使用
            makeRecently(key);
        }

        if (cache.size() >= capacity) {
            //清除链表头部节点
            Integer first = cache.keySet().iterator().next(); //迭代的第一个头节点即是最久未使用的key
            cache.remove(first);
        }
        cache.put(key,val);
    }


    /**
     * 将某个key提升为最近使用
     * @param key
     */
    private void makeRecently(int key) {
        Integer val = cache.get(key);
        cache.remove(key);
        cache.put(key,val);
    }
}
