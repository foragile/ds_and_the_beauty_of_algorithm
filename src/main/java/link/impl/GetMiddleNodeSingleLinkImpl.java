package link.impl;

public class GetMiddleNodeSingleLinkImpl {

    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        Node head = buildSingleLinkList(new int[]{1, 3, 5, 7, 8});
        Node middle = getMiddleNode(head);
        if (middle.data == 5) {
            System.out.println("right");
        } else {
            System.out.println("wrong");
        }

        head = buildSingleLinkList(new int[]{1, 3});
        middle = getMiddleNode(head);
        if (middle.data == 1) {
            System.out.println("right");
        } else {
            System.out.println("wrong");
        }
        head = buildSingleLinkList(new int[]{1, 3, 5, 7});
        middle = getMiddleNode(head);
        if (middle.data == 3) {
            System.out.println("right");
        } else {
            System.out.println("wrong");
        }
    }

   public static Node buildSingleLinkList(int[] nodeArr) {
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


    public static Node getMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node p1 = head;
        Node p2 = head;

        while (p2 != null && p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        //结点数为奇数
        if (p2 != null) {
            return p1;
        } else {
            return p1.next;
        }
    }

}
