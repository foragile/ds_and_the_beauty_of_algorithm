#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File    : link.impl.IsLoopSingleLinkImpl.py


class Node:
    data = 0
    next = None


def is_loop(head):
    if head is None:
        return False

    if (head.next is not None) and (head.next == head):
        return True
    p1 = head
    p2 = head

    while (p1.next is not None) and (p2.next.next is not None):
        p1 = p1.next
        p2 = p2.next.next
        if p1 == p2:
            return True

    return False


def build_single_link_list(setLoop):
    node1 = Node()
    node1.data = 1

    node2 = Node()
    node2.data = 2

    node3 = Node()
    node3.data = 3

    node4 = Node()
    node4.data = 4

    node1.next = node2
    node2.next = node3
    node3.next = node4

    if setLoop:
        node4.next = node1

    return node1


if __name__ == '__main__':
    head = build_single_link_list(True)
    isLoop = is_loop(head)
    if isLoop:
        print("right,it's a loop list")
    else:
        print("wrong,it's a loop list")
