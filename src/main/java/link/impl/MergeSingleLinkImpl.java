package link.impl;

public class MergeSingleLinkImpl {

    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        Node l1 = buildSingleLinkList(new int[]{1, 3, 5, 7, 8});
        Node l2 = buildSingleLinkList(new int[]{2, 4, 6, 9, 10});
        Node l = merge(l1, l2);
        l = l.next;
        while (l != null) {
            System.out.println(l.data);
            l = l.next;
        }
    }

    static Node buildSingleLinkList(int[] nodeArr) {
        Node head = null;
        Node pnext = null;
        for (int i : nodeArr) {
            Node node = new Node();
            node.data = i;
            if (head == null) {
                head = node;
                pnext = head;
            } else {
                pnext.next = node;
                pnext = node;
            }
        }

        return head;
    }

    static Node merge(Node l1, Node l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        Node head = new Node();
        Node p = head;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                p.next = l1;
                p = l1;
                l1 = l1.next;

            } else {
                p.next = l2;
                p = l2;
                l2 = l2.next;
            }
        }
        p.next = l1 == null ? l2 : l1;

        return head;
    }
}
