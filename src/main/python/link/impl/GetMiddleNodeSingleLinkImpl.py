#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File    : GetMiddleNodeSingleLinkImpl.py


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


def get_middle_node(head):
    p1 = head
    p2 = head
    while p2 is not None and p2.next is not None and p2.next.next is not None:
        p1 = p1.next
        p2 = p2.next.next
    # 结点个数为奇数
    if p2 is not None:
        return p1
    else:
        return p1.next


if __name__ == '__main__':
    head = build_single_link_list([1, 3])
    middle = get_middle_node(head)
    if middle.data == 1:
        print("right")
    else:
        print("wrong")

    head = build_single_link_list([1, 3, 5, 7])
    middle = get_middle_node(head)
    if middle.data == 3:
        print("right")
    else:
        print("wrong")

    head = build_single_link_list([1, 3, 5, 7, 8])
    middle = get_middle_node(head)
    if middle.data == 5:
        print("right")
    else:
        print("wrong")