
"""
title  : 6603. 로또 (Silver 2)
time   : 44ms       128ms
memory : 31120KB    110932KB
"""

import sys
from itertools import combinations

def solution():
    input = sys.stdin.readline

    while True:

        command = list(map(int, input().split()))

        if command[0] == 0:
            return
        
        for ans in list(combinations(command[1:], 6)):
            print(*ans)

        print()

solution()