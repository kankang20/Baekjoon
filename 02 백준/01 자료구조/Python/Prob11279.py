
"""
title  : 11279. 최대 힙 (Silver 2)
time   : 108ms       208ms
memory : 37044KB     114144KB
"""

import sys
from heapq import heappush, heappop

def solution():

    input = sys.stdin.readline
    N = int(input())                # 연산의 개수

    answer = []
    
    for _ in range(N):

        command = int(input())

        if command:
            heappush(answer, -command)
        else:
            print(-(heappop(answer)) if answer else 0)

solution()