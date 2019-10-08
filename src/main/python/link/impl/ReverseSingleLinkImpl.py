#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File    : ReverseSingleLinkImpl.py

class Node:
    data = 0
    next = None


def build_single_link_list(nodeArr):
    head_node = None
    next_node = None
    for i in nodeArr:
        node = Node()
        node.data = i
        node.next = None
        if head_node is None:
            head_node = node
            next_node = head_node
        else:
            next_node.next = node
            next_node = node

    return head_node


def reverse1(head):
    if head is None or head.next is None:
        return head
    current = head
    pre = None
    pnext = None
    while current is not None:
        pnext = current.next
        current.next = pre
        pre = current
        current = pnext

    return pre


def reverse2(current):
    if current.next is None:
        return current
    pnext = current.next
    current.next = None
    reversed = reverse2(pnext)
    pnext.next = current

    return reversed


def reverse3(current, pre):
    if current.next is None:
        current.next = pre
        return current
    else:
        pnext = current.next
        current.next = pre
        return reverse3(pnext, current)


if __name__ == '__main__':
    head = build_single_link_list([1, 2, 3, 4, 5])
    head = reverse1(head)
    print("impl1:")
    while head is not None:
        print(head.data)
        head = head.next
    print("impl2:")
    head = build_single_link_list([1, 2, 3, 4, 5])
    head = reverse2(head)
    while head is not None:
        print(head.data)
        head = head.next
    print("impl3:")
    head = build_single_link_list([1, 2, 3, 4, 5])
    head = reverse3(head,None)
    while head is not None:
        print(head.data)
        head = head.next
