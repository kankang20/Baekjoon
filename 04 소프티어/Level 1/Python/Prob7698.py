
"""
title  : 7698. [한양대 HCPC 2023] 개표 (Level 1)
time   : 107ms
memory : 37.05MB
"""

import sys

def solution():
    input = sys.stdin.readline

    T = int(input())
    for _ in range(T):
        N = int(input())
        print("++++ " * (N // 5) + "|" * (N % 5))

solution()