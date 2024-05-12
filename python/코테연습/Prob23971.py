
""" 브론즈 3. ZOAC 4 """

import sys
from collections import deque

def solution():
    input = sys.stdin.readline
    
    R, C, N, M = map(int, input().split())

    W = (R // (N+1)) + (1 if R % (N+1) else 0)
    H = (C // (M+1)) + (1 if C % (M+1) else 0)

    return W * H

print(solution())