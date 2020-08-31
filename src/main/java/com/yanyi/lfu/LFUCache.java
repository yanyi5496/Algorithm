package com.yanyi.lfu;

import java.security.Key;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author chenqiang
 * @description LFU
 */
public class LFUCache {
    //key到val之间的映射
    HashMap<Integer,Integer> keyToVal;
    //key到freq(频次)之间的映射
    HashMap<Integer,Integer> keyToFreq;
    //freq到keys之间的映射，同频次的key的次序
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    //最小频次
    int minFreq;
    //cache的容量
    int capacity;

    public LFUCache(int capacity){
        this.capacity = capacity;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int val) {
        if (capacity <= 0) {
            return;
        }
        // key存在，修改对应的val值即可
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key,val);
            increaseFreq(key);
            return;
        }
        //容量已满需要淘汰一个freq最小的key
        if (keyToVal.size() >= this.capacity) {
            removeMinfreqkey();
        }

        keyToVal.put(key,val);
        keyToFreq.put(key,1);
        freqToKeys.putIfAbsent(1,new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }


    /**
     * 移除最少使用且最旧的
     */
    private void removeMinfreqkey(){
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        Integer deletedKey = keyList.iterator().next();
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }
        keyToVal.remove(deletedKey);
        keyToFreq.remove(deletedKey);
    }

    /**
     * 增加该key的访问频次
     * @param key
     */
    private void increaseFreq(int key) {
        Integer oldFreq = keyToFreq.get(key);
        keyToFreq.put(key,oldFreq+1);

        // 将 key 从 freq 对应的列表中删除
        freqToKeys.get(oldFreq).remove(key);

        // 将 key 加入 freq + 1 对应的列表中
        freqToKeys.putIfAbsent(oldFreq+1,new LinkedHashSet<>());
        freqToKeys.get(oldFreq+1).add(key);

        // 如果 freq 对应的列表空了，移除这个 freq
        if (freqToKeys.get(oldFreq).isEmpty()) {
            freqToKeys.remove(oldFreq);
            // 如果这个 freq 恰好是 minFreq，更新 minFreq
            if (oldFreq == this.minFreq) {
                this.minFreq++;
            }
        }
    }
}
