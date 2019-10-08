#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File    : RemoveNthFromEndImpl.py


class Node:
    data = 0
    next = None


def build_single_linke_list(nodeArr):
    head = None
    pnext = None

    for i in nodeArr:
        node = Node()
        node.data = i
        if head is None:
            head = node
            pnext = head
        else:
            pnext.next = node
            pnext = node

    return head


def removeNthNodeFromEnd(head, n):
    p1 = head
    i = 0
    while i < n:
        if p1 is not None:
            p1 = p1.next
        else:
            break
        i += 1

    # 总结点数少于n
    if i < n:
        return head

    # 总结点数等于n个，倒数第n个结点即为首结点,删除首结点
    if p1 is None:
        head = head.next
        return head
    p2 = head
    # p1达到链表尾端，p2的next结点即为倒数第n个结点
    while p1.next is not None:
        p1 = p1.next
        p2 = p2.next

    # p2的next结点即为倒数第n个结点，删除该结点
    p2.next = p2.next.next

    return head


if __name__ == '__main__':
    head = build_single_linke_list([1])
    print("remove the 2th node from end:")
    head=removeNthNodeFromEnd(head,2)
    while head is not None:
        print(head.data)
        head = head.next

    head = build_single_linke_list([1,2])
    print("remove the 2th node from end:")
    head=removeNthNodeFromEnd(head,2)
    while head is not None:
        print(head.data)
        head = head.next

    head = build_single_linke_list([1,2,3])
    print("remove the 2th node from end:")
    head=removeNthNodeFromEnd(head,2)
    while head is not None:
        print(head.data)
        head = head.next

    head = build_single_linke_list([1,2,3,4,5])
    print("remove the 2th node from end:")
    head=removeNthNodeFromEnd(head,2)
    while head is not None:
        print(head.data)
        head = head.next

