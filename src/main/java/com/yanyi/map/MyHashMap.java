package com.yanyi.map;

import java.util.Set;

/**
 * @author chenqiang
 * @since 2021-01-20 16:30
 */
public class MyHashMap<K, V> implements MapInterface<K, V> {

    /**
     * 默认初始容量，必须为2的幂 默认16
     */
    static final int DEFAULT_INITTAL_CAPACITY = 1 << 4;
    /**
     * 最大容量，如果两个构造函数都使用参数隐式指定了更高的值，则使用该容量。 必须是两个<= 1 << 30的幂。
     */
    static final int MAXINUM_CAPACITY = 1 << 30;
    /**
     * 在构造函数中未指定时使用的负载系数
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 基本哈希箱节点，用于大多数条目。
     * @param <K>
     * @param <V>
     */
    static class Node<K, V> implements MapInterface.Entry<K, V> {
        //hash值
        int hash;
        K key;
        V value;
        // 下一个节点
        Node<K, V> next;

        public Node() {
        }

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    /**
     * 计算key的hash值
     * @param key key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * 该表在首次使用时初始化，并根据需要调整大小。 分配时，长度始终是2的幂。
     */
    Node<K, V>[] table;

    Set<Entry<K, V>> entrySet;























    @Override
    public int size() {
        return 0;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }
}
