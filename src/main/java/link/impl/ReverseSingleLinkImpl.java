package link.impl;

public class ReverseSingleLinkImpl {
    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        //reverse1
        System.out.println("impl1:");
        Node head = reverse1(buildSingleLinkList(new int[]{1, 2, 3, 4, 5}));
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
        //reverse2
        System.out.println("impl2:");
        head = reverse2(buildSingleLinkList(new int[]{1, 2, 3, 4, 5}));
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
        //reverse3
        System.out.println("impl3:");
        Node headNode = buildSingleLinkList(new int[]{1, 2, 3, 4, 5});
        head = reverse3(headNode, null);
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    /**
     * 非递归实现
     *
     * @param head
     * @return
     */
    static Node reverse1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node current = head;
        Node pre = null;
        Node pnext = null;
        while (current != null) {
            pnext = current.next;
            current.next = pre;
            pre = current;
            current = pnext;
        }

        return pre;
    }

    /**
     * 递归实现
     *
     * @param current
     */
    static Node reverse2(Node current) {
        if (current.next == null) {
            return current;
        }
        Node pnext = current.next;
        current.next = null;
        Node reversed = reverse2(pnext);
        pnext.next = current;

        return reversed;
    }

    /**
     * @param current
     * @param pre
     * @return
     */
    static Node reverse3(Node current, Node pre) {
        if (current.next == null) {
            current.next = pre;
            return current;
        } else {
            Node next = current.next;
            current.next = pre;
            return reverse3(next, current);
        }
    }

    static Node buildSingleLinkList(int[] nodeArr) {
        Node head = null;
        Node next = null;
        for (int i : nodeArr) {
            Node node = new Node();
            node.data = i;
            node.next = null;
            if (head == null) {
                head = node;
                next = head;
            } else {
                next.next = node;
                next = node;
            }
        }
        return head;
    }
}
