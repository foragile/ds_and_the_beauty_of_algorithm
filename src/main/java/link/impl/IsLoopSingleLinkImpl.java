package link.impl;

public class IsLoopSingleLinkImpl {
    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        System.out.println("impl1:");
        boolean setLoop = false;
        Node head = buildALoopSingleLinkList(setLoop);
        boolean isLoop = isLoop(head);
        String desc = isLoop == setLoop ? "right" : "wrong";
        if (isLoop) {
            System.out.println(desc + ",it's a loop list");
        } else {
            System.out.println(desc + ",it's not a loop list");
        }
    }

    public static boolean isLoop(Node head) {
        if (head == null) {
            return false;
        }

        if (head.next != null && head.next == head) {
            return true;
        }
        Node p1 = head;
        Node p2 = head;

        while (p1.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    public static Node buildALoopSingleLinkList(boolean isLoop) {
        Node node1 = new Node();
        node1.data = 1;

        Node node2 = new Node();
        node2.data = 2;

        Node node3 = new Node();
        node3.data = 3;

        Node node4 = new Node();
        node4.data = 4;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        if (isLoop) {
            node4.next = node1;
        }

        return node1;
    }
}
