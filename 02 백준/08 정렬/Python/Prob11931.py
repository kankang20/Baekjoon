
"""
title  : 11931. 수 정렬하기 4 (Silver 5)
time   : 1272ms      628ms
memory : 84752KB     137480KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    numbers = [int(input()) for _ in range(N)]

    for num in sorted(numbers, reverse=True):
        print(num)

solution()