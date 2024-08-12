
"""
title  : 7695. [한양대 HCPC 2023] Tren del Fin del Mundo (Level 1)
time   : 103ms
memory : 37.06MB
"""

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())

    coor = []
    
    for _ in range(N):
        x, y = map(int, input().split())
        coor.append((x, y))

    answer = min(coor, key=lambda x:x[1])
    print(answer[0], answer[1])
    
solution()