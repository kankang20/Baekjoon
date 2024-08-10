
"""
title  : 1822. 차집합 (Silver 4)
time   : 944ms       648ms
memory : 131220KB    268028KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    A = set(list(map(int, input().split())))
    B = set(list(map(int, input().split())))

    answer = list(A - B)

    print(len(answer))
    for ans in sorted(answer):
        print(ans, end = " ")

solution()