
"""
title  : 9095. 1, 2, 3 더하기 (Silver 3)
time   : 40ms        108ms
memory : 31120KB     108080KB
"""

import sys

def solution():
    input = sys.stdin.readline

    T = int(input())
    for _ in range(T):

        N = int(input())

        table = [0] * (4 if N < 3 else (N+1))
        table[1] = 1    # 1
        table[2] = 2    # 1+1, 2
        table[3] = 4    # 1+1+1, 2+1, 1+2, 3

        for num in range(4, N+1):
            table[num] = table[num-3] + table[num-2] + table[num-1]

        print(table[N])

solution()