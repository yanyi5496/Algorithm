package com.yanyi.code.lru;

/**
 * @author chenqiang
 * @description 双向链表  尾部的数据是最新的数据
 */
public class DoubleList {
    private Node head;
    private Node tail;  //头尾虚节点

    private int size;

    /**
     * 初始化
     */
    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * 向链表尾添加新节点 尾插
     *
     * @param root 新节点
     */
    public void addLast(Node root) {
        root.prev = tail.prev;  //新节点的前驱指向虚尾节点的前驱（即真实最后一个值地址）
        root.next = tail;  //新节点的后继指向虚尾节点
        tail.prev.next = root;  //真最后节点的后继指向新节点
        tail.prev = root; //虚尾节点的前驱指向新节点 虚尾节点的后继指向的头节点
        size++;
    }

    /**
     * 删除给定的节点 节点存在
     * @param root 节点
     */
    public void remove(Node root) {
        root.prev.next = root.next;  //需删除节点的前驱（即待删除节点的上一个节点）的后继指向待删除节点的下一个节点
        root.next.prev = root.prev;  //待删除节点的后继（待删除节点的下一个节点）的前驱指向待删除节点的上一个节点
        size--;
    }


    /**
     * 删除双向链表的头节点
     * @return
     */
    public Node remodeFirst() {
        if (head.next == tail) {
            //没有实际节点 只有虚头虚尾
            return null;
        }
        Node first = head.next; //头虚节点的下一个就是真实头节点
        remove(first);
        return first;
    }

    public int size() {
        return size;
    }


}
