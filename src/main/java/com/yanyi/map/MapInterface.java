package com.yanyi.map;

/**
 * Map接口，提供key->value的映射，其中key不可重复
 * 包含以下基本方法：
 * 1)key->value映射的数量
 * 2)添加key和value
 * 3)是否为空
 * 4)是否含有某个key
 * 5)是否含有某个value
 * 6)根据key获取对应的value
 * 7)移除某个key及对应的value
 *
 * @param <K> key
 * @param <V> value
 * @author chenqiang
 * @since 2021-01-20 15:47
 */
public interface MapInterface<K, V> {
    /**
     * 返回key->value映射的数量
     *
     * @return 映射数量
     */
    int size();

    /**
     * 将指定值与此映射中的指定键关联（可选操作）。
     * 如果映射先前包含键的映射，则旧值将替换为指定值。
     * （仅当m.containsKey(k)返回true时，才认为映射m包含键k的映射。
     * @param key key
     * @param value value
     * @return
     */
    V put(K key, V value);

    /**
     * 如果此映射不包含键值映射，则返回true 。
     * @return 如果此映射不包含键值映射，则返回true 。
     */
    boolean isEmpty();

    /**
     * 如果此映射包含指定键的映射，则返回true 。 更正式地讲，当且仅当此映射包含键k的映射时才返回true
     * @param key key
     * @return 如果此映射包含指定键的映射，则返回true
     */
    boolean containsKey(Object key);

    /**
     * 如果此映射将一个或多个键映射到指定值，则返回true 。 更正式地讲，当且仅当此映射包含至少一个到值v的映
     * @param value value
     * @return 如果此映射将一个或多个键映射到指定值，则返回tru
     */
    boolean containsValue(Object value);

    /**
     * 返回指定键所映射到的null如果此映射不包含键的映射关系，则返回null
     * @param key key
     * @return value
     */
    V get(Object key);

    /**
     * 如果存在，则从此映射中删除键的映射（可选操作）
     * @param key key
     * @return 如果存在，则从此映射中删除键的映射（可选操作）
     */
    V remove(Object key);

    /**
     * 映射条目
     * @param <K>
     * @param <V>
     */
    interface Entry<K, V> {
        /**
         * 返回与此条目对应的Key。
         * @return 返回与此条目对应的key。
         */
        K getKey();

        /**
         * 返回与此条目对应的value。
         * @return 返回与此条目对应的value。
         */
        V getValue();
    }
}
