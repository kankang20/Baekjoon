
"""
title  : 7626. 연탄 배달의 시작 (Level 1)
time   : 98ms
memory : 37.03MB
"""

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    town = list(map(int, input().split()))

    min_diff = town[N-1] - town[0]
    diff = [0] * (N-1)
    
    for idx in range(N-1):
        diff[idx] = town[idx+1] - town[idx]
        min_diff = min(min_diff, diff[idx])

    print(diff.count(min_diff))
    
solution()