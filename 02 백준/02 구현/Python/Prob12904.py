
"""
title  : 12904. A와 B (Gold 5)
time   : 48ms      X
memory : 31120KB   메모리초과
"""

import sys
sys.setrecursionlimit(10**6)

def solution():
    input = sys.stdin.readline

    S = input().rstrip()
    T = input().rstrip()

    target = T

    while len(S) <= len(target):

        if target[-1] == 'A':
            target = target[:-1]
        else:
            target = target[:-1]
            target = target[::-1]
        
        if target == S:
            return 1

    return 0

print(solution())