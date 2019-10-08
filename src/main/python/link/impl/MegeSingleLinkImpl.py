#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File    : MegeSingleLinkImpl.py


class Node:
    data = 0
    next = None


def build_single_link_list(nodeArr):
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


def merge(l1, l2):
    if l1 is None or l2 is None:
        return l1 if l1 is not None else l2

    l = Node()
    p = l
    while l1 is not None and l2 is not None:
        if l1.data <= l2.data:
            p.next = l1
            p = l1
            l1 = l1.next
        else:
            p.next = l2
            p = l2
            l2 = l2.next
    p.next = l1 if l1 is not None else l2

    return l


if __name__ == '__main__':
    l1 = build_single_link_list([1, 3, 5, 8])
    l2 = build_single_link_list([2, 4, 6, 9, 10])
    head = merge(l1, l2)
    print("merged:")
    while head is not None:
        print(head.data)
        head = head.next
