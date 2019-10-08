package link.impl;

public class RemoveNthFromEndImpl {

    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        //example1:
        Node head = buildSingleLinkList(new int[]{1});
        head = removeNthNodeFromEnd(head, 2);
        System.out.println("remove the 2th node from end:");
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
        //example2:
        head = buildSingleLinkList(new int[]{1, 2});
        head = removeNthNodeFromEnd(head, 2);
        System.out.println("remove the 2th node from end:");
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

        //example3:
        head = buildSingleLinkList(new int[]{1, 2, 3});
        head = removeNthNodeFromEnd(head, 2);
        System.out.println("remove the 2th node from end:");
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

        //example4:
        head = buildSingleLinkList(new int[]{1, 2, 3, 4, 5});
        head = removeNthNodeFromEnd(head, 2);
        System.out.println("remove the 2th node from end:");
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
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

    static Node removeNthNodeFromEnd(Node head, int n) {
        Node p1 = head;
        int i = 0;
        while (i < n) {
            if (p1 != null) {
                p1 = p1.next;
            } else {
                break;
            }
            i++;
        }
        //总结点数少于n个
        if (i < n) {
            return head;
        }
        //总结点数等于n个,倒数第n个结点即为首结点,删除首结点
        if (p1 == null) {
            head = head.next;
            return head;
        }
        Node p2 = head;
        // p1达到链表尾端，p2的next结点即为倒数第n个结点
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // p2的next结点即为倒数第n个结点，删除该结点
        p2.next = p2.next.next;

        return head;
    }
}
