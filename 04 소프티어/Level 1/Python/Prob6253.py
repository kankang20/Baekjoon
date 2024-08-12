
"""
title  : 6253. 주행거리 비교하기 (Level 1)
time   : 106ms
memory : 37.32MB
"""

import sys

def solution():
    input = sys.stdin.readline

    A, B = map(int, input().split())

    if A > B:
        print("A")
    elif A < B:
        print("B")
    else:
        print("same")

solution()