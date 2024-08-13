
"""
title  : 23971. ZOAC 4 (Bronze 3)
time   : 68ms      140ms
memory : 34000KB   112004KB
"""

import sys
from collections import deque

def solution():
    input = sys.stdin.readline
    
    R, C, N, M = map(int, input().split())

    W = (R // (N+1)) + (1 if R % (N+1) else 0)
    H = (C // (M+1)) + (1 if C % (M+1) else 0)

    return W * H

print(solution())