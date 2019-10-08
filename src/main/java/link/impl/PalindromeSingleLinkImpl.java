package link.impl;

public class PalindromeSingleLinkImpl {
    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(new int[]{1, 2, 3, 2, 1}));//True
        System.out.println(isPalindrome(new int[]{1, 1}));//True
        System.out.println(isPalindrome(new int[]{1, 2, 3}));//False
        System.out.println(isPalindrome(new int[]{1, 2, 3, 3, 2, 1}));//True
        System.out.println(isPalindrome(new int[]{1, 2, 2, 1}));//True
        System.out.println(isPalindrome(new int[]{1}));//False

    }

    static boolean isPalindrome(int[] nodeArr) {
        Node head = buildSingleLinkList(nodeArr);
        if (head == null || head.next == null) {
            return false;
        }
        Node oneStep = head;
        Node twoStep = head;
        int nodeCnt = 1;
        Node leftHalfHead = new Node();
        leftHalfHead.data = oneStep.data;
        leftHalfHead.next = null;
        while (twoStep != null && twoStep.next != null && twoStep.next.next != null) {
            Node node = new Node();
            node.data = oneStep.next.data;
            node.next = leftHalfHead;
            leftHalfHead = node;

            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            nodeCnt += 2;
        }
        if (twoStep != null & twoStep.next != null) {
            nodeCnt += 1;
        }

        Node rightHalfHead = oneStep.next;
        if (nodeCnt % 2 != 0) {
            leftHalfHead = leftHalfHead.next;
        }
        while (leftHalfHead != null && rightHalfHead != null && leftHalfHead.data == rightHalfHead.data) {
            leftHalfHead = leftHalfHead.next;
            rightHalfHead = rightHalfHead.next;
        }

        return leftHalfHead == null && rightHalfHead == null;
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
