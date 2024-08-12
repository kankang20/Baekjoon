
"""
title  : 7353. 나무 심기 (Level 1)
time   : 109ms
memory : 37.02MB
"""

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    land = sorted(list(map(int, input().split())))

    print(max(land[0]*land[1], land[N-2]*land[N-1]))
    
solution()