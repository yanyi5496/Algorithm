package com.yanyi.designpattern.chainofresponsibility;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 帮助配置handler链
 *
 * @author chenqiang
 * @since 2021-01-26 17:18
 */
public class HandlerRegistry<T> {
    private final Map<Integer, Handler<T>> handlerMap = new ConcurrentHashMap<>();

    public HandlerRegistry<T> apply(Handler<T> handler) {
        Class<? extends Handler> aClass = handler.getClass();
        int size = handlerMap.size();
        int index;
        Set<Integer> set = handlerMap.keySet();
        if (aClass.isAnnotationPresent(HandlerIndex.class)) {
            HandlerIndex value = aClass.getAnnotation(HandlerIndex.class);
            index = value.value();
        } else {
            index = size;
        }
        while (set.contains(index)) {
            index++;
        }
        handlerMap.put(index, handler);
        return this;
    }

    public void invoke(T t) {
        Set<Integer> collect = new HashSet<>(handlerMap.keySet());
        for (Integer integer : collect) {
            handlerMap.get(integer).process(t);
        }
    }
}
