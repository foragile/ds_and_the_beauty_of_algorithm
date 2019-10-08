#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File    : StackOfArrayImpl.py


class StackOfArray:
    data = []
    N = 0

    def __init__(self):
        data = []
        N = 0

    def __iter__(self):
        return self

    def __next__(self):
        if self.N > 1:
            self.N = self.N - 1
            return self.data[self.N]
        else:
            raise StopIteration()
