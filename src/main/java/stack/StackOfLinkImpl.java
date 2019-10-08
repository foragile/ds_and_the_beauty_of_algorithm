package stack;

import java.util.Iterator;

public class StackOfLinkImpl<Item> implements Iterable<Item> {
    // 定义一个内部类，就可以直接使用类型参数
    private class Node {
        Item item;
        Node next;
    }

    private Node head;
    private int N;

    // 构造器
    public StackOfLinkImpl() {

    }

    // 添加元素
    public void push(Item item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        N++;
    }

    // 出栈，即删除元素
    public Item pop() {
        Item item = head.item;
        head = head.next;
        N--;
        return item;
    }

    // 是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    // 元素数量
    public int size() {
        return N;
    }

    // 返回栈中最近添加的元素而不删除它
    public Item peek() {
        return head.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    class LinkedIterator implements Iterator {
        int i = N;
        Node current = head;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Object next() {
            Item item = (Item) current.item;
            current = current.next;
            i--;
            return item;
        }
    }
}
