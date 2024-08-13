
"""
title  : 15654. N과 M (5) (Silver 3)
time   : 128ms      172ms
memory : 35556KB    116200KB
"""

import sys
from itertools import permutations

def solution():
    input = sys.stdin.readline

    N, M = map(int, input().split())
    numbers = list(map(int, input().split()))

    for temp in list(permutations(sorted(numbers), M)):
        print(" ".join(map(str, temp)))

solution()