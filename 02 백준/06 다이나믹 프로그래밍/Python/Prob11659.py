
"""
title  : 11659. 구간 합 구하기 4 (Silver 3)
time   : 232ms       196ms
memory : 41116KB     121636KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())

    numbers = list(map(int, input().split()))
    table = [0] * (N+1)

    previous = 0
    for idx in range(N):
        previous += numbers[idx]
        table[idx+1] = previous

    for _ in range(M):
        s, t = map(int, input().split())
        print(table[t] - table[s-1])

solution()