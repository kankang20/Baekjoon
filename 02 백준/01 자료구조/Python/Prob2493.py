
"""
title  : 2493. 탑 (Gold 5)
time   : 480ms       288ms
memory : 114460KB    207684KB
"""

import sys

def solution():
    input = sys.stdin.readline

    N = int(input())
    wall = list(map(int, input().split()))

    answer = [0] * N
    
    stack = [(1, wall[0])]
    for wdx in range(1, N):

        while stack and stack[-1][1] <= wall[wdx]:
            stack.pop()

        answer[wdx] = stack[-1][0] if stack else 0
        stack.append((wdx+1, wall[wdx]))

    print(*answer)

solution()