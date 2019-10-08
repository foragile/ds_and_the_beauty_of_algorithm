package stack;

import java.util.Iterator;

public class StackOfArrayImpl<Item> implements Iterable<Item> {
    Item[] data = (Item[]) new Object[1];
    // 记录元素个数
    int N = 0;

    // 构造器
    public StackOfArrayImpl() {
    }

    // 添加元素
    public void push(Item item) {
        if (N == data.length) {
            resize(2 * data.length);
        }
        data[N++] = item;
    }

    // 改变数组容量
    private void resize(int length) {
        Item[] tmp = (Item[]) new Object[length];
        for (int i = 0; i < N; i++) {
            tmp[i] = data[i];
        }
        data = tmp;
    }

    // 出栈，即删除元素
    public Item pop() {
        Item item = data[--N];
        data[N] = null;
        if (N > 0 && N == data.length / 4)
            resize(data.length / 2);
        return item;
    }

    // 是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    // 元素个数
    public int size() {
        return N;
    }

    // 返回栈中最近添加的元素而不删除它
    public Item peek() {
        return data[N - 1];
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    class ArrayIterator implements Iterator {
        // 控制迭代数量
        int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return data[--i];
        }
    }
}
