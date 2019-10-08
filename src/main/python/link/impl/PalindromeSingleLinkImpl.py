#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File    : PalindromeSingleLinkImpl.py


class Node:
    data = 0
    next = None


def is_palindrome(node_arr):
    head_node = build_single_link_list(node_arr)
    if head_node is None or head_node.next is None:
        return False
    one_step = head_node
    two_step = head_node
    left_half_head = Node()
    left_half_head.data = one_step.data
    left_half_head.next = None
    node_cnt = 1
    while (two_step is not None) and (two_step.next is not None) and (two_step.next.next is not None):
        node = Node()
        node.data = one_step.next.data
        node.next = left_half_head
        left_half_head = node

        one_step = one_step.next
        two_step = two_step.next.next
        node_cnt += 2
    if two_step is not None and two_step.next is not None:
        node_cnt += 1
    right_half_head = one_step.next
    if node_cnt % 2 != 0:
        left_half_head = left_half_head.next
    while (left_half_head is not None) and (right_half_head is not None) and (
            left_half_head.data == right_half_head.data):
        left_half_head = left_half_head.next
        right_half_head = right_half_head.next

    return left_half_head is None and right_half_head is None


def build_single_link_list(node_arr):
    head_node = None
    next_node = None
    for i in node_arr:
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


if __name__ == '__main__':
    print(is_palindrome([1, 2, 3, 2, 1]))#True
    print(is_palindrome([1, 1]))#True
    print(is_palindrome([1, 2, 3]))#False
    print(is_palindrome([1, 2, 3, 3, 2, 1]))#True
    print(is_palindrome([1, 2, 2, 1]))#True
    print(is_palindrome([1]))#False
