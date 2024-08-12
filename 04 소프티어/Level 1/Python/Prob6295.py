
"""
title  : 6295. A+B (Level 1)
time   : 106ms
memory : 37.31MB
"""

import sys

def solution():
    input = sys.stdin.readline

    T = int(input())
    for t in range(T):

        A, B = map(int, input().split())

        print("Case #{0}: {1}".format(t+1, A+B))

solution()