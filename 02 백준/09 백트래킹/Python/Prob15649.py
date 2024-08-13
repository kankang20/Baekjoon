
"""
title  : 15649. N과 M (1) (Silver 3)
time   : 72ms       144ms
memory : 35556KB    116200KB
"""

import sys
from itertools import permutations

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    number = [str(idx+1) for idx in range(N)]
    
    for temp in list(permutations(number, M)):
        print(" ".join(temp))

solution()