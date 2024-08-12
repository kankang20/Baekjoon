
"""
title  : 6280. 지도 자동 구축 (Level 2)
time   : 108ms
memory : 37.31MB
"""

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())

    # 0 (2*2 = 4) - 1 (3*3 = 9) - 2 (5*5 = 25) - 3 (9*9 = 81)

    dot = 2
    for _ in range(N):
        dot += (dot-1)

    print(dot*dot)
    
solution()